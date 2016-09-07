package servlets.user.card;

import data.entity.Status;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import servlets.constant.PageConstant;
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
    private static final String PIN1 = "pin1";
    private static final String PIN2 = "pin2";
    private static final String TITLE = "title";
    private static final Logger LOGGER = Logger.getLogger(AddCardServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("addCardResult", session.getAttribute("addCardResult"));
        session.setAttribute("addCardResult", null);
        Long userId = ((User) session.getAttribute(USER)).getId();
        AccountService accountService = new AccountServiceImpl();
        List<Account> accountList = accountService.getByUserId(userId);
        req.setAttribute(ACCOUNT_LIST, accountList);
        accountService.removeAccountByStatus(accountList, Status.DELETED);
        req.getRequestDispatcher(PageConstant.ADD_CARD).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("AddCard starts");
        java.util.Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter(EXPIRY_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Integer pin1 = Integer.valueOf(req.getParameter(PIN1));
        Integer pin2 = Integer.valueOf(req.getParameter(PIN2));

        HttpSession session = req.getSession();
        Long id = ((User) session.getAttribute(USER)).getId();
        Card card = new Card();
        card.setCardNumber(Long.valueOf(req.getParameter(CARD_NUMBER)));
        card.setUserId(id);
        card.setExpiryDate(date);
        card.setPin(pin1);
        card.setTitle(req.getParameter(TITLE));
        card.setAccountId(Long.valueOf(req.getParameter(ACCOUNT_ID)));
        CardService cardService = new CardServiceImpl();
        if (cardValid(card, cardService, pin1, pin2)) {
            if (cardService.create(card)) {
                req.getSession().setAttribute("addCardResult", StringUtils.EMPTY);
                resp.sendRedirect(PageConstant.ADD_CARD_SERVLET);
                LOGGER.debug("AddCard successfully");
            }
        }else {
            resp.sendRedirect(PageConstant.ADD_CARD_SERVLET);
        }
    }

    private boolean cardValid(Card card, CardService cardService, Integer p1, Integer p2) {
        if (cardService.getByCardNumber(card.getCardNumber()) == null
                && p1.equals(p2)) {
            return true;
        } else {
            return false;
        }
    }

}
