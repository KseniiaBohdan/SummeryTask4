package data.dao;

import data.entity.CardRequest;

public interface CardRequestDao extends Dao<CardRequest> {
    boolean deleteByCardNumber(Long cardNumber);
}
