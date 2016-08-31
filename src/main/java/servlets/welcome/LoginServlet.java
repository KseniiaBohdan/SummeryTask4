package servlets.welcome;

import data.entity.Role;
import data.entity.Status;
import data.entity.User;
import service.impl.UserServiceImpl;
import servlets.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static final String USER = "user";
    private static final String PASSWORD = "Password";
    private static final String EMAIL = "Email";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageConstant.LOGIN).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter(EMAIL);
        String password = req.getParameter(PASSWORD);
        HttpSession session = req.getSession();
        UserServiceImpl userService = new UserServiceImpl();

        try {
            User user = userService.getByEmail(email);
            if (validUser(user, password)) {
                session.setAttribute(USER, user);
                if (user.getRole().equals(Role.USER)) {
                    resp.sendRedirect(PageConstant.PROFILE_SERVLET);
                }
                if (user.getRole().equals(Role.ADMIN)) {
                    resp.sendRedirect(PageConstant.ADMIN_PROFILE_SERVLET);
                }
            } else {
                resp.sendRedirect(PageConstant.LOGIN_SERVLET);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean validUser(User user, String password) {
        return (user != null
                && user.getStatus() != Status.DELETED
                && user.getPassword().equals(password));
    }

}
