package multiwarehouse.ecommerce.mapper;

import multiwarehouse.ecommerce.dto.message.PaymentUpdateRequest;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel;
import multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel;
import org.springframework.stereotype.Component;

@Component
public class PaymentMessagingDataMapper {
    public PaymentCreatedAvroModel paymentCreatedEventToPaymentCreatedAvroModel(PaymentCreatedEvent paymentCreatedEvent) {
        return PaymentCreatedAvroModel.newBuilder()
                .setPaymentId(paymentCreatedEvent.getPayment().getId().getValue().toString())
                .setReferenceId(paymentCreatedEvent.getPayment().getReferenceId().getValue().toString())
                .setAmount(paymentCreatedEvent.getPayment().getAmount().getAmount())
                .build();
    }

    public PaymentUpdateRequest paymentUpdateAvroModelToPaymentUpdate(PaymentUpdateAvroModel paymentUpdateAvroModel) {
        return PaymentUpdateRequest.builder()
                .paymentId(paymentUpdateAvroModel.getPaymentId())
                .referenceId(paymentUpdateAvroModel.getReferenceId())
                .paymentStatus(paymentUpdateAvroModel.getPaymentStatus().toString())
                .failedMessage(paymentUpdateAvroModel.getFailedMessage())
                .build();
    }
}
