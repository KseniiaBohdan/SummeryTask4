package service;

import data.entity.Card;
import data.entity.Status;

import java.util.List;

public interface CardService extends Service<Card> {

    List getByUserId(Long userId);

    List getByAccountId(Long accountId);

    boolean deleteByCardNumber(Long cardNumber);

    Card getByCardNumber(Long cardNumber);

    void removeCardsByStatus( List<Card> cardList, Status... status);
}
