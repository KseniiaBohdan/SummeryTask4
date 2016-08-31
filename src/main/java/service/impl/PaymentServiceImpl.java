package service.impl;

import data.dao.PaymentDao;
import data.dao.impl.PaymentDaoImpl;
import data.entity.Payment;
import service.PaymentService;

import java.sql.SQLException;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private static PaymentDao paymentDao = new PaymentDaoImpl();

    public boolean update(Payment payment) {
        return false;
    }

    public boolean create(Payment payment) {
        return paymentDao.create(payment);
    }

    public List<Payment> getAll() {
        return paymentDao.getAll();
    }

    public boolean deleteAll() {
        return false;
    }

    public boolean update(List<Payment> entity) {
        return false;
    }

    public List getByUserSenderId(Long userId){
            return paymentDao.getByUserSenderId(userId);
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
