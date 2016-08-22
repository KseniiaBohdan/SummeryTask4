package servlets.account;

import constant.PageConstant;
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

public class BlockAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageConstant.BLOCK_ACCOUNT).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        Long accountId = Long.valueOf(req.getParameter("account id"));
        Account account = accountService.getByAccountId(accountId);
        account.setStatusId(Status.BLOCKED);
        PrintWriter out = resp.getWriter();
        if (accountService.update(account)) {
            out.print(true);
        } else {
            out.print(false);
        }
        out.flush();
        out.close();
    }
}

