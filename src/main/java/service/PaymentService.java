package service;

import entity.Payment;

import java.util.List;

public interface PaymentService extends Service<Payment> {

    public List getByUserSenderId(Long userId);

    public List getByCardSenderId(Long cardSenderId);
}
