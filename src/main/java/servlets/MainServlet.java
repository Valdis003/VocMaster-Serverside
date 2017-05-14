package main.java.servlets;

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
public class MainServlet extends HttpServlet {
    RequestDispatcher dispatcher;


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        System.out.println("something wrong here");
        if (session.getAttribute("user") == null) {
            dispatcher = req.getRequestDispatcher("jsps/index.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("jsps/main.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
