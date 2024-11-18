package multiwarehouse.ecommerce.mapper;

import multiwarehouse.ecommerce.dto.create.CreatePaymentCommand;
import multiwarehouse.ecommerce.dto.create.CreatePaymentResponse;
import multiwarehouse.ecommerce.dto.get.GetPaymentByRefIdResponse;
import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.valueobject.Money;
import multiwarehouse.ecommerce.valueobject.ReferenceId;
import org.springframework.stereotype.Component;

@Component
public class PaymentDataMapper {
    public Payment createPaymentCommandToPayment(CreatePaymentCommand createPaymentCommand) {
        return Payment.builder()
                .referenceId(new ReferenceId(createPaymentCommand.getReferenceId()))
                .paymentMethod(createPaymentCommand.getPaymentMethod())
                .amount(new Money(createPaymentCommand.getAmount()))
                .build();
    }

    public CreatePaymentResponse paymentToCreatePaymentResponse(Payment payment) {
        return CreatePaymentResponse.builder()
                .paymentId(payment.getId())
                .referenceId(payment.getReferenceId())
                .paymentMethod(payment.getPaymentMethod())
                .paymentStatus(payment.getPaymentStatus())
                .failedMessage(payment.getFailedMessage())
                .amount(payment.getAmount())
                .createdAt(payment.getCreatedAt())
                .build();
    }

    public GetPaymentByRefIdResponse paymentToGetPaymentByRefIdResponse(Payment payment) {
        return GetPaymentByRefIdResponse.builder()
                .paymentId(payment.getId().getValue())
                .referenceId(payment.getReferenceId().getValue())
                .paymentMethod(payment.getPaymentMethod())
                .paymentStatus(payment.getPaymentStatus())
                .failedMessage(payment.getFailedMessage().getValue())
                .amount(payment.getAmount().getAmount())
                .createdAt(payment.getCreatedAt().getValue().toInstant())
                .build();
    }
}
