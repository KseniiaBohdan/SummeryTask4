package db.dao;

import data.entity.Card;

import java.sql.Connection;
import java.util.List;

public interface CardDao extends Dao<Card>{

    List getByAccountId(Connection con, Long accountId);

    List<Card> getActiveByUserId(Connection con, Long userId);

    boolean update(Connection con, List<Card> cards);
}
