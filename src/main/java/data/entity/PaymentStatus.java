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
        return PaymentStatus.values()[paymentStatusId];
    }
}

