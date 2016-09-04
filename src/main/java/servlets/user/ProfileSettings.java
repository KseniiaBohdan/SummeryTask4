package servlets.user;

import data.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import service.UserService;
import service.impl.UserServiceImpl;
import servlets.EncodingFilter;
import servlets.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfileSettings extends HttpServlet {

    private static final String UPDATE_RESULT = "updateResult";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String USER = "user";
    private static final Logger LOGGER = Logger.getLogger(ProfileSettings.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(UPDATE_RESULT, req.getSession().getAttribute(UPDATE_RESULT));
        req.getSession().setAttribute(UPDATE_RESULT, null);
        req.getRequestDispatcher(PageConstant.PROFILE_SETTINGS).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("ProfileSettings start");
        UserService userService = new UserServiceImpl();
        String email = req.getParameter(EMAIL);
        String password = req.getParameter(PASSWORD);
        String phoneNumber = req.getParameter(PHONE_NUMBER);
        User user = (User) req.getSession().getAttribute(USER);

        if (checkInput(email, password, phoneNumber, user)) {
            if (userService.update(user)) {
                req.getSession().setAttribute(UPDATE_RESULT, StringUtils.EMPTY);
                LOGGER.debug("ProfileSettings ends successfully");
            }
        }
        resp.sendRedirect(PageConstant.PROFILE_SETTINGS_SERVLET);
    }

    private boolean checkInput(String email, String password, String phoneNumber, User user) {
        boolean a = false, b = false, c = false;
        if (emailValid(email, user)) {
            user.setEmail(email);
            a = true;
        }
        if (passwordValid(password, user)) {
            user.setPassword(password);
            b = true;
        }
        if (phoneNumberValid(phoneNumber, user)) {
            user.setPhoneNumber(phoneNumber);
            c = true;
        }
        return a | b | c;
    }

    private boolean phoneNumberValid(String phoneNumber, User user) {
        if (!StringUtils.isNotBlank(phoneNumber)) {
            return false;
        }
        if (user.getPhoneNumber().equals(phoneNumber)) {
            return false;
        }
        if (new UserServiceImpl().getByPhoneNumber(phoneNumber) != (null)) {
            return false;
        }
        return true;
    }

    private boolean passwordValid(String password, User user) {
        if (!StringUtils.isNotBlank(password)) {
            return false;
        }
        if (user.getPassword().equals(password)) {
            return false;
        }
        return true;
    }

    private boolean emailValid(String email, User user) {
        if (!StringUtils.isNotBlank(email)) {
            return false;
        }
        if (new UserServiceImpl().getByEmail(email).equals(null)) {
            return false;
        }
        if (user.getEmail().equals(email)) {
            return false;
        }
        return true;
    }


}
