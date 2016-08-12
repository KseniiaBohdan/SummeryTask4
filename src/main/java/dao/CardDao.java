package dao;

import entity.Card;

import java.sql.SQLException;
import java.util.List;

public interface CardDao extends Dao<Card>{

    List getByAccountId(Long accountId) throws SQLException;
}
