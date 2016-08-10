package service.implementation;

import dao.implementation.CardDaoImpl;
import entity.Card;
import entity.Entity;
import service.CardService;
import service.Service;

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
}
