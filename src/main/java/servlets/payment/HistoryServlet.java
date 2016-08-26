package servlets.payment;

import servlets.PageConstant;
import data.entity.Payment;
import data.entity.User;
import service.PaymentService;
import service.UserService;
import service.impl.PaymentServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class HistoryServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserService userService = new UserServiceImpl();
        User user = (User) session.getAttribute("user");
        PaymentService paymentService = new PaymentServiceImpl();
        List<Payment> paymentList = paymentService.getByUserSenderId(user.getId());
        paymentList.addAll(paymentService.getByUserReceiverId(user.getId()));
        req.setAttribute("paymentList", paymentList);

        req.getRequestDispatcher(PageConstant.HISTORY).include(req, resp);
    }
}
