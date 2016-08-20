package servlets;

import entity.Account;
import entity.Status;
import service.AccountService;
import service.implementation.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("deleteAccount.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        PrintWriter out = resp.getWriter();
        Account account = accountService.getByAccountId(Long.valueOf(req.getParameter("account_id")));
        account.setStatusId(Status.DELETED);
        if (accountService.update(account)) {
            out.print("true");
        } else {
            out.print("false");
        }
        out.flush();
        out.close();
    }
}
