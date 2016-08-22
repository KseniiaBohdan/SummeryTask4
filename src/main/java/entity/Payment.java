package entity;

import java.io.Serializable;
import java.util.Date;

public class Payment extends Entity implements Serializable{
    private Long id;
    private Date date;
    private Long number;
    private Long cardNumberReceiver;
    private Long getCardNumberSender;
    private String title;
    private Integer sum;
    private Integer paymentStatusId;

    public Payment(Long id, Date date, Long number, Long cardNumberReceiver, Long getCardNumberSender, String title, Integer sum, Integer paymentStatusId) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.cardNumberReceiver = cardNumberReceiver;
        this.getCardNumberSender = getCardNumberSender;
        this.title = title;
        this.sum = sum;
        this.paymentStatusId = paymentStatusId;
    }

    public Payment(Long number, Long cardNumberReceiver, Long getCardNumberSender, String title, Integer sum) {
        this.cardNumberReceiver = cardNumberReceiver;
        this.getCardNumberSender = getCardNumberSender;
        this.title = title;
        this.sum = sum;
        this.number = number;
        this.paymentStatusId = PaymentStatus.valueOf("PREPARED").ordinal()+1;
    }

    public Payment(){

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

    public Integer getPaymentStatusId() {
        return paymentStatusId;
    }

    public void setPaymentStatusId(Integer paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    public void setPaymentStatusId(PaymentStatus paymentStatus) {
        this.paymentStatusId = paymentStatus.ordinal();
    }
}
