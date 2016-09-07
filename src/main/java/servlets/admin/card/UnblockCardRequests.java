package servlets.admin.card;

import servlets.constant.PageConstant;
import data.entity.CardRequest;
import service.impl.CardRequestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UnblockCardRequests extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cardUnblockResult", req.getSession().getAttribute("cardUnblockResult"));
        req.getSession().setAttribute("cardUnblockResult", null);
        List<CardRequest> cardRequests = new ArrayList();
        cardRequests = new CardRequestServiceImpl().getAll();
        req.setAttribute("cardRequests", cardRequests);
        req.getRequestDispatcher(PageConstant.UNBLOCK_REQUESTS_CARD).include(req, resp);
    }
}
