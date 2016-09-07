package servlets.user.card;

import org.apache.log4j.Logger;
import service.impl.CardRequestServiceImpl;
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

public class DeleteCardServlet extends HttpServlet{

    private static final String CARD_NUMBER = "cardNumber";
    private static final String USER = "user";
    private static final String CARD_LIST = "cardList";
    private static final Logger LOGGER = Logger.getLogger(DeleteCardServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CardService cardService = new CardServiceImpl();
        Long user_id = ((User)session.getAttribute(USER)).getId();
        List<Card> cardList = cardService.getByUserId(Long.valueOf(user_id));
        cardService.removeCardsByStatus(cardList, Status.DELETED);
        req.setAttribute(CARD_LIST, cardList);
        req.getRequestDispatcher(PageConstant.DELETE_CARD).include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("DeleteCard starts");
        CardService cardService = new CardServiceImpl();
        Card card = cardService.getByCardNumber(Long.valueOf(req.getParameter(CARD_NUMBER)));
        card.setStatus(Status.DELETED);
        new CardRequestServiceImpl().deleteByCardNumber(card.getCardNumber());
        if(cardService.update(card)){
            resp.sendRedirect(PageConstant.DELETE_CARD_SERVLET);
            LOGGER.debug("DeleteCard ends successfully");
        }else {
            resp.sendRedirect(PageConstant.DELETE_CARD_SERVLET);
        }

    }
}
