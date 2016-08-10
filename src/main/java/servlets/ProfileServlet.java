package servlets;

import entity.User;
import service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("email", req.getParameter("email"));
        session.setAttribute("password", req.getParameter("password"));
        String email = String.valueOf(session.getAttribute("email"));
        String password = String.valueOf(session.getAttribute("password"));
        UserServiceImpl service = new UserServiceImpl();
        User user = null;
        try {
            user = service.getByEmail(email);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (user != null && user.getPassword().equals(password)) {
            resp.setContentType("text/html");
            req.getRequestDispatcher("profilePage.jsp").include(req, resp);
        } else {
            resp.setContentType("text/html");
            req.getRequestDispatcher("errorPage.jsp").include(req, resp);;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
