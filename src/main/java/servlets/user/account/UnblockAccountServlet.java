package servlets.user.account;

import data.entity.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import service.AccountRequestService;
import service.AccountService;
import service.impl.AccountRequestServiceImpl;
import service.impl.AccountServiceImpl;
import servlets.ContextListener;
import servlets.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UnblockAccountServlet extends HttpServlet {

    private static final String USER = "user";
    private static final String ACCOUNT_LIST = "accountList";
    private static final String ACCOUNT_ID = "accountId";
    private static final String UNBLOCK_ACCOUNT_REQUEST_RESULT = "unblockAccountRequestResult";
    private static final String TITLE = "title";
    private static final Logger LOGGER = Logger.getLogger(UnblockAccountServlet.class);


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute(UNBLOCK_ACCOUNT_REQUEST_RESULT, session.getAttribute(UNBLOCK_ACCOUNT_REQUEST_RESULT));
        session.setAttribute(UNBLOCK_ACCOUNT_REQUEST_RESULT, null);
        Long userId = ((User) session.getAttribute(USER)).getId();
        AccountService accountService = new AccountServiceImpl();
        List<Account> accountList = accountService.getByUserId(userId);
        accountService.removeAccountByStatus(accountList, Status.ACTIVE, Status.DELETED);
        req.setAttribute(ACCOUNT_LIST, accountList);
        req.getRequestDispatcher(PageConstant.UNBLOCK_ACCOUNT).include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("UnblockAccount starts");
        Long accountId = Long.valueOf(req.getParameter(ACCOUNT_ID));
        String title = req.getParameter(TITLE);
        AccountRequest accountRequest = new AccountRequest(accountId, title);
        AccountRequestService ars = new AccountRequestServiceImpl();
        if (ars.create(accountRequest)) {
            req.getSession().setAttribute(UNBLOCK_ACCOUNT_REQUEST_RESULT, StringUtils.EMPTY);
            resp.sendRedirect(PageConstant.UNBLOCK_ACCOUNT_SERVLET);
            LOGGER.debug("UnblockAccount ends successfully");
        }
    }
}
