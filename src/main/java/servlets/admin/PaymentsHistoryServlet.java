package servlets.admin;

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
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PaymentsHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Payment> paymentList = new PaymentServiceImpl().getAll();
        try {
            String stringFrom = req.getParameter("from");
            String stringTo = req.getParameter("to");

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
        req.setAttribute("paymentList", paymentList);
        req.getRequestDispatcher(PageConstant.PAYMENTS_HISTORY).include(req, resp);
    }

}
