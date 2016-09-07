package servlets.admin.account;

import data.entity.AccountRequest;
import service.impl.AccountRequestServiceImpl;
import servlets.constant.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UnblockAccountRequest extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("accountUnblockResult", req.getSession().getAttribute("accountUnblockResult"));
        req.getSession().setAttribute("accountUnblockResult", null);
        List<AccountRequest> accountRequests = new ArrayList();
        accountRequests = new AccountRequestServiceImpl().getAll();
        req.setAttribute("accountRequests", accountRequests);
        req.getRequestDispatcher(PageConstant.UNBLOCK_REQUESTS_ACCOUNT).include(req, resp);
    }
}
