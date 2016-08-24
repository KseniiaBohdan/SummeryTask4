package servlets.card;

import constant.PageConstant;
import data.entity.Card;
import data.entity.Status;
import data.entity.User;
import service.CardService;
import service.implementation.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BlockCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CardService cardService = new CardServiceImpl();
        Long userId = ((User) session.getAttribute("user")).getId();
        List<Card> cardList = cardService.getActiveByUserId(Long.valueOf(userId));
        req.setAttribute("cardList", cardList);

        req.getRequestDispatcher(PageConstant.BLOCK_CARD).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CardService cardService = new CardServiceImpl();
        Long cardNumber = Long.valueOf(req.getParameter("card number"));
        Card card = cardService.getByCardNumber(cardNumber);
        card.setStatus(Status.BLOCKED);
        PrintWriter out = resp.getWriter();
        if (cardService.update(card)) {
            out.print(true);
        } else {
            out.print(false);
        }
        out.flush();
        out.close();
    }
}
