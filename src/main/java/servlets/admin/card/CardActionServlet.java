package servlets.admin.card;

import servlets.PageConstant;
import service.comand.container.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CardActionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardNumber = req.getParameter("cardnumber");
        String action = req.getParameter("action");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("cardNumber", cardNumber);
        CommandContainer.getCardCommand(action).execute(null, params);
        resp.sendRedirect(PageConstant.UNBLOCK_REQUESTS_CARD_SERVLET);
    }
}
