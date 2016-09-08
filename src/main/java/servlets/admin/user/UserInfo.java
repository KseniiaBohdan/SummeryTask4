package servlets.admin.user;

import data.dto.UserDto;
import data.entity.Atm;
import data.entity.Payment;
import service.impl.AtmServiceImpl;
import service.impl.PaymentServiceImpl;
import service.impl.UserServiceImpl;
import servlets.constant.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId;
        if((req.getParameter("userId"))!=null){
            userId = Long.valueOf(req.getParameter("userId"));
            req.getSession().setAttribute("userInfoId", Long.valueOf(req.getParameter("userId")));
        }else {
            userId = Long.valueOf(req.getSession().getAttribute("userInfoId").toString());
        }

        UserDto userModal = new UserServiceImpl().getUserDto(userId);
        List<Payment> paymentList = new PaymentServiceImpl().getByUserSenderId(userId);
        List<Atm> atmList = new AtmServiceImpl().getByUserId(userId);
        req.setAttribute("userModel", userModal);
        req.setAttribute("paymentL", paymentList);
        req.setAttribute("atmL", atmList);
        req.getRequestDispatcher(PageConstant.USER_INFO).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
