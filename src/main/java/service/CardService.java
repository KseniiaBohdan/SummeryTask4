package service;

import data.entity.Card;

import java.util.List;

public interface CardService extends Service<Card> {

    List getByUserId(Long userId);

    List getNotDeletedCardByUserId(Long userId);

    List getByAccountId(Long accountId);

    boolean deleteByCardNumber(Long cardNumber);

    Card getByCardNumber(Long cardNumber);

    List<Card> getActiveByUserId(Long userId);
}
