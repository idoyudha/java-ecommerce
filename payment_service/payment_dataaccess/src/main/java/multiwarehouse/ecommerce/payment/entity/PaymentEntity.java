package multiwarehouse.ecommerce.payment.entity;

import jakarta.persistence.*;
import lombok.*;
import multiwarehouse.ecommerce.valueobject.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
@Entity
public class PaymentEntity {
    @Id
    private UUID id;
    private UUID referenceId;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private FailedMessage failedMessage;
    private Money amount;
    private CreatedAt createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(referenceId, that.referenceId) && paymentMethod == that.paymentMethod && paymentStatus == that.paymentStatus && Objects.equals(failedMessage, that.failedMessage) && Objects.equals(amount, that.amount) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, referenceId, paymentMethod, paymentStatus, failedMessage, amount, createdAt);
    }
}
