package multiwarehouse.ecommerce.mapper;

import multiwarehouse.ecommerce.dto.message.PaymentUpdateResponse;
import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel;
import multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel;
import org.springframework.stereotype.Component;

@Component
public class OrderMessagingDataMapper {
//    public PaymentCreatedAvroModel paymentCreatedEventToPaymentFailedAvroModel(PaymentCreatedEvent paymentCreatedEvent) {
//        Payment payment = paymentCreatedEvent.getPayment();
//        return PaymentCreatedAvroModel.newBuilder()
//                .setPaymentId(payment.getId().getValue().toString())
//                .setReferenceId(payment.getReferenceId().toString())
//                .setPaymentMethod(payment.getPaymentMethod())
//                .setPaymentStatus(payment.getPaymentStatus())
//                .setFailedMessage(payment.getFailedMessage())
//                .setAmount(payment.getAmount())
//                .setCreatedAt(payment.getCreatedAt())
//                .build();
//    }

    public PaymentUpdateResponse paymentUpdateAvroModelToPaymentUpdateResponse(PaymentUpdateAvroModel paymentUpdateAvroModel) {
        return PaymentUpdateResponse.builder()
                .id(paymentUpdateAvroModel.getId())
                .paymentId(paymentUpdateAvroModel.getPaymentId())
                .orderId(paymentUpdateAvroModel.getReferenceId())
                .paymentStatus(paymentUpdateAvroModel.getPaymentStatus().toString())
                .build();

    }

}
