package servlets.account;

import constant.PageConstant;
import data.entity.Account;
import data.entity.Status;
import data.entity.User;
import service.AccountService;
import service.implementation.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BlockAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AccountService accountService = new AccountServiceImpl();
        Long userId = ((User)session.getAttribute("user")).getId();
        List<Account> accountList = accountService.getByUserId(Long.valueOf(userId));
        for (int i = 0; i < accountList.size() ; i++) {
            if(accountList.get(i).getStatus() != Status.ACTIVE){
                accountList.remove(i);
            }
        }
        req.setAttribute("accountList", accountList);

        req.getRequestDispatcher(PageConstant.BLOCK_ACCOUNT).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        Long accountId = Long.valueOf(req.getParameter("account id"));
        Account account = accountService.getByAccountId(accountId);
        account.setStatus(Status.BLOCKED);
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

