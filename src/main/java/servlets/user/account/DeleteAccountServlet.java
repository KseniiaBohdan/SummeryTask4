package servlets.user.account;

import data.entity.Card;
import org.apache.log4j.Logger;
import service.CardService;
import service.impl.AccountRequestServiceImpl;
import service.impl.CardServiceImpl;
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

public class DeleteAccountServlet extends HttpServlet {

    private static final String USER = "user";
    private static final String ACCOUNT_ID = "accountId";
    private static final String ACCOUNT_LIST = "accountList";
    private static final Logger LOGGER = Logger.getLogger(DeleteAccountServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AccountService accountService = new AccountServiceImpl();
        Long userId = ((User)session.getAttribute(USER)).getId();
        List<Account> accountList = accountService.getByUserId(Long.valueOf(userId));
        accountService.removeAccountByStatus(accountList, Status.DELETED);
        for (int i=0; i<accountList.size(); i++){
            if(accountList.get(i).getStatus() == Status.DELETED){
                accountList.remove(i);
            }
        }
        req.setAttribute(ACCOUNT_LIST, accountList);
        req.getRequestDispatcher(PageConstant.DELETE_ACCOUNT).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("DeleteAccount starts");
        AccountService accountService = new AccountServiceImpl();
        Account account = accountService.getByAccountId(Long.valueOf(req.getParameter(ACCOUNT_ID)));
        account.setStatus(Status.DELETED);
        deleteAccountsCard(account);
        new AccountRequestServiceImpl().deleteByAccountId(account.getId());
        if (accountService.update(account)) {
            resp.sendRedirect(PageConstant.DELETE_ACCOUNT_SERVLET);
            LOGGER.debug("DeleteAccount ends successfully");
        } else {
            resp.sendRedirect(PageConstant.DELETE_ACCOUNT_SERVLET);
        }
    }

    private void deleteAccountsCard(Account account) {
        CardService cardService = new CardServiceImpl();
        List<Card> cards = cardService.getByAccountId(account.getId());
        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).setStatus(Status.DELETED);
        }
        cardService.update(cards);
    }
}
