package main.java.servlets.auth;

import main.java.entities.User;
import main.java.utils.dao.DaoFactory;
import main.java.utils.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Valdis003
 * on 14.05.2017
 * for VocMasterDist
 */
public class LoginServlet extends HttpServlet {
    RequestDispatcher dispatcher;
    DaoFactory daoFactory = DaoFactory.getInstance();
    UserDao userDao = daoFactory.getUserDao();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (session.getAttribute("user") == null) {
            User user = userDao.getUserByLoginAndPassword(login, password);

            if (user == null) {
                dispatcher = req.getRequestDispatcher("jsps/login.jsp");
                System.out.println("Wrong pass or log");
            } else {
                session = req.getSession(true);
                session.setAttribute("user", user);
                dispatcher = req.getRequestDispatcher("jsps/main.jsp");
            }
        } else {
            dispatcher = req.getRequestDispatcher("jsps/main.jsp");
        }

        dispatcher.forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            dispatcher = req.getRequestDispatcher("jsps/login.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("jsps/main.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
