package service.impl;

import data.entity.Card;
import data.entity.Status;
import db.dao.impl.CardDaoImpl;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import db.transaction.impl.JdbcTransactionManager;
import service.CardService;

import java.sql.Connection;
import java.util.List;

public class CardServiceImpl implements CardService {

    CardDaoImpl cardDao = new CardDaoImpl();
    private TransactionManager transactionManager = new JdbcTransactionManager();


    public boolean update(final Card card) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return cardDao.update(connection, card);
            }
        });
    }

    public boolean create(final Card card) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return cardDao.create(connection, card);
            }
        });
    }

    public List<Card> getAll() {
        return null;
    }

    public boolean deleteAll() {
        return false;
    }

    public boolean update(final List<Card> cards) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return cardDao.update(connection, cards);
            }
        });
    }

    public List getNotDeletedCardByUserId(final Long userId) {
        return transactionManager.execute(new TransactionOperation<List>() {
            @Override
            public List execute(Connection connection) {
                return cardDao.getNotDeletedCardByUserId(connection, userId);
            }
        });
    }

    public List getByUserId(final Long userId) {
        return transactionManager.execute(new TransactionOperation<List>() {
            @Override
            public List execute(Connection connection) {
                return cardDao.getByUserId(connection, userId);
            }
        });
    }

    public List getByAccountId(final Long accountId) {
        return transactionManager.execute(new TransactionOperation<List>() {
            @Override
            public List execute(Connection connection) {
                return cardDao.getByAccountId(connection, accountId);
            }
        });
    }

    public boolean deleteByCardNumber(final Long cardNumber) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return cardDao.deleteByCardNumber(connection, cardNumber);
            }
        });
    }

    public Card getByCardNumber(final Long cardNumber) {
        return transactionManager.execute(new TransactionOperation<Card>() {
            @Override
            public Card execute(Connection connection) {
                return cardDao.getById(connection, cardNumber);
            }
        });
    }

    public void removeCardsByStatus(List<Card> cardList, Status... status) {
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < cardList.size(); j++) {
                if (cardList.get(j).getStatus().equals(status[i])) {
                    cardList.remove(j);
                    --j;
                }
            }
        }
    }


    public Boolean blockCard(final Long cardId) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                Card card = cardDao.getById(connection, cardId);
                card.setStatus(Status.BLOCKED);
                return cardDao.update(connection, card);
            }
        });
    }
}
