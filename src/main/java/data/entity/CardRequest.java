package data.entity;

import java.sql.Date;

public class CardRequest extends Entity{
    private Long id;
    private Long cardNumber;
    private String title;

    public CardRequest(){
        title = "";
    }

    public CardRequest(Long cardNumber, String title){
        this.cardNumber = cardNumber;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
