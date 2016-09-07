package servlets.user.account;

import org.apache.log4j.Logger;
import servlets.constant.PageConstant;
import data.entity.Account;
import data.entity.Status;
import data.entity.User;
import service.AccountService;
import service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BlockAccountServlet extends HttpServlet {

    private static final String ACCOUNT_LIST = "accountList";
    private static final String ACCOUNT_ID = "accountId";
    private static final String USER = "user";
    private static final Logger LOGGER = Logger.getLogger(BlockAccountServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AccountService accountService = new AccountServiceImpl();
        Long userId = ((User)session.getAttribute(USER)).getId();
        List<Account> accountList = accountService.getByUserId(Long.valueOf(userId));
        accountService.removeAccountByStatus(accountList, Status.BLOCKED, Status.DELETED);

        for (int i = 0; i < accountList.size() ; i++) {
            if(accountList.get(i).getStatus() != Status.ACTIVE){
                accountList.remove(i);
            }
        }
        req.setAttribute(ACCOUNT_LIST, accountList);
        req.getRequestDispatcher(PageConstant.BLOCK_ACCOUNT).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("BlockAccount starts");
        AccountService accountService = new AccountServiceImpl();
        Long accountId = Long.valueOf(req.getParameter(ACCOUNT_ID));
        Account account = accountService.getByAccountId(accountId);
        account.setStatus(Status.BLOCKED);
        if (accountService.update(account)) {
            resp.sendRedirect(PageConstant.BLOCK_ACCOUNT_SERVLET);
            LOGGER.debug("Block account end successfully");
        } else {

        }
    }
}

