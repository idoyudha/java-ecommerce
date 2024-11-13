package multiwarehouse.ecommerce.mapper;

import multiwarehouse.ecommerce.dto.message.PaymentCreateRequest;
import multiwarehouse.ecommerce.dto.message.PaymentUpdateResponse;
import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.event.OrderFailedEvent;
import multiwarehouse.ecommerce.event.OrderPaidEvent;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel;
import multiwarehouse.ecommerce.payment.avro.model.PaymentStatus;
import multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel;
import org.springframework.stereotype.Component;

@Component
public class OrderMessagingDataMapper {
    public PaymentCreateRequest paymentCreatedAvroModelToPaymentCreated(PaymentCreatedAvroModel paymentCreatedAvroModel) {
        return PaymentCreateRequest.builder()
                .paymentId(paymentCreatedAvroModel.getPaymentId())
                .referenceId(paymentCreatedAvroModel.getReferenceId())
                .amount(paymentCreatedAvroModel.getAmount())
                .createdAt(paymentCreatedAvroModel.getCreatedAt())
                .build();
    }

    public PaymentUpdateResponse paymentUpdateAvroModelToPaymentUpdateResponse(PaymentUpdateAvroModel paymentUpdateAvroModel) {
        return PaymentUpdateResponse.builder()
                .id(paymentUpdateAvroModel.getId())
                .paymentId(paymentUpdateAvroModel.getPaymentId())
                .orderId(paymentUpdateAvroModel.getReferenceId())
                .paymentStatus(paymentUpdateAvroModel.getPaymentStatus().toString())
                .build();

    }

    public PaymentUpdateAvroModel orderFailedEventToPaymentRequestAvroModel(OrderFailedEvent orderFailedEvent) {
        Order order = orderFailedEvent.getOrder();
        Payment payment = order.getPayment();
        return PaymentUpdateAvroModel.newBuilder()
                .setId(order.getId().getValue().toString())
                .setPaymentId(payment.getId().getValue().toString())
                .setReferenceId(order.getId().getValue().toString())
                .setPaymentStatus(PaymentStatus.valueOf(payment.getPaymentStatus().toString()))
                .setFailedMessage(payment.getFailedMessage())
                .build();
    }

    public PaymentUpdateAvroModel orderSuccessPaidEventToPaymentRequestAvroModel(OrderPaidEvent orderPaidEvent) {
        Order order = orderPaidEvent.getOrder();
        Payment payment = order.getPayment();
        return PaymentUpdateAvroModel.newBuilder()
                .setId(payment.getId().getValue().toString())
                .setPaymentId(payment.getId().getValue().toString())
                .setReferenceId(order.getId().getValue().toString())
                .setPaymentStatus(PaymentStatus.valueOf(payment.getPaymentStatus().toString()))
                .setFailedMessage(payment.getFailedMessage())
                .build();
    }
}
