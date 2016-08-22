package servlets.welcome;

import constant.PageConstant;
import entity.Account;
import entity.Card;
import entity.User;
import service.implementation.AccountServiceImpl;
import service.implementation.CardServiceImpl;
import service.implementation.UserServiceImpl;

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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageConstant.REGISTRATION).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        UserServiceImpl userService = new UserServiceImpl();
        CardServiceImpl cardService = new CardServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();

        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        String parameter = req.getParameter("expire_date");
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
                flag = cardService.create(card);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (flag) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.setContentType("text/html");
                out.print("successful registration");
            }
        }
        out.flush();
        out.close();
    }

    private Account setAccount(HttpServletRequest req) {
        return new Account(Long.valueOf(req.getParameter("account_id")),
                Long.valueOf(req.getParameter("balance")),
                req.getParameter("account_title"));
    }

    private Card setCard(HttpServletRequest req, Date date) {
        return new Card(Long.valueOf(req.getParameter("card_number")),
                new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()),
                Integer.valueOf(req.getParameter("pin")), Long.valueOf(req.getParameter("account_id")),
                req.getParameter("card_title"));
    }

    private User setUser(HttpServletRequest req) {
        return new User(req.getParameter("first_name"), req.getParameter("second_name"),
                req.getParameter("patronymic"), req.getParameter("email"),
                req.getParameter("password"), req.getParameter("phone_number"));
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

}