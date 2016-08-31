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

    private static final String CARD_NUMBER = "cardNumber";
    private static final String ACTION = "action";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardNumber = req.getParameter(CARD_NUMBER);
        String action = req.getParameter(ACTION);
        Map<String, Object> params = new HashMap();
        params.put(CARD_NUMBER, cardNumber);
        CommandContainer.getCardCommand(action).execute(null, params);
        resp.sendRedirect(PageConstant.UNBLOCK_REQUESTS_CARD_SERVLET);
    }
}
