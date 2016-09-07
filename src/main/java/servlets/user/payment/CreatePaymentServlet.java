package servlets.user.payment;

import data.entity.*;
import org.apache.log4j.Logger;
import servlets.constant.PageConstant;
import service.AccountService;
import service.CardService;
import service.PaymentService;
import service.impl.AccountServiceImpl;
import service.impl.CardServiceImpl;
import service.impl.PaymentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CreatePaymentServlet extends HttpServlet {

    private static final String CARD_LIST = "cardList";
    private static final String USER = "user";
    private static final String SUM = "sum";
    private static final String SENDER_CARD_NUMBER = "senderCardNumber";
    private static final String RECEIVER_CARD_NUMBER = "receiverCardNumber";
    private static final String TITLE = "title";
    private static final Logger LOGGER = Logger.getLogger(CreatePaymentServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CardService cardService = new CardServiceImpl();
        HttpSession session = req.getSession();
        Long userId = ((User) session.getAttribute(USER)).getId();
        List<Card> cardList = cardService.getByUserId(Long.valueOf(userId));
        cardService.removeCardsByStatus(cardList, Status.BLOCKED, Status.DELETED);
        removeBlockAccount(cardList);
        req.setAttribute(CARD_LIST, cardList);
        req.getRequestDispatcher(PageConstant.CREATE_PAYMENT).include(req, resp);
    }

    private void removeBlockAccount(List<Card> cardList) {
        for (int i = 0; i <cardList.size(); i++) {
            Long accountId = cardList.get(i).getAccountId();
            Status st = new AccountServiceImpl().getByAccountId(accountId).getStatus();
            if(!st.equals(Status.ACTIVE)){
                cardList.remove(i);
                --i;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("CreatePayment start");
        HttpSession session = req.getSession();
        CardService cardService = new CardServiceImpl();
        AccountService accountService = new AccountServiceImpl();

        Integer sum = Integer.valueOf(req.getParameter(SUM));

        Long cardNumberSender = Long.valueOf(req.getParameter(SENDER_CARD_NUMBER));
        Card cardSender = cardService.getByCardNumber(cardNumberSender);
        Account accountSender = accountService.getByAccountId(cardSender.getAccountId());

        Long cardNumberReceiver = Long.valueOf(req.getParameter(RECEIVER_CARD_NUMBER));
        Card cardReceiver = cardService.getByCardNumber(cardNumberReceiver);
        Account accountReceiver = accountService.getByAccountId(cardReceiver.getAccountId());

        if (isSumValid(sum, accountSender) && isReceiverValid(cardReceiver, accountReceiver)) {
            accountSender.setBalance(accountSender.getBalance() - sum);
            accountService.update(accountSender);

            accountReceiver.setBalance(accountReceiver.getBalance() + sum);
            accountService.update(accountReceiver);

            createPayment(req, session, sum, cardNumberSender, cardNumberReceiver);
            resp.sendRedirect(PageConstant.CREATE_PAYMENT_SERVLET);
            LOGGER.debug("CreatePayment end");
        }else {
            resp.sendRedirect(PageConstant.LOGIN_SERVLET);
        }
    }

    private boolean isReceiverValid(Card cardReceiver, Account account) {
        return cardReceiver.getStatus().equals(Status.ACTIVE)
                && account.getStatus().equals(Status.ACTIVE);
    }

    private boolean isSumValid(Integer sum, Account accountSender) {
        return sum > 0 && sum <= accountSender.getBalance();
    }

    private void createPayment(HttpServletRequest req, HttpSession session, Integer sum, Long cardNumberSender, Long cardNumberReceiver) {
        PaymentService paymentService = new PaymentServiceImpl();
        Long userId = ((User) session.getAttribute(USER)).getId();
        Long paymentNumber = Long.valueOf(paymentService.getByUserSenderId(userId).size() + 1);
        Payment payment = new Payment();
        payment.setNumber(paymentNumber);
        payment.setCardNumberReceiver(cardNumberReceiver);
        payment.setCardNumberSender(cardNumberSender);
        payment.setTitle(req.getParameter(TITLE).toString());
        payment.setSum(sum);
        paymentService.create(payment);
    }
}
