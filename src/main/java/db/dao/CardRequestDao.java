package db.dao;

import data.entity.CardRequest;

import java.sql.Connection;

public interface CardRequestDao extends Dao<CardRequest> {

    boolean deleteByCardNumber(Connection con, Long cardNumber);
}
