package service.implementation;

import dao.implementation.CardDaoImpl;
import entity.Card;
import service.CardService;

import java.sql.SQLException;
import java.util.List;

public class CardServiceImpl implements CardService {

    CardDaoImpl cardDao = new CardDaoImpl();

    public boolean update(Card card) throws SQLException {
        return false;
    }

    public boolean create(Card card) {
        try {
            return cardDao.create(card);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Card> getAll() {
        return null;
    }

    public boolean deleteAll() {
        return false;
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
        try {
            cardDao.getByAccountId(accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteByCardNumber(Long cardNumber) {
        try {
            return cardDao.deleteByCardNumber(cardNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
