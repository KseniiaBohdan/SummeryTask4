package servlets.card;

import constant.PageConstant;
import entity.Card;
import entity.Status;
import service.CardService;
import service.implementation.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteCardServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageConstant.DELETE_CARD).include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CardService cardService = new CardServiceImpl();
        PrintWriter out = resp.getWriter();
        Card card = cardService.getByCardNumber(Long.valueOf(req.getParameter("card number")));
        card.setStatusId(Status.DELETED);
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
