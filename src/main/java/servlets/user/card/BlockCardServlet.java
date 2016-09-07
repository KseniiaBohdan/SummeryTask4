package servlets.user.card;

import org.apache.log4j.Logger;
import servlets.constant.PageConstant;
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
import java.util.List;

public class BlockCardServlet extends HttpServlet {

    private static final String CARD_NUMBER = "cardNumber";
    private static final String USER = "user";
    private static final String USER_LIST = "cardList";
    private static final Logger LOGGER = Logger.getLogger(BlockCardServlet.class);


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
        LOGGER.debug("BlockCard starts");
        CardService cardService = new CardServiceImpl();
        Long cardNumber = Long.valueOf(req.getParameter(CARD_NUMBER));
        Card card = cardService.getByCardNumber(cardNumber);
        card.setStatus(Status.BLOCKED);
        if (cardService.update(card)) {
            resp.sendRedirect(PageConstant.BLOCK_CARD_SERVLET);
            LOGGER.debug("BlockCard ends successfully");
        } else {
        }
    }
}
