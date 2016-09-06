package servlets.user.account;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import servlets.ContextListener;
import servlets.PageConstant;
import data.entity.Account;
import data.entity.User;
import service.AccountService;
import service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddAccountServlet extends HttpServlet {

    private static final String TITLE = "title";
    private static final String USER = "user";
    private static final String ID = "accountId";
    private static final Logger LOGGER = Logger.getLogger(AddAccountServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("addAccountResult", session.getAttribute("addAccountResult"));
        session.setAttribute("addAccountResult", null);
        req.getRequestDispatcher(PageConstant.ADD_ACCOUNT).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("AddAccount starts");
        AccountService accountService = new AccountServiceImpl();
        HttpSession session = req.getSession();
        Long userId = ((User) session.getAttribute(USER)).getId();
        int accountNumber = accountService.getByUserId(userId).size() + 1;
        Account account = new Account();
        account.setId(Long.valueOf(req.getParameter(ID)));
        account.setNumber(accountNumber);
        account.setTitle(req.getParameter(TITLE));
        account.setUserId(userId);
        if (AccountValid(account, accountService)) {
            if (accountService.create(account)) {
                req.getSession().setAttribute("addAccountResult", StringUtils.EMPTY);
                resp.sendRedirect(PageConstant.ADD_ACCOUNT_SERVLET);
                LOGGER.debug("AddAccount ends successfully");
            }
        } else {
            resp.sendRedirect(PageConstant.ADD_ACCOUNT_SERVLET);
        }
    }

    private boolean AccountValid(Account account, AccountService accountService) {
        if (accountService.getByAccountId(account.getId()) == null) {
            return true;
        } else {
            return false;
        }
    }
}
