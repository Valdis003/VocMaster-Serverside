package main.java.servlets;

import main.java.entities.Card;
import main.java.entities.Context;
import main.java.entities.User;
import main.java.utils.dao.DaoFactory;
import main.java.utils.dao.UserDao;
import main.java.utils.dao.WordDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Valdis003
 * on 13.05.2017
 * for VocMasterDist
 */
public class AddCardServlet extends HttpServlet {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private WordDao wordDao = daoFactory.getWordDao();
    private UserDao userDao = daoFactory.getUserDao();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if (httpSession.getAttribute("user") != null) {

            int meaningId = Integer.parseInt(req.getParameter("gnumber"));
            String source = req.getParameter("source");
            int wordId = Integer.parseInt(req.getParameter("word_id"));
            String context_text = req.getParameter("context");
            String userLogin = ((User) httpSession.getAttribute("user")).getLogin();

            Context context = new Context();
            context.setText(context_text);
            wordDao.saveContext(context);

            Card card = new Card();
            card.setWord(wordDao.getWordById(wordId));
            card.setContext(context);
            card.setSource(source);
            card.setMeaning(wordDao.getMeaningById(meaningId));

            User user = userDao.getUserByLogin(userLogin);
            user.getCards().add(card);

            wordDao.saveCard(card);
            userDao.updateUser(user);

        } else {
            resp.getWriter().write("WRONG_SESSION");
        }
    }
}
