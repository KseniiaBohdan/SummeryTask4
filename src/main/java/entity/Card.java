package entity;

import java.io.Serializable;
import java.sql.Date;

public class Card extends Entity implements Serializable{
    private Long cardNumber;
    private Long userId;
    private Date expiryDate;
    private Integer pin;
    private Integer statusId;
    private Long accountId;
    private String title;

    public Card(Long cardNumber, Long userId, Date expiryDate, Integer pin, Integer statusId, String title, Long accountId) {
        this.cardNumber = cardNumber;
        this.userId = userId;
        this.expiryDate = expiryDate;
        this.pin = pin;
        this.statusId = statusId;
        this.title = title;
        this.accountId = accountId;
    }

    public Card(Long cardNumber, Long userId, Date expiryDate, Integer pin, String title, Long accountId) {
        this.cardNumber = cardNumber;
        this.userId = userId;
        this.expiryDate = expiryDate;
        this.pin = pin;
        this.title = title;
        this.accountId = accountId;
        this.statusId=Status.valueOf("UNBLOCKED").ordinal();
    }

    public Card() {

    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Card(Long cardNumber, Date expiryDate, Integer pin, Long accountId, String title) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.expiryDate = expiryDate;
        this.accountId = accountId;
        this.title = title;
        this.statusId = 1;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Status status) {
        this.statusId = status.ordinal();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
