package servlets.welcome;

import org.apache.log4j.Logger;
import service.utils.MailSender;
import service.utils.Password;
import servlets.constant.PageConstant;
import data.entity.Account;
import data.entity.Card;
import data.entity.User;
import service.impl.AccountServiceImpl;
import service.impl.CardServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationServlet extends HttpServlet {

    private static final String FIRST_NAME = "FirstName";
    private static final String SECOND_NAME = "SecondName";
    private static final String PATRONYMIC = "Patronymic";
    private static final String PHONE_NUMBER = "PhoneNumber";
    private static final String PASSWORD1 = "Password1";
    private static final String PASSWORD2 = "Password2";
    private static final String EMAIL = "Email";
    private static final String CARD_NUMBER = "CardNumber";
    private static final String ACCOUNT_NUMBER = "AccountNumber";
    private static final String PIN1 = "Pin1";
    private static final String PIN2 = "Pin2";
    private static final String EXPIRY_DATE = "ExpiryDate";
    private static final String ACCOUNT_TITLE = "AccountTitle";
    private static final String CARD_TITLE = "CardTitle";
    private static final String USER = "user";
    private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageConstant.REGISTRATION).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LOGGER.debug("Registration start");

        UserServiceImpl userService = new UserServiceImpl();
        CardServiceImpl cardService = new CardServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();

        java.util.Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter(EXPIRY_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = setUser(req);
        Card card = setCard(req, date);
        Account account = setAccount(req);

        Integer pin1 = Integer.valueOf(req.getParameter(PIN1));
        Integer pin2 = Integer.valueOf(req.getParameter(PIN2));

        String password1 = req.getParameter(PASSWORD1);
        String password2 = req.getParameter(PASSWORD2);

        boolean flag;
        if (accountValid(account, accountService) && cardValid(card, cardService, pin1, pin2) &&
                userValid(user, userService, password1, password2) && userService.create(user)) {
            Long userId = userService.getByEmail(user.getEmail()).getId();
            account.setUserId(userId);
            int accountNumber = accountService.getByUserId(userId).size() + 1;
            account.setNumber(accountNumber);
            flag = accountService.create(account);
            card.setUserId(userId);
            flag &= cardService.create(card);

            if (flag) {
                MailSender.sendMail(user.getEmail(), "Registration success", "Congratulations! " +
                        "Your registration was successful! Welcome to our PaymentSystem, now You can execute operations with Your accounts and cards " +
                        "with the help of our service." + "\n\n" + "Regards,\n" + "The PaymentSystem Team.");
                resp.sendRedirect(PageConstant.LOGIN_SERVLET);
                LOGGER.trace("New user: " + user.getEmail());
                LOGGER.debug("Registration ends successfully");
            }
        } else {
            resp.sendRedirect(PageConstant.REGISTRATION_SERVLET);
        }
    }

    private Account setAccount(HttpServletRequest req) {
        Account account = new Account();
        account.setId(Long.valueOf(req.getParameter(ACCOUNT_NUMBER)));
        account.setTitle(req.getParameter(ACCOUNT_TITLE));
        LOGGER.debug("Add account");
        return account;
    }

    private Card setCard(HttpServletRequest req, Date date) {
        Card card = new Card();
        card.setCardNumber(Long.valueOf(req.getParameter(CARD_NUMBER)));
        card.setExpiryDate(date);
        card.setPin(Integer.valueOf(req.getParameter(PIN1)));
        card.setAccountId(Long.valueOf(req.getParameter(ACCOUNT_NUMBER)));
        card.setTitle(req.getParameter(CARD_TITLE));
        LOGGER.debug("Add card");
        return card;
    }

    private User setUser(HttpServletRequest req) {
        User user = new User();
        user.setFirstName(req.getParameter(FIRST_NAME));
        user.setSecondName(req.getParameter(SECOND_NAME));
        user.setPatronymic(req.getParameter(PATRONYMIC));
        user.setEmail(req.getParameter(EMAIL));
        user.setPassword(Password.hash(req.getParameter(PASSWORD1)));
        user.setPhoneNumber(req.getParameter(PHONE_NUMBER));
        LOGGER.debug("Add user");
        return user;
    }

    private boolean userValid(User user, UserServiceImpl service, String p1, String p2) {
        if (service.getByEmail(user.getEmail()) == null &&
                service.getByPhoneNumber(user.getPhoneNumber()) == null
                && p1.equals(p2)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean cardValid(Card card, CardServiceImpl service, Integer pin1, Integer pin2) {
        if (service.getByCardNumber(card.getCardNumber()) == null
                && pin1.equals(pin2)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean accountValid(Account account, AccountServiceImpl service) {
        if (service.getByAccountId(account.getId()) == null) {
            return true;
        } else {
            return false;
        }
    }
}