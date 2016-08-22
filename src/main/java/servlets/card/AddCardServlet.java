package servlets.card;

import constant.PageConstant;
import entity.Card;
import entity.User;
import service.CardService;
import service.implementation.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageConstant.ADD_CARD).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        String parameter = req.getParameter("expire date");
        java.util.Date date = null;
        try {
            date = in.parse(parameter);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        HttpSession session = req.getSession();
        Long id = ((User) session.getAttribute("user")).getId();
        Card card = new Card(Long.valueOf(req.getParameter("card number")), id,
                new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()), Integer.valueOf(req.getParameter("pin")),
                req.getParameter("title"), Long.valueOf(req.getParameter("account id")));
        CardService cardService = new CardServiceImpl();
        if (cardValid(card, cardService)) {
            if (cardService.create(card)) {
                resp.getWriter().print("OK");
            }
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
