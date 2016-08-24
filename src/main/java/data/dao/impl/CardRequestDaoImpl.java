package data.dao.impl;

import data.dao.CardRequestDao;
import data.entity.CardRequest;

import java.util.List;

public class CardRequestDaoImpl implements CardRequestDao {

    public static final String UPDATE = "";
    public static final String CREATE = "";
    public static final String GET_ALL = "";
    public static final String GET_BY_ID = "";

    public boolean update(CardRequest cardRequest){
        return false;
    }

    public boolean create(CardRequest cardRequest){
        return false;
    }

    public List<CardRequest> getAll(){
        return null;
    }

    public boolean deleteAll(){
        return false;
    }
}
