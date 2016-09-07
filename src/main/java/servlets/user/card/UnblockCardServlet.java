package servlets.user.card;

import data.entity.Card;
import data.entity.CardRequest;
import data.entity.Status;
import data.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import service.CardRequestService;
import service.CardService;
import service.impl.CardRequestServiceImpl;
import service.impl.CardServiceImpl;
import servlets.constant.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UnblockCardServlet extends HttpServlet {

    private static final String CARD_NUMBER = "cardNumber";
    private static final String TITLE = "title";
    private static final String USER = "user";
    private static final String CARD_LIST = "cardList";
    private static final Logger LOGGER = Logger.getLogger(UnblockCardServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("unblockRequestResult", session.getAttribute("unblockRequestResult"));
        session.setAttribute("unblockRequestResult", null);
        Long userId = ((User) session.getAttribute(USER)).getId();
        CardService cardService = new CardServiceImpl();
        List<Card> cardList = cardService.getByUserId(userId);
        cardService.removeCardsByStatus(cardList, Status.ACTIVE, Status.DELETED);
        req.setAttribute(CARD_LIST, cardList);
        req.getRequestDispatcher(PageConstant.UNBLOCK_CARD).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("UnblockCard starts");
        Long cardNumber = Long.valueOf(req.getParameter(CARD_NUMBER));
        String title = req.getParameter(TITLE);
        CardRequest cardRequest = new CardRequest(cardNumber, title);
        CardRequestService crs = new CardRequestServiceImpl();
        if (crs.create(cardRequest)) {
            req.getSession().setAttribute("unblockRequestResult", StringUtils.EMPTY);
            resp.sendRedirect(PageConstant.UNBLOCK_CARD_SERVLET);
            LOGGER.debug("UnblockCard ends successfully");
        } else {
            resp.sendRedirect(PageConstant.UNBLOCK_CARD_SERVLET);
        }
    }
}
