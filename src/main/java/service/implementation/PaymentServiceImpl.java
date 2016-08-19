package service.implementation;

import dao.PaymentDao;
import dao.implementation.PaymentDaoImpl;
import entity.Payment;
import service.PaymentService;

import java.sql.SQLException;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private static PaymentDao paymentDao = new PaymentDaoImpl();

    public boolean update(Payment payment) {
        return false;
    }

    public boolean create(Payment payment) {
        try {
            return paymentDao.create(payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Payment> getAll() {
        return null;
    }

    public boolean deleteAll() {
        return false;
    }

    public List getByUserSenderId(Long userId){
        try {
            return paymentDao.getByUserSenderId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getByCardSenderId(Long cardSenderId) {
        return null;
    }

    public List getByUserReceiverId(Long userId) {
        try {
            return paymentDao.getByUserReceiverId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
