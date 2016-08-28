package servlets.welcome;

import data.dto.UserDto;
import data.entity.*;
import service.AccountService;
import service.CardService;
import service.impl.AccountServiceImpl;
import service.impl.CardServiceImpl;
import service.impl.UserServiceImpl;
import servlets.PageConstant;
import servlets.admin.card.CardActionServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageConstant.LOGIN).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("Email");
        String password = req.getParameter("Password");
        HttpSession session = req.getSession();
        UserServiceImpl userService = new UserServiceImpl();

        try {
            User user = userService.getByEmail(email);
            if (validUser(user, password)) {
                session.setAttribute("user", user);
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
