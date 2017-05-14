package main.java.servlets;

import main.java.entities.Card;
import main.java.entities.Context;
import main.java.entities.User;
import main.java.entities.Word;
import main.java.utils.dao.DaoFactory;
import main.java.utils.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Valdis003
 * on 13.05.2017
 * for VocMasterDist
 */
public class AddCardServlet extends HttpServlet {
    Session session;
    DaoFactory daoFactory = DaoFactory.getInstance();
    UserDao userDao = daoFactory.getUserDao();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);

        if (httpSession != null) {

            String dictRespose = (String) httpSession.getAttribute("dict_respose");
            System.out.println("XXXXXXXXXXXXX");
            System.out.println(dictRespose);
            System.out.println("XXXXXXXXXXXXX");


            int gNumber = Integer.parseInt(req.getParameter("gnumber"));
            String source = req.getParameter("source");
            int word_id = Integer.parseInt(req.getParameter("word_id"));
            int translation_id = Integer.parseInt(req.getParameter("translation_id"));
            String context = req.getParameter("context");
            int user_id = Integer.parseInt(req.getParameter("user_id"));


            Transaction transaction = session.beginTransaction();

            Context context1 = new Context();
            context1.setText(context);

            Card card = new Card();
            card.setWord(session.get(Word.class, word_id));
//            card.setTranslation(session.get(Word.class, translation_id));
            card.setContext(context1);
            card.setSource(source);

            User user = session.get(User.class, user_id);
            ArrayList<Card> cards = new ArrayList<>();
            cards.add(card);
            user.setCards(cards);

            session.save(context1);
            session.save(card);
            session.save(user);
            transaction.commit();
            session.close();
        } else {
            resp.getWriter().write("WRONG_SESSION");
        }
    }
}
