package data.dao;

import data.entity.Card;

import java.sql.SQLException;
import java.util.List;

public interface CardDao extends Dao<Card>{

    List getByAccountId(Long accountId) throws SQLException;

    List<Card> getActiveByUserId(Long userId);

    boolean update(List<Card> cards);
}
