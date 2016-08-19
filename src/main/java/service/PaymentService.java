package service;

import entity.Payment;

import java.util.List;

public interface PaymentService extends Service<Payment> {

    public List getByUserSenderId(Long userSenderCardId);

    public List getByCardSenderId(Long cardSenderId);

    List getByUserReceiverId(Long userId);
}
