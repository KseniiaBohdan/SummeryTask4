package data.entity;

import java.io.Serializable;
import java.util.Date;

public class Payment extends Entity implements Serializable{
    private Long id;
    private Date date;
    private Long number;
    private Long cardNumberReceiver;
    private Long cardNumberSender;
    private String title;
    private Integer sum;
    private PaymentStatus paymentStatus;

    public Payment(){
        paymentStatus = PaymentStatus.PREPARED;
        title = "";
        sum = 0;
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

    public Long getCardNumberSender() {
        return cardNumberSender;
    }

    public void setCardNumberSender(Long cardNumberSender) {
        this.cardNumberSender = cardNumberSender;
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

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatusId) {
        this.paymentStatus = PaymentStatus.getPaymentStatus(paymentStatusId);
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
