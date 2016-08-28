package data.entity;

import java.io.Serializable;

public enum PaymentStatus implements Serializable {
    PREPARED(1), COMPLETED(2);

    private int id;

    PaymentStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static PaymentStatus getPaymentStatus(int paymentStatusId) {
        for(PaymentStatus s : PaymentStatus.values()){
            if(s.getId()==paymentStatusId){
                return s;
            }
        }
        return COMPLETED;
    }
}

