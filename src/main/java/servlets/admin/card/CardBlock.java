package servlets.admin.card;

import service.impl.CardServiceImpl;
import servlets.constant.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CardBlock extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long cardId = Long.valueOf(req.getParameter("cardId"));
        new CardServiceImpl().blockCard(cardId);
        resp.sendRedirect(PageConstant.USER_INFO_SERVLET);
    }
}
