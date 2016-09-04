package service.impl;

import data.dao.AtmDao;
import data.dao.impl.AtmDaoImpl;
import data.entity.Atm;
import service.AtmService;

import java.util.List;

public class AtmServiceImpl implements AtmService{

    private AtmDao atmDao = new AtmDaoImpl();

    public boolean create(Atm atm) {
        return atmDao.create(atm);
    }

    public boolean update(Atm atm) {
        return false;
    }

    public List<Atm> getAll() {
        return atmDao.getAll();
    }

    public boolean deleteAll() {
        return false;
    }

    public boolean update(List<Atm> entity) {
        return false;
    }
}
