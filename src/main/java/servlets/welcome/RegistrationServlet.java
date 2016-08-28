package servlets.welcome;

import servlets.PageConstant;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationServlet extends HttpServlet {

    private static final String FIRST_NAME = "FirstName";
    private static final String SECOND_NAME = "SecondName";
    private static final String PATRONYMIC = "Patronymic";
    private static final String PHONE_NUMBER = "PhoneNumber";
    private static final String PASSWORD1 = "Password1";
    private static final String EMAIL = "Email";
    private static final String CARD_NUMBER = "CardNumber";
    private static final String ACCOUNT_NUMBER = "AccountNumber";
    private static final String PIN1 = "Pin1";
    private static final String EXPIRY_DATE = "ExpiryDate";
    private static final String ACCOUNT_TITLE = "AccountTitle";
    private static final String CARD_TITLE = "CardTitle";
    private static final String USER = "user";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageConstant.REGISTRATION).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        saveParameter(req);
        PrintWriter out = resp.getWriter();

        UserServiceImpl userService = new UserServiceImpl();
        CardServiceImpl cardService = new CardServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();

        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        String parameter = req.getParameter(EXPIRY_DATE);
        java.util.Date date = null;
        try {
            date = in.parse(parameter);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = setUser(req);
        Card card = setCard(req, date);
        Account account = setAccount(req);

        boolean flag = false;
        if (this.accountValid(account, accountService) && this.cardValid(card, cardService) &&
                this.userValid(user, userService) && userService.create(user)) {
            try {
                Long userId = userService.getByEmail(user.getEmail()).getId();
                account.setUserId(userId);
                int accountNumber = accountService.getByUserId(userId).size() + 1;
                account.setNumber(accountNumber);
                flag = accountService.create(account);
                card.setUserId(userId);
                flag = flag&&cardService.create(card);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (flag) {
                HttpSession session = req.getSession();
                session.setAttribute(USER, user);
                out.print("successful registration");
            }
        }
        out.flush();
        out.close();
    }

    private Account setAccount(HttpServletRequest req) {
        Account account = new Account();
        account.setId(Long.valueOf(req.getParameter(ACCOUNT_NUMBER)));
        account.setTitle(req.getParameter(ACCOUNT_TITLE));
        return account;
    }

    private Card setCard(HttpServletRequest req, Date date) {
        Card card = new Card();
        card.setCardNumber(Long.valueOf(req.getParameter(CARD_NUMBER)));
        card.setExpiryDate(new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
        card.setPin(Integer.valueOf(req.getParameter(PIN1)));
        card.setAccountId(Long.valueOf(req.getParameter(ACCOUNT_NUMBER)));
        card.setTitle(req.getParameter(CARD_TITLE));
        return card;
    }

    private User setUser(HttpServletRequest req) {
        User user = new User();
        user.setFirstName(req.getParameter(FIRST_NAME));
        user.setSecondName(req.getParameter(SECOND_NAME));
        user.setPatronymic(req.getParameter(PATRONYMIC));
        user.setEmail(req.getParameter(EMAIL));
        user.setPassword(req.getParameter(PASSWORD1));
        user.setPhoneNumber(req.getParameter(PHONE_NUMBER));
        return user;
    }

    private boolean userValid(User user, UserServiceImpl service) {
        try {
            if (service.getByEmail(user.getEmail()) == null &&
                    service.getByPhoneNumber(user.getPhoneNumber()) == null) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean cardValid(Card card, CardServiceImpl service) {
        if (service.getByCardNumber(card.getCardNumber()) == null) {
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

    private static void saveParameter(HttpServletRequest req){
        req.setAttribute(FIRST_NAME,  req.getParameter(FIRST_NAME));
        req.setAttribute(SECOND_NAME,  req.getParameter(SECOND_NAME));
        req.setAttribute(PATRONYMIC,  req.getParameter(PATRONYMIC));
        req.setAttribute(PHONE_NUMBER,  req.getParameter(PHONE_NUMBER));
        req.setAttribute(EMAIL,  req.getParameter(EMAIL));
        req.setAttribute(CARD_NUMBER,  req.getParameter(CARD_NUMBER));
        req.setAttribute(ACCOUNT_NUMBER,  req.getParameter(ACCOUNT_NUMBER));
        req.setAttribute(EXPIRY_DATE,  req.getParameter(EXPIRY_DATE));
        req.setAttribute(ACCOUNT_TITLE,  req.getParameter(ACCOUNT_TITLE));
        req.setAttribute(CARD_TITLE,  req.getParameter(CARD_TITLE));
    }

}