package multiwarehouse.ecommerce.entity;

import multiwarehouse.ecommerce.valueobject.*;

import java.util.UUID;

public class Payment extends AggregateRoot<PaymentId> {
    private final ReferenceId referenceId;
    private final PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private final Money amount;
    private final FailedMessage failedMessage;
    private final CreatedAt createdAt;

    public void initializePayment() {
        setId(new PaymentId(UUID.randomUUID()));
        paymentStatus = PaymentStatus.ONPROGRESS;
    }

    public void createPayment() {
        if (amountEquals(amount) && referenceIdEquals(referenceId)) {
            paymentStatus = PaymentStatus.SUCCESS;
        } else {
            paymentStatus = PaymentStatus.FAILED;
        }
    }

    private boolean referenceIdEquals(ReferenceId referenceId) {
        return this.referenceId.equals(referenceId);
    }

    private boolean amountEquals(Money moneyPaid) {
        return amount.equals(moneyPaid);
    }

    public void successPaid() {
        paymentStatus = PaymentStatus.SUCCESS;
    }

    public void failedPaid() {
        paymentStatus = PaymentStatus.FAILED;
    }

    private Payment(Builder builder) {
        super.setId(builder.paymentId);
        referenceId = builder.referenceId;
        paymentMethod = builder.paymentMethod;
        paymentStatus = builder.paymentStatus;
        failedMessage = builder.failedMessage;
        amount = builder.amount;
        createdAt = builder.createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ReferenceId getReferenceId() {
        return referenceId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public FailedMessage getFailedMessage() {
        return failedMessage;
    }

    public Money getAmount() {
        return amount;
    }

    public CreatedAt getCreatedAt() {
        return createdAt;
    }

    public static class Builder {
        private PaymentId paymentId;
        private ReferenceId referenceId;
        private PaymentMethod paymentMethod;
        private PaymentStatus paymentStatus;
        private FailedMessage failedMessage;
        private Money amount;
        private CreatedAt createdAt;

        private Builder() {
        }

        public Builder paymentId(PaymentId val) {
            paymentId = val;
            return this;
        }

        public Builder referenceId(ReferenceId val) {
            referenceId = val;
            return this;
        }

        public Builder paymentMethod(PaymentMethod val) {
            paymentMethod = val;
            return this;
        }

        public Builder paymentStatus(PaymentStatus val) {
            paymentStatus = val;
            return this;
        }

        public Builder failedMessage(FailedMessage val) {
            failedMessage = val;
            return this;
        }

        public Builder amount(Money val) {
            amount = val;
            return this;
        }

        public Builder createdAt(CreatedAt val) {
            createdAt = val;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
