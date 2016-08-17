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
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        UserServiceImpl service = new UserServiceImpl();
        try {
            User user = service.getByEmail(email);
            if (user != null && user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                resp.setContentType("text/html");
                req.getRequestDispatcher("profilePage.jsp").include(req, resp);
            } else {
                resp.setContentType("text/html");
                req.setAttribute("error", "wrong email or password");
                req.getRequestDispatcher("errorPage.jsp").include(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
