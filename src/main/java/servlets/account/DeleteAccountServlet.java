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

public class DeleteAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AccountService accountService = new AccountServiceImpl();
        Long userId = ((User)session.getAttribute("user")).getId();
        List<Account> accountList = accountService.getByUserId(Long.valueOf(userId));
        for (int i=0; i<accountList.size(); i++){
            if(accountList.get(i).getStatus() == Status.DELETED){
                accountList.remove(i);
            }
        }
        req.setAttribute("accountList", accountList);

        req.getRequestDispatcher(PageConstant.DELETE_ACCOUNT).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        PrintWriter out = resp.getWriter();
        Account account = accountService.getByAccountId(Long.valueOf(req.getParameter("account id")));
        account.setStatus(Status.DELETED);
        if (accountService.update(account)) {
            out.print("true");
        } else {
            out.print("false");
        }
        out.flush();
        out.close();
    }
}
