package servlets.welcome;

import data.entity.User;
import org.apache.log4j.Logger;
import servlets.constant.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LogoutServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.trace("User " + ((User) req.getSession().getAttribute("user")).getEmail() + " was logout");
        req.getSession().invalidate();
        resp.sendRedirect(PageConstant.LOGIN_SERVLET);
    }
}
