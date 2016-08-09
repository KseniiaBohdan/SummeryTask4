package service.implementation;

import entity.Card;
import entity.Entity;
import service.CardService;
import service.Service;

import java.sql.SQLException;
import java.util.List;

public class CardServiceImpl implements CardService {
    public boolean update(Card card) throws SQLException {
        return false;
    }

    public boolean create(Card card) {
        return false;
    }

    public List<Card> getAll() {
        return null;
    }

    public boolean deleteAll() {
        return false;
    }
}
