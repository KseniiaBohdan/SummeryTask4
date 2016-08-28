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

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(PageConstant.LOGIN_SERVLET);
    }
}
