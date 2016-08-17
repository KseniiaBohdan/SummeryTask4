package servlets;

import entity.Account;
import entity.User;
import service.AccountService;
import service.implementation.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddNewAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("addNewAccountPage.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        HttpSession session = req.getSession();
        Long id = ((User) session.getAttribute("user")).getId();
        int accountNumber = accountService.getByUserId(id).size() + 1;
        Account account = new Account(Long.valueOf(req.getParameter("id")), Long.valueOf(req.getParameter("balance")),
                accountNumber, req.getParameter("title"), id);
        if (AccountValid(account, accountService)) {
            if (accountService.create(account)) {
                resp.getWriter().print("OK");
            }
        }
    }

    private boolean AccountValid(Account account, AccountService accountService) {
        if (accountService.getByAccountId(account.getId()) == null) {
            return true;
        } else {
            return false;
        }
    }
}