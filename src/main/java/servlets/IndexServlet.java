package main.java.servlets;

import main.java.entities.User;

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
public class IndexServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            dispatcher = req.getRequestDispatcher("jsps/index.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("jsps/main.jsp");
            User user = (User) session.getAttribute("user");
        }

        dispatcher.forward(req, resp);
    }
}
