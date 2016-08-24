package data.entity;

import java.sql.Date;

public class CardRequest extends Entity{
    private Long id;
    private Long cardNumber;
    private Date unblockDate;
    private String title;

    public CardRequest(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getUnblockDate() {
        return unblockDate;
    }

    public void setUnblockDate(Date unblockDate) {
        this.unblockDate = unblockDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
