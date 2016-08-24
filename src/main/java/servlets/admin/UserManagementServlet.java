package servlets.admin;

import constant.PageConstant;
import service.UserService;
import service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        req.setAttribute("userList", userService.getAllUsers());
        req.getRequestDispatcher(PageConstant.USER_MANAGEMENT).include(req, resp);
    }

}
