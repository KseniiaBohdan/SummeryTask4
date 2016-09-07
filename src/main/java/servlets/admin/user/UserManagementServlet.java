package servlets.admin.user;

import data.entity.Status;
import data.entity.User;
import data.UserSort;
import org.apache.commons.lang.StringUtils;
import servlets.constant.PageConstant;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class UserManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        Long userId = ((User)req.getSession().getAttribute("user")).getId();
        List<User> users = userService.getAll();
        deleteExtra(users, userId);
        Status[] statuses = Status.values();
        req.setAttribute("statuses", statuses);

        if (StringUtils .isNotBlank(req.getParameter("Name"))) {
            List<String> name = new ArrayList(Arrays.asList(req.getParameter("Name").split(" ")));
            if (name.size() != 0 && name!=null) {
                req.setAttribute("Name", name);
                removeSameElement(name);
                users = userService.findByName(name);
            }
        }

        String statusFilter = req.getParameter("filterSelect");

        if (StringUtils.isNotBlank(statusFilter)) {
            req.setAttribute("filterSelect", statusFilter);
            users = filterByStatus(users, statusFilter, userService);
        }

//        String sort = req.getParameter("sortSelect");
//        if (StringUtils.isNotBlank(sort)) {
//            req.setAttribute("sortSelect", sort);
//            users = sortBy(users, sort);
//        }

        req.setAttribute("userList", users);
        req.getRequestDispatcher(PageConstant.USER_MANAGEMENT).include(req, resp);
    }

    private void deleteExtra(List<User> users, Long userId) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(userId)){
                users.remove(i);
                break;
            }
        }
    }

    private static List<User> sortBy(List<User> users, String sort) {
        if (sort.equals("SORT_NAME")) {
            Collections.sort(users, UserSort.SORT_NAME);
        }
        if (sort.equals("SORT_EMAIL")) {
            Collections.sort(users, UserSort.SORT_EMAIL);
        }
        if (sort.equals("SORT_PHONE_NUMBER")) {
            Collections.sort(users, UserSort.SORT_PHONE_NUMBER);
        }
        return users;
    }

    private static void removeSameElement(List<String> name) {
        if (name.size() > 1) {
            for (int i = 0; i < name.size(); i++) {
                for (int j = 1; j < name.size(); j++) {
                    if (name.get(i).equals(name.get(j))) {
                        name.remove(j);
                        --i;
                        --j;
                    }
                }
            }
        }
    }

    private static List<User> filterByStatus(List<User> users, String statusFilter, UserService userService) {
        if (!statusFilter.equals("ALL")) {
            for (int i = 0; i < users.size(); i++) {
                if (!users.get(i).getStatus().toString().equals(statusFilter)) {
                    users.remove(i);
                    --i;
                }
            }
        }
        return users;
    }


}
