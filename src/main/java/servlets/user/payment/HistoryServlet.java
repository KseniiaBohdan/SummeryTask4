package servlets.user.payment;

import data.dto.PaymentDto;
import data.entity.Atm;
import org.apache.log4j.Logger;
import service.AtmService;
import service.impl.AtmServiceImpl;
import servlets.EncodingFilter;
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
    private static final String ATM_LIST = "atmList";
    private static final Logger LOGGER = Logger.getLogger(HistoryServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("History start");
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

        List<Atm> atmList = new AtmServiceImpl().getByUserId(user.getId());

        req.setAttribute(ATM_LIST, atmList);
        req.setAttribute(PAYMENT_MODAL_LIST, paymentModelList);
        req.getRequestDispatcher(PageConstant.HISTORY).include(req, resp);
        LOGGER.debug("History end");
    }

    private void removeSame(List<Payment> paymentList) {
        for (int i = 0; i < paymentList.size(); i++) {
            for (int j = 0; j < paymentList.size(); j++) {
                if(paymentList.get(i).equals(paymentList.get(j)) && i!=j){
                    paymentList.remove(j);
                    --j;
                    --i;
                }
            }
        }
    }
}
