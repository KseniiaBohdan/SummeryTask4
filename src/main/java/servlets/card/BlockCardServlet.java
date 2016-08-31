package servlets.card;

import servlets.PageConstant;
import data.entity.Card;
import data.entity.Status;
import data.entity.User;
import service.CardService;
import service.impl.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BlockCardServlet extends HttpServlet {

    private static final String CARD_NUMBER = "cardNumber";
    private static final String USER = "user";
    private static final String USER_LIST = "cardList";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CardService cardService = new CardServiceImpl();
        Long userId = ((User) session.getAttribute(USER)).getId();
        List<Card> cardList = cardService.getByUserId(Long.valueOf(userId));
        cardService.removeCardsByStatus(cardList, Status.BLOCKED, Status.DELETED);
        req.setAttribute(USER_LIST, cardList);
        req.getRequestDispatcher(PageConstant.BLOCK_CARD).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CardService cardService = new CardServiceImpl();
        Long cardNumber = Long.valueOf(req.getParameter(CARD_NUMBER));
        Card card = cardService.getByCardNumber(cardNumber);
        card.setStatus(Status.BLOCKED);
        if (cardService.update(card)) {
            resp.sendRedirect(PageConstant.BLOCK_CARD_SERVLET);
        } else {
        }
    }
}
