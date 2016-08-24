package servlets.admin;

import constant.PageConstant;
import data.entity.Payment;
import service.UserService;
import service.implementation.PaymentServiceImpl;
import service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PaymentsHistoryServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<Payment> paymentList = new PaymentServiceImpl().getAll();
        req.setAttribute("paymentList", paymentList);
        req.getRequestDispatcher(PageConstant.PAYMENTS_HISTORY).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
