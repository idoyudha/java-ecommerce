package multiwarehouse.ecommerce.payment.mapper;

import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.payment.entity.PaymentEntity;
import multiwarehouse.ecommerce.valueobject.PaymentId;
import multiwarehouse.ecommerce.valueobject.ReferenceId;
import org.springframework.stereotype.Component;

@Component
public class PaymentDataAccessMapper {
    public PaymentEntity paymentToPaymentEntity(Payment payment) {
        return PaymentEntity.builder()
                .id(payment.getId().getValue())
                .referenceId(payment.getReferenceId().getValue())
                .paymentMethod(payment.getPaymentMethod())
                .paymentStatus(payment.getPaymentStatus())
                .failedMessage(payment.getFailedMessage())
                .amount(payment.getAmount())
                .createdAt(payment.getCreatedAt())
                .build();
    }

    public Payment paymentEntityToPayment(PaymentEntity paymentEntity) {
        return Payment.builder()
                .paymentId(new PaymentId(paymentEntity.getId()))
                .referenceId(new ReferenceId(paymentEntity.getReferenceId()))
                .paymentMethod(paymentEntity.getPaymentMethod())
                .paymentStatus(paymentEntity.getPaymentStatus())
                .failedMessage(paymentEntity.getFailedMessage())
                .amount(paymentEntity.getAmount())
                .createdAt(paymentEntity.getCreatedAt())
                .build();
    }
}
