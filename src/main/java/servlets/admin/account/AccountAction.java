package servlets.admin.account;

import org.apache.commons.lang.StringUtils;
import service.comand.container.CommandContainer;
import servlets.constant.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccountAction extends HttpServlet {

    private static final String ACCOUNT_ID = "accountId";
    private static final String ACTION = "action";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardNumber = req.getParameter(ACCOUNT_ID);
        String action = req.getParameter(ACTION);
        Map<String, Object> params = new HashMap();
        params.put(ACCOUNT_ID, cardNumber);
        if(!CommandContainer.getAccountCommand(action).execute(null, params).equals(null)){
            req.getSession().setAttribute("accountUnblockResult", StringUtils.EMPTY);
        }
        resp.sendRedirect(PageConstant.UNBLOCK_REQUESTS_ACCOUNT_SERVLET);
    }
}
