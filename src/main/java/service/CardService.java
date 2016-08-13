package service;

import entity.Card;

import java.util.List;

public interface CardService extends Service<Card> {

    public List getByUserId(Long userId);

    public List getByAccountId(Long accountId);

    public boolean deleteByCardNumber(Long cardNumber);
}
