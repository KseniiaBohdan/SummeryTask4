package data.entity;

public class Atm extends Entity{

    private Long id;
    private Long cardNumberReceiver;
    private Long sum;

    public Atm() {
        sum=0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardNumberReceiver() {
        return cardNumberReceiver;
    }

    public void setCardNumberReceiver(Long cardNumberReceiver) {
        this.cardNumberReceiver = cardNumberReceiver;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
}
