package db.dao;

import data.entity.Atm;

import java.sql.Connection;
import java.util.List;

public interface AtmDao extends Dao<Atm>{

    List<Atm> getByUserId(Connection con, Long userId);

}
