package servlets.user.payment;

import data.entity.Payment;
import data.entity.PaymentStatus;
import service.PaymentService;
import service.impl.PaymentServiceImpl;
import servlets.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ConfirmPayment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PaymentService ps = new PaymentServiceImpl();
        Payment payment = ps.getById(Long.valueOf(req.getParameter("paymentId")));
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        ps.update(payment);
        resp.sendRedirect(PageConstant.USER_PAYMENTS_HISTORY_SERVLET);
    }

}
