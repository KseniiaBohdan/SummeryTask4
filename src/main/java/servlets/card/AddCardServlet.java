package servlets.card;

import data.entity.Status;
import servlets.PageConstant;
import data.entity.Account;
import data.entity.Card;
import data.entity.User;
import service.AccountService;
import service.CardService;
import service.impl.AccountServiceImpl;
import service.impl.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AddCardServlet extends HttpServlet {

    private static final String ACCOUNT_ID = "accountId";
    private static final String EXPIRY_DATE = "expiryDate";
    private static final String USER = "user";
    private static final String ACCOUNT_LIST = "accountList";
    private static final String CARD_NUMBER = "cardNumber";
    private static final String PIN = "pin1";
    private static final String TITLE = "title";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userId = ((User) session.getAttribute(USER)).getId();
        AccountService accountService = new AccountServiceImpl();
        List<Account> accountList = accountService.getByUserId(userId);
        req.setAttribute(ACCOUNT_LIST, accountList);
        accountService.removeAccountByStatus(accountList, Status.DELETED);
        req.getRequestDispatcher(PageConstant.ADD_CARD).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        String parameter = req.getParameter(EXPIRY_DATE);
        java.util.Date date = null;
        try {
            date = in.parse(parameter);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        HttpSession session = req.getSession();
        Long id = ((User) session.getAttribute(USER)).getId();
        Card card = new Card();
        card.setCardNumber(Long.valueOf(req.getParameter(CARD_NUMBER)));
        card.setUserId(id);
        card.setExpiryDate(new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
        card.setPin(Integer.valueOf(req.getParameter(PIN)));
        card.setTitle(req.getParameter(TITLE));
        card.setAccountId(Long.valueOf(req.getParameter(ACCOUNT_ID)));
        CardService cardService = new CardServiceImpl();
        if (cardValid(card, cardService)) {
            if (cardService.create(card)) {
                resp.sendRedirect(PageConstant.ADD_CARD_SERVLET);
            }
        }else {

        }
    }

    private boolean cardValid(Card card, CardService cardService) {
        if (cardService.getByCardNumber(card.getCardNumber()) == null) {
            return true;
        } else {
            return false;
        }
    }

}
