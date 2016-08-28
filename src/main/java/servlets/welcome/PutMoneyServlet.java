package servlets.welcome;

import data.entity.Account;
import data.entity.Card;
import service.AccountService;
import service.impl.AccountServiceImpl;
import service.impl.CardServiceImpl;
import servlets.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PutMoneyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long cardNumber = Long.valueOf(req.getParameter("card number"));
        Long sum = Long.valueOf(req.getParameter("sum"));
        Integer pin = Integer.valueOf(req.getParameter("pin"));
        AccountService as = new AccountServiceImpl();
        Card card = new CardServiceImpl().getByCardNumber(cardNumber);
        if (card != null && card.getPin()==pin) {
            Account account = as.getByAccountId(card.getAccountId());
            Long balance = account.getBalance() + sum;
            account.setBalance(balance);
            as.update(account);
            resp.sendRedirect(PageConstant.LOGIN_SERVLET);
        }

    }
}
