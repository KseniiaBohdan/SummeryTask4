package servlets;

import entity.Card;
import service.CardService;
import service.implementation.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BlockCardServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("blockCard.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CardService cardService = new CardServiceImpl();
        Long cardNumber = Long.valueOf(req.getParameter("card_number"));
        Card card = cardService.getByCardNumber(cardNumber);
        card.setStatusId(2);
        PrintWriter out = resp.getWriter();
        if(cardService.update(card)){
            out.print(true);
        }else {
            out.print(false);
        }
        out.flush();
        out.close();
    }
}
