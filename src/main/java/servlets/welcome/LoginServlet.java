package servlets.welcome;

import data.entity.Role;
import data.entity.Status;
import data.entity.User;
import org.apache.log4j.Logger;
import service.impl.UserServiceImpl;
import service.utils.Password;
import servlets.EncodingFilter;
import servlets.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

public class LoginServlet extends HttpServlet {

    private static final String USER = "user";
    private static final String PASSWORD = "Password";
    private static final String EMAIL = "Email";
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
    private static final String PUT_MONEY_RESULT = "putMoneyResult";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute(USER);
        if (Objects.nonNull(user)) {
            if (user.getRole().equals(Role.USER)) {
                resp.sendRedirect(PageConstant.PROFILE_SERVLET);
            }
            if(user.getRole().equals(Role.ADMIN)){
                resp.sendRedirect(PageConstant.ADMIN_PROFILE_SERVLET);
            }
        }
        req.setAttribute(PUT_MONEY_RESULT, req.getSession().getAttribute(PUT_MONEY_RESULT));
        req.getSession().setAttribute(PUT_MONEY_RESULT, null);
        req.getRequestDispatcher(PageConstant.LOGIN).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter(EMAIL);
        String password = Password.hash(req.getParameter(PASSWORD));
        HttpSession session = req.getSession();
        UserServiceImpl userService = new UserServiceImpl();

        User user = userService.getByEmail(email);
        if (validUser(user, password)) {
            session.setAttribute(USER, user);
            if (user.getRole().equals(Role.USER)) {
                resp.sendRedirect(PageConstant.PROFILE_SERVLET);
                LOGGER.trace("User: " + user.getEmail() + " login");
            }
            if (user.getRole().equals(Role.ADMIN)) {
                resp.sendRedirect(PageConstant.ADMIN_PROFILE_SERVLET);
                LOGGER.trace("Admin: " + user.getEmail() + " login");
            }
        } else {
            resp.sendRedirect(PageConstant.LOGIN_SERVLET);
        }
    }

    private static boolean validUser(User user, String password) {
        return (user != null
                && user.getStatus() != Status.DELETED
                && user.getPassword().equals(password));
    }

}
