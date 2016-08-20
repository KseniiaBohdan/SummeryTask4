package entity;

import java.io.Serializable;

public enum PaymentStatus implements Serializable{
    CLIENT, ADMIN;

    public static PaymentStatus getPaymentStatus(Payment payment) {
        long paymentStatusId = payment.getPaymentStatusId();
        return PaymentStatus.values()[(int) paymentStatusId];
    }

    public String getName() {
        return name().toLowerCase();
    }
}

