package servlets;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        setSessionAtribute(req, session);

        UserServiceImpl userService = new UserServiceImpl();
        CardServiceImpl cardService = new CardServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();

        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        String parameter = (String) session.getAttribute("expire_date");
        java.util.Date date = null;
        try {
            date = in.parse(parameter);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = new User((String) session.getAttribute("first_name"), (String) session.getAttribute("second_name"),
                (String) session.getAttribute("patronymic"), (String) session.getAttribute("email"),
                (String) session.getAttribute("password"), (String) session.getAttribute("phone_number"));
        Card card = new Card(Long.valueOf(session.getAttribute("card_number").toString()),
                new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()),
                Integer.valueOf(session.getAttribute("pin").toString()), Long.valueOf(session.getAttribute("account_id").toString()),
                session.getAttribute("card_title").toString());
        Account account = new Account(Long.valueOf(session.getAttribute("account_id").toString()),
                Long.valueOf(session.getAttribute("balance").toString()),
                session.getAttribute("account_title").toString());

        if (userService.create(user)) {
            try {
                Long userId = userService.getByEmail(user.getEmail()).getId();
                account.setUserId(userId);
                int accountNumber = accountService.getByUserId(userId).size() + 1;
                account.setNumber(accountNumber);
                boolean flag = accountService.create(account);
                card.setUserId(userId);
                flag = cardService.create(card);
                session.setAttribute("result", flag);
                resp.setContentType("text/html");
                req.getRequestDispatcher("resultPage.jsp").include(req, resp);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void setSessionAtribute(HttpServletRequest req, HttpSession session) {
        session.setAttribute("email", req.getParameter("email"));
        session.setAttribute("password", req.getParameter("password"));
        session.setAttribute("first_name", req.getParameter("first_name"));
        session.setAttribute("second_name", req.getParameter("second_name"));
        session.setAttribute("patronymic", req.getParameter("patronymic"));
        session.setAttribute("phone_number", req.getParameter("phone_number"));
        session.setAttribute("card_number", req.getParameter("card_number"));
        session.setAttribute("expire_date", req.getParameter("expire_date"));
        session.setAttribute("pin", req.getParameter("pin"));
        session.setAttribute("card_title", req.getParameter("card_title"));
        session.setAttribute("account_id", req.getParameter("account_id"));
        session.setAttribute("balance", req.getParameter("balance"));
        session.setAttribute("account_title", req.getParameter("account_title"));
    }
}
