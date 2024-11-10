package multiwarehouse.ecommerce.event;

import multiwarehouse.ecommerce.entity.Payment;

public abstract class PaymentEvent implements DomainEvent<Payment> {
    private final Payment payment;

    public PaymentEvent(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
}
