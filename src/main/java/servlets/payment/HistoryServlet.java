package servlets.payment;

import data.dto.PaymentDto;
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
import java.util.ArrayList;
import java.util.List;

public class HistoryServlet extends HttpServlet{

    private static final String USER = "user";
    private static final String PAYMENT_MODAL_LIST = "paymentList";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserService userService = new UserServiceImpl();
        User user = (User) session.getAttribute(USER);
        PaymentService paymentService = new PaymentServiceImpl();
        List<Payment> paymentList = paymentService.getByUserSenderId(user.getId());
        paymentList.addAll(paymentService.getByUserReceiverId(user.getId()));
        removeSame(paymentList);

        User temp;
        List<PaymentDto> paymentModelList = new ArrayList();
        for (int i = 0; i < paymentList.size(); i++) {
            PaymentDto paymentModal = new PaymentDto();
            paymentModal.setPayment(paymentList.get(i));
            temp = userService.getByCardNumber(paymentList.get(i).getCardNumberReceiver());
            paymentModal.setReceiverName(temp.getName());
            temp = userService.getByCardNumber(paymentList.get(i).getCardNumberSender());
            paymentModal.setSenderName(temp.getName());
            paymentModelList.add(paymentModal);
        }

        req.setAttribute(PAYMENT_MODAL_LIST, paymentModelList);

        req.getRequestDispatcher(PageConstant.HISTORY).include(req, resp);
    }

    private void removeSame(List<Payment> paymentList) {
        for (int i = 0; i < paymentList.size()-1; i++) {
            for (int j = 1; j < paymentList.size(); j++) {
                if(paymentList.get(i).equals(paymentList.get(j))){
                    paymentList.remove(j);
                    --j;
                }
            }
        }
    }
}
