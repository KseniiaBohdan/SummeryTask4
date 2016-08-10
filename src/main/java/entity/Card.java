package entity;

import java.util.Date;

public class Card extends Entity{
    private Long cardNumber;
    private Long userId;
    private Date expireDate;
    private Integer pin;
    private BlockStatus status;
    private Long accountId;
    private String title;

    public Card(Long cardNumber, Long userId, Date expireDate, Integer pin, BlockStatus status, Long accountId, String title) {
        this.cardNumber = cardNumber;
        this.userId = userId;
        this.expireDate = expireDate;
        this.pin = pin;
        this.status = status;
        this.accountId = accountId;
        this.title = title;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Card(Long cardNumber, Date expireDate, Integer pin, Long accountId, String title) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.expireDate = expireDate;

        this.status = BlockStatus.unblocked;
        this.accountId = accountId;
        this.title = title;
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

    public BlockStatus getStatus() {
        return status;
    }

    public void setStatus(BlockStatus status) {
        this.status = status;
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
