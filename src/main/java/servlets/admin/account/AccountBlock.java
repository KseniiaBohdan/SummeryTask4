package servlets.admin.account;

import service.impl.AccountServiceImpl;
import servlets.constant.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountBlock extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long accountId = Long.valueOf(req.getParameter("account"));
        if (new AccountServiceImpl().blockAccount(accountId)) {
            resp.sendRedirect(PageConstant.USER_INFO_SERVLET);
        }
    }
}
