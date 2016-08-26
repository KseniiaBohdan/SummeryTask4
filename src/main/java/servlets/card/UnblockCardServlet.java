package servlets.card;

import data.entity.Card;
import data.entity.CardRequest;
import data.entity.Status;
import data.entity.User;
import service.CardRequestService;
import service.impl.CardRequestServiceImpl;
import service.impl.CardServiceImpl;
import servlets.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UnblockCardServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userId = ((User)session.getAttribute("user")).getId();
        List<Card> blockedCards = new CardServiceImpl().getUserCardByStatus(Status.BLOCKED, userId);
        req.setAttribute("blockedCards", blockedCards );
        req.getRequestDispatcher(PageConstant.UNBLOCK_CARD).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long cardNumber = Long.valueOf(req.getParameter("card number"));
        String title = req.getParameter("title");
        CardRequest cardRequest = new CardRequest(cardNumber, title);
        CardRequestService crs = new CardRequestServiceImpl();
        crs.create(cardRequest);
        resp.sendRedirect(PageConstant.UNBLOCK_CARD_SERVLET);
    }
}
