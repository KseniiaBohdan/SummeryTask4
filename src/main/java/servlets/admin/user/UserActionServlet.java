package servlets.admin.user;

import servlets.PageConstant;
import service.comand.container.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserActionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        String action = req.getParameter("action");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", userId);
        CommandContainer.getUserCommand(action).execute(null, params);
        resp.sendRedirect(PageConstant.USER_MANAGEMENT_SERVLET);
    }

}
