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

    private static final String ACTION = "action";
    private static final String USER_ID = "userId";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter(USER_ID);
        String action = req.getParameter(ACTION);
        Map<String, Object> params = new HashMap();
        params.put(USER_ID, userId);
        CommandContainer.getUserCommand(action).execute(null, params);
        resp.sendRedirect(PageConstant.USER_MANAGEMENT_SERVLET);
    }

}
