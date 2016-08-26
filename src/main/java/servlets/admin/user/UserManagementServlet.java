package servlets.admin.user;

import data.entity.Status;
import data.entity.User;
import servlets.PageConstant;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAllUsers();
        Status[] statuses = Status.values();
        req.setAttribute("statuses", statuses);

        String statusFilter = req.getParameter("filterSelect");
        if (statusFilter != null) {
            if (!statusFilter.equals("ALL")) {
                for (int i = 0; i < users.size(); i++) {
                    if (!users.get(i).getStatus().toString().equals(statusFilter)) {
                        users.remove(i);
                        --i;
                    }
                }
            }
        }

        req.setAttribute("userList", users);
        req.getRequestDispatcher(PageConstant.USER_MANAGEMENT).include(req, resp);
    }
}
