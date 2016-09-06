package service;

import data.entity.Payment;

import java.util.List;

public interface PaymentService extends Service<Payment> {

    public List getByUserSenderId(Long userSenderCardId);

    public List getByCardSenderId(Long cardSenderId);

    public List getAll();

    List getByUserReceiverId(Long userId);

    Payment getById(Long id);
}
