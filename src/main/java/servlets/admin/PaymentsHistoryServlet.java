package servlets.admin;

import data.dto.PaymentDto;
import data.entity.User;
import servlets.PageConstant;
import data.entity.Payment;
import service.UserService;
import service.impl.PaymentServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PaymentsHistoryServlet extends HttpServlet {

    private static final String FROM = "from";
    private static final String TO = "to";
    private static final String PAYMENT_MODAL_LIST = "paymentModalList";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<Payment> paymentList = new PaymentServiceImpl().getAll();
        List<PaymentDto> paymentModelList = new ArrayList();
        User temp;
        for (int i = 0; i < paymentList.size(); i++) {
            PaymentDto paymentModal = new PaymentDto();
            paymentModal.setPayment(paymentList.get(i));
            temp = userService.getByCardNumber(paymentList.get(i).getCardNumberReceiver());
            paymentModal.setReceiverName(temp.getName());
            temp = userService.getByCardNumber(paymentList.get(i).getCardNumberSender());
            paymentModal.setSenderName(temp.getName());
            paymentModelList.add(paymentModal);
        }

        try {
            String stringFrom = req.getParameter(FROM);
            String stringTo = req.getParameter(TO);

            if (stringFrom != null & stringTo != null) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date dateFrom = format.parse(stringFrom);
                Date dateTo = format.parse(stringTo);

                boolean valid = dateFrom.before(dateTo);

                for (int i = 0; i < paymentList.size(); i++) {
                    if (paymentList.get(i).getDate().before(dateFrom) || paymentList.get(i).getDate().after(dateTo)) {
                        paymentList.remove(i);
                        --i;
                    }
                }
            }
        } catch (ParseException e) {

        }
        req.setAttribute(PAYMENT_MODAL_LIST, paymentModelList);
        req.getRequestDispatcher(PageConstant.PAYMENTS_HISTORY).include(req, resp);
    }

}
