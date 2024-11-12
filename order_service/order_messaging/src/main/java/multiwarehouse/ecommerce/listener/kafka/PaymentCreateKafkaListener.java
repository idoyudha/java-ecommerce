package multiwarehouse.ecommerce.listener.kafka;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.KafkaConsumer;
import multiwarehouse.ecommerce.mapper.OrderMessagingDataMapper;
import multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel;
import multiwarehouse.ecommerce.payment.avro.model.PaymentStatus;
import multiwarehouse.ecommerce.ports.input.message.listener.payment.PaymentCreateMessageListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PaymentCreateKafkaListener {
    private final PaymentCreateMessageListener paymentCreateMessageListener;
    private final OrderMessagingDataMapper orderMessagingDataMapper;

    public PaymentCreateKafkaListener(PaymentCreateMessageListener paymentCreateMessageListener, OrderMessagingDataMapper orderMessagingDataMapper) {
        this.paymentCreateMessageListener = paymentCreateMessageListener;
        this.orderMessagingDataMapper = orderMessagingDataMapper;
    }

//    @Override
//    @KafkaListener(id = "${kafka-consumer-config.order-consumer-group-id}", topics = "${order-service.payment-created-topic-name}")
//    public void receive(@Payload List<PaymentCreatedAvroModel> messages,
//                        @Header(KafkaHeaders.RECEIVED_KEY) String key,
//                        @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
//                        @Header(KafkaHeaders.OFFSET) Long offset) {
//        log.info("{} number of payment response received with key:{}, partition:{}, and offsets: {}"
//                messages.size(),
//                key,
//                partition.toString(),
//                offset.toString());
//
//        messages.forEach(paymentCreatedAvroModel -> {
//            log.info("Processing order status from payment created event for reference/order id: {}", paymentCreatedAvroModel.getReferenceId());
//            paymentCreateMessageListener.paymentProcess(orderMessagingDataMapper.paymentUpdateAvroModelToPaymentUpdateResponse(paymentCreatedAvroModel));
//        });
//    }
}
