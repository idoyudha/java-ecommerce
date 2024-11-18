package multiwarehouse.ecommerce.payment.mapper;

import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.payment.entity.PaymentEntity;
import multiwarehouse.ecommerce.valueobject.*;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class PaymentDataAccessMapper {
    public PaymentEntity paymentToPaymentEntity(Payment payment) {
        return PaymentEntity.builder()
                .id(payment.getId().getValue())
                .referenceId(payment.getReferenceId().getValue())
                .paymentMethod(payment.getPaymentMethod())
                .paymentStatus(payment.getPaymentStatus())
                .failedMessage(payment.getFailedMessage().getValue())
                .amount(payment.getAmount().getAmount())
                .createdAt(payment.getCreatedAt().getValue().toInstant())
                .build();
    }

    public Payment paymentEntityToPayment(PaymentEntity paymentEntity) {
        return Payment.builder()
                .paymentId(new PaymentId(paymentEntity.getId()))
                .referenceId(new ReferenceId(paymentEntity.getReferenceId()))
                .paymentMethod(paymentEntity.getPaymentMethod())
                .paymentStatus(paymentEntity.getPaymentStatus())
                .failedMessage(new FailedMessage(paymentEntity.getFailedMessage()))
                .amount(new Money(paymentEntity.getAmount()))
                .createdAt(new CreatedAt(ZonedDateTime.ofInstant(paymentEntity.getCreatedAt(), ZoneId.systemDefault())))
                .build();
    }
}
