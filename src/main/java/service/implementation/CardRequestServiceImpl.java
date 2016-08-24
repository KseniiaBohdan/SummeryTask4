package service.implementation;

import data.dao.CardRequestDao;
import data.dao.impl.CardRequestDaoImpl;
import data.entity.CardRequest;
import service.CardRequestService;

import java.util.List;

public class CardRequestServiceImpl implements CardRequestService{

    CardRequestDao cardRequestDao = new CardRequestDaoImpl();


    public boolean update(CardRequest cardRequest) {
        return cardRequestDao.update(cardRequest);
    }

    public boolean create(CardRequest cardRequest) {
        return cardRequestDao.create(cardRequest);
    }

    public List<CardRequest> getAll() {
        return cardRequestDao.getAll();
    }

    public boolean deleteAll() {
        return cardRequestDao.deleteAll();
    }
}
