package entity;

import java.util.Date;

public class Payment extends Entity{
    private Long id;
    private Date date;
    private Long number;
    private Long cardNumberReceiver;
    private Long getCardNumberSender;
    private String title;
    private Integer sum;
    private PaymentStatus status;

    public Payment(Long id, Date date, Long number, Long cardNumberReceiver, Long getCardNumberSender, String title, Integer sum, PaymentStatus status) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.cardNumberReceiver = cardNumberReceiver;
        this.getCardNumberSender = getCardNumberSender;
        this.title = title;
        this.sum = sum;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getCardNumberReceiver() {
        return cardNumberReceiver;
    }

    public void setCardNumberReceiver(Long cardNumberReceiver) {
        this.cardNumberReceiver = cardNumberReceiver;
    }

    public Long getGetCardNumberSender() {
        return getCardNumberSender;
    }

    public void setGetCardNumberSender(Long getCardNumberSender) {
        this.getCardNumberSender = getCardNumberSender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
