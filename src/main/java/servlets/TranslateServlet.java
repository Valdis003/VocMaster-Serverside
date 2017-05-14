package main.java.servlets;

import com.google.gson.Gson;
import main.java.entities.Meaning;
import main.java.entities.Word;
import main.java.utils.ConstantManager;
import main.java.utils.RequestExecutor;
import main.java.utils.dao.DaoFactory;
import main.java.utils.dao.WordDao;
import main.java.utils.to_user.Response;
import main.java.utils.yandex_dic_response.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Valdis003
 * on 05.05.2017
 * for VocMasterDist
 */
public class TranslateServlet extends HttpServlet {
    DaoFactory daoFactory = DaoFactory.getInstance();
    WordDao wordDao = daoFactory.getWordDao();
    RequestExecutor rex = new RequestExecutor();
    Gson gson = new Gson();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int code;
        req.setCharacterEncoding("UTF-8"); // FOR CYRILLIC
        resp.setContentType("text/html; charset=UTF-8"); // FOR CYRILLIC

        HttpSession httpSession = req.getSession();

        resp.getWriter().write(makeRequestFromText(req.getParameter("text"), httpSession));

        resp.setCharacterEncoding("UTF-8"); // FOR CYRILLIC
    }

    private String makeRequestFromText(String text, HttpSession httpSession) {
        String jsonResponse = "";
        text = text.trim();
        int wordsCount = text.split(" ").length;

        if (wordsCount == 1) {
            String urlParameters = "key=" + ConstantManager.DictionaryKey
                    + "&text=" + text + "&lang=en-ru";

            String dictResponse = rex.executePost(ConstantManager.DictionaryURL, urlParameters);
            httpSession.setAttribute("dict_response", dictResponse);

            Response response = cutDictResponse(dictResponse);
            httpSession.setAttribute("response", response);

            jsonResponse = gson.toJson(response);
        }
//        else if (wordsCount > 1) {
//            String urlParameters = "key=" + ConstantManager.TranslateKey
//                    + "&text=" + text + "&lang=en-ru";
//
//            jsonResponse = rex.executePost(ConstantManager.TranslateURL, urlParameters);
//        }

        return jsonResponse;
    }

    private Response cutDictResponse(String dictResponse) {
        Response response = new Response();
        YandexResponse yandexResponse = gson.fromJson(dictResponse, YandexResponse.class);
        Word mainWord = new Word();

        mainWord.setWord(yandexResponse.getDef().get(0).getText());
        mainWord.setTranscription(yandexResponse.getDef().get(0).getTs());

//        MAKE 5 GROUPS BY MEANING
//        TODO: SAVE OBJECTS TO DATABASE
        int k = 0;
        papaloop:
        for (Def def : yandexResponse.getDef()) {

            for (Tr tr : def.getTr()) {
                Meaning meaning = new Meaning();
                meaning.setTranslation(tr.getText());


                if (tr.getMean() != null)
                    for (Mean x : tr.getMean()) {
                        meaning.getSynonyms().add(x.getText());
                    }

                if (tr.getSyn() != null)
                    for (Syn x : tr.getSyn()) {
                        meaning.getAltTranslations().add(x.getText());
                    }

                response.getMeanings().add(meaning);
                k++;
                if (k > 4) {
                    break papaloop;
                }
            }
        }

        response.setWord(mainWord);

        return response;
    }
}
