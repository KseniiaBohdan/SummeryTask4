package data.dto;

import data.entity.Account;
import data.entity.Card;
import data.entity.User;

import java.util.List;

public class UserDto {

    private User user;
    private List<Card> cards;
    private List<Account> accounts;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
