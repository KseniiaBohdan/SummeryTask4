package servlets.welcome;

import data.entity.Account;
import data.entity.Atm;
import data.entity.Card;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import service.AccountService;
import service.impl.AccountServiceImpl;
import service.impl.AtmServiceImpl;
import service.impl.CardServiceImpl;
import servlets.constant.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PutMoneyServlet extends HttpServlet {

    private static final String CARD_NUMBER = "cardNumber";
    private static final String SUM = "sum";
    private static final String PIN = "pin";
    private static final Logger LOGGER = Logger.getLogger(PutMoneyServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("PutMoneyServlet start");
        Long cardNumber = Long.valueOf(req.getParameter(CARD_NUMBER));
        Long sum = Long.valueOf(req.getParameter(SUM));
        Integer pin = Integer.valueOf(req.getParameter(PIN));
        AccountService as = new AccountServiceImpl();
        Card card = new CardServiceImpl().getByCardNumber(cardNumber);
        if (card != null && card.getPin().equals(pin)) {
            Account account = as.getByAccountId(card.getAccountId());
            Long balance = account.getBalance() + sum;
            account.setBalance(balance);
            as.update(account);
            createAtm(req);
            req.getSession().setAttribute("putMoneyResult", StringUtils.EMPTY);
            resp.sendRedirect(PageConstant.LOGIN_SERVLET);
            LOGGER.debug("PutMonewServlet ends successfully");
        }
    }

    private void createAtm(HttpServletRequest req) {
        Long cardNumber = Long.valueOf(req.getParameter(CARD_NUMBER));
        Long sum = Long.valueOf(req.getParameter(SUM));
        Atm atm = new Atm();
        atm.setCardNumberReceiver(cardNumber);
        atm.setSum(sum);
        new AtmServiceImpl().create(atm);
        LOGGER.debug("Atm was created");
    }
}
