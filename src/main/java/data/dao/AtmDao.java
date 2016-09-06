package data.dao;

import data.entity.Atm;

import java.util.List;

public interface AtmDao extends Dao<Atm>{

    List<Atm> getByUserId(Long userId);

}
