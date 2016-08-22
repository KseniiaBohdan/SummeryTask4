package servlets.payment;

import constant.PageConstant;
import entity.Account;
import entity.Card;
import entity.Payment;
import entity.User;
import service.AccountService;
import service.CardService;
import service.PaymentService;
import service.implementation.AccountServiceImpl;
import service.implementation.CardServiceImpl;
import service.implementation.PaymentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DoPaymentServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageConstant.DO_PAYMENT).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        Integer sum = Integer.valueOf(req.getParameter("sum"));
        Long cardNumberSender = Long.valueOf(req.getParameter("sender card number"));
        CardService cardService = new CardServiceImpl();
        AccountService accountService = new AccountServiceImpl();
        Card cardSender = cardService.getByCardNumber(cardNumberSender);
        Account accountSender = accountService.getByAccountId(cardSender.getAccountId());
        accountSender.setBalance(accountSender.getBalance() - sum);
        accountService.update(accountSender);

        Long cardNumberReceiver = Long.valueOf(req.getParameter("receiver card number"));
        Card cardReceiver = cardService.getByCardNumber(cardNumberReceiver);
        Account accountReceiver = accountService.getByAccountId(cardReceiver.getAccountId());
        accountReceiver.setBalance(accountReceiver.getBalance() + sum);
        accountService.update(accountReceiver);

        PaymentService paymentService = new PaymentServiceImpl();
        Long userId = ((User)session.getAttribute("user")).getId();
        Long paymentNumber = Long.valueOf(paymentService.getByUserSenderId(userId).size()+1);
        Payment payment = new Payment(paymentNumber, cardNumberReceiver, cardNumberSender, req.getParameter("title").toString(),sum);
        out.println(paymentService.create(payment));

        out.flush();
        out.close();
    }
}
