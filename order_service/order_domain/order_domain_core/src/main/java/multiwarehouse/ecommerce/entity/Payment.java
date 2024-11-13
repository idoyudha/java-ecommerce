package multiwarehouse.ecommerce.entity;

import multiwarehouse.ecommerce.valueobject.CreatedAt;
import multiwarehouse.ecommerce.valueobject.Money;
import multiwarehouse.ecommerce.valueobject.PaymentId;
import multiwarehouse.ecommerce.valueobject.PaymentStatus;

public class Payment extends BaseEntity<PaymentId> {
    private Money amount;
    private PaymentStatus paymentStatus;
    private String failedMessage;
    private CreatedAt createdAt;

    public Payment(PaymentId id, Money amount, PaymentStatus paymentStatus, String failedMessage, CreatedAt createdAt) {
        super.setId(id);
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.failedMessage = failedMessage;
        this.createdAt = createdAt;
    }

    public Payment(PaymentId paymentId) {
        super.setId(paymentId);
    }

    public Money getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public CreatedAt getCreatedAt() {
        return createdAt;
    }

    public String getFailedMessage() {
        return failedMessage;
    }
}
