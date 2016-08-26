package service.impl;

import data.dao.impl.CardDaoImpl;
import data.entity.Card;
import data.entity.Status;
import service.CardService;

import java.sql.SQLException;
import java.util.List;

public class CardServiceImpl implements CardService {

    CardDaoImpl cardDao = new CardDaoImpl();

    public boolean update(Card card){
            return cardDao.update(card);
    }

    public boolean create(Card card) {
            return cardDao.create(card);
    }

    public List<Card> getAll() {
        return null;
    }

    public boolean deleteAll() {
        return false;
    }

    public  List getNotDeletedCardByUserId(Long userId){
        return cardDao.getNotDeletedCardByUserId(userId);
    }

    public List getByUserId(Long userId) {
        try {
            return cardDao.getByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getByAccountId(Long accountId) {
           return cardDao.getByAccountId(accountId);
    }

    public boolean deleteByCardNumber(Long cardNumber) {
        try {
            return cardDao.deleteByCardNumber(cardNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Card getByCardNumber(Long cardNumber) {
            return cardDao.getById(cardNumber);
    }

    public List<Card> getActiveByUserId(Long userId) {
        return cardDao.getActiveByUserId(userId);
    }

    public List<Card> getUserCardByStatus(Status status, Long userId) {
        return cardDao.getUsersCardByStatus(status, userId);
    }
}
