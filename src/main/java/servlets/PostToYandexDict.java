package main.java.servlets;

import main.java.utils.ConstantManager;
import main.java.utils.RequestExecutor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Valdis003
 * on 14.05.2017
 * for VocMasterDist
 */
public class PostToYandexDict extends HttpServlet {
    RequestExecutor rex = new RequestExecutor();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // FOR CYRILLIC
        resp.setContentType("text/html; charset=UTF-8"); // FOR CYRILLIC

        String urlParameters = "key=" + ConstantManager.DictionaryKey
                + "&text=" + req.getParameter("text") + "&lang=en-ru";

        String dictResponse = rex.executePost(ConstantManager.DictionaryURL, urlParameters);
        resp.getWriter().write(dictResponse);
        resp.setCharacterEncoding("UTF-8"); // FOR CYRILLIC
    }
}
