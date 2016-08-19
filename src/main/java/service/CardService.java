package service;

import entity.Card;

import java.util.List;

public interface CardService extends Service<Card> {

    List getByUserId(Long userId);

    List getByAccountId(Long accountId);

    boolean deleteByCardNumber(Long cardNumber);

    Card getByCardNumber(Long cardNumber);
}
