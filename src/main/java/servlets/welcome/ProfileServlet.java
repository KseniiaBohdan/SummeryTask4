package servlets.welcome;

import constant.PageConstant;
import entity.Role;
import entity.Status;
import entity.User;
import service.UserService;
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
            if (validUser(user, password)) {
                if (user.getRoleId().equals(Role.CLIENT.ordinal()+1)) {
                    session.setAttribute("user", user);
                    resp.setContentType("text/html");
                    req.getRequestDispatcher(PageConstant.PROFILE).include(req, resp);
                }
                if (user.getRoleId() == Role.ADMIN.ordinal()+1) {
                    session.setAttribute("user", user);
                    resp.setContentType("text/html");
                    req.getRequestDispatcher("").include(req, resp);
                }
            } else {
                resp.setContentType("text/html");
                req.setAttribute("error", "wrong email or password");
                req.getRequestDispatcher("error.jsp").include(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean validUser(User user, String password) {
        return (user != null
                && user.getStatusId() != Status.DELETED.ordinal()+1
                && user.getPassword().equals(password));
    }
}
