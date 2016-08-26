package data.dao;

import data.entity.CardRequest;

/**
 * Created by hp on 24.08.2016.
 */
public interface CardRequestDao extends Dao<CardRequest> {
    boolean deleteByCardNumber(Long cardNumber);
}
