package servlets.admin;

import data.entity.*;
import org.apache.log4j.Logger;
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

public class AdminProfile extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AdminProfile.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("AdminProfile open");
        req.setAttribute("userDeletedTotal", new UserServiceImpl().getByStatus(Status.DELETED.getId()).size());
        req.setAttribute("userBlockedTotal", new UserServiceImpl().getByStatus(Status.BLOCKED.getId()).size());
        req.setAttribute("userActiveTotal", new UserServiceImpl().getByStatus(Status.ACTIVE.getId()).size());
        req.setAttribute("sumTotal", countSum());
        req.setAttribute("operationTotal", countOperations());
        req.setAttribute("admins", countAdmins());
        req.getRequestDispatcher(PageConstant.ADMIN_PROFILE).include(req, resp);
    }

    private int countSum() {
        List<Payment> paymentList = new PaymentServiceImpl().getAll();
        List<Atm> atmList = new AtmServiceImpl().getAll();
        int sum=0;
        for (int i = 0; i < paymentList.size(); i++) {
            sum+=paymentList.get(i).getSum();
        }
        for (int i = 0; i < atmList.size(); i++) {
            sum+=atmList.get(i).getSum();
        }
        return sum;
    }

    private int countAdmins(){
        List<User> adminList = new UserServiceImpl().getAll();
        for (int i = 0; i < adminList.size(); i++) {
            if(adminList.get(i).getRole()!= Role.ADMIN || adminList.get(i).getStatus()!=Status.ACTIVE){
                adminList.remove(i);
                --i;
            }
        }
        return adminList.size();
    }

    private int countOperations() {
      return new PaymentServiceImpl().getAll().size()+new AtmServiceImpl().getAll().size();
    }
}
