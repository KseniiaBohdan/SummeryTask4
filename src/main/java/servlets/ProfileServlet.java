package servlets;

import service.Test;
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
      /*  resp.setContentType("text/html");
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
            req.getRequestDispatcher("profilePage.jsp");
        } else {
            req.getRequestDispatcher("errorPage.jsp");
        }*/
        UserServiceImpl userService = new UserServiceImpl();
        try {
            userService.getByEmail("root");
            req.getRequestDispatcher("profilePage.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
