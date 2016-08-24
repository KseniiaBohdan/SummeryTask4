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

public class DeleteCardServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CardService cardService = new CardServiceImpl();
        Long user_id = ((User)session.getAttribute("user")).getId();
        List<Card> cardList = cardService.getActiveCardByUserId(Long.valueOf(user_id));
        req.setAttribute("cardList", cardList);

        req.getRequestDispatcher(PageConstant.DELETE_CARD).include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CardService cardService = new CardServiceImpl();
        PrintWriter out = resp.getWriter();
        Card card = cardService.getByCardNumber(Long.valueOf(req.getParameter("card number")));
        card.setStatus(Status.DELETED);
        if(cardService.update(card)){
            out.print("true");
            out.flush();
            out.close();
        }else {
            out.print("false");
            out.flush();
            out.close();
        }

    }
}
