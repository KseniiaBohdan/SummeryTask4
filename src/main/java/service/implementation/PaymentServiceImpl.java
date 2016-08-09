package service.implementation;

import entity.Entity;
import entity.Payment;
import service.PaymentService;

import java.sql.SQLException;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    public boolean update(Payment payment) throws SQLException {
        return false;
    }

    public boolean create(Payment payment) {
        return false;
    }

    public List<Payment> getAll() {
        return null;
    }

    public boolean deleteAll() {
        return false;
    }
}
