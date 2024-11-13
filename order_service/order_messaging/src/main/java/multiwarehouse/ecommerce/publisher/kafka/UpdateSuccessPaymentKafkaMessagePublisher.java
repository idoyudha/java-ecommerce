package multiwarehouse.ecommerce.publisher.kafka;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.KafkaMessageHelper;
import multiwarehouse.ecommerce.config.OrderServiceConfigData;
import multiwarehouse.ecommerce.event.OrderPaidEvent;
import multiwarehouse.ecommerce.mapper.OrderMessagingDataMapper;
import multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel;
import multiwarehouse.ecommerce.ports.output.message.publisher.payment.PaymentSuccessRequestMessagePublisher;
import multiwarehouse.ecommerce.service.KafkaProducer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateSuccessPaymentKafkaMessagePublisher implements PaymentSuccessRequestMessagePublisher {
    private final OrderMessagingDataMapper orderMessagingDataMapper;
    private final OrderServiceConfigData orderServiceConfigData;
    private final KafkaProducer<String, PaymentUpdateAvroModel> kafkaProducer;
    private final KafkaMessageHelper orderKafkaMessageHelper;

    private UpdateSuccessPaymentKafkaMessagePublisher(OrderMessagingDataMapper orderMessagingDataMapper,
                                                      OrderServiceConfigData orderServiceConfigData,
                                                      KafkaProducer<String, PaymentUpdateAvroModel> kafkaProducer,
                                                      KafkaMessageHelper orderKafkaMessageHelper) {
        this.orderMessagingDataMapper = orderMessagingDataMapper;
        this.orderServiceConfigData = orderServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.orderKafkaMessageHelper = orderKafkaMessageHelper;
    }

    @Override
    public void publish(OrderPaidEvent domainEvent) {
        String orderId = domainEvent.getOrder().getId().getValue().toString();
        try {
            PaymentUpdateAvroModel paymentUpdateAvroModel = orderMessagingDataMapper
                    .orderSuccessPaidEventToPaymentRequestAvroModel(domainEvent);

            kafkaProducer.sendWithoutCallback(orderServiceConfigData.getPaymentUpdatedTopicName(),
                    orderId,
                    paymentUpdateAvroModel);
            log.info("Payment success event published for order id: {}", orderId);
        } catch (Exception e) {
            log.error("Error while publishing payment success event for order id: {}", orderId, e);
        }
    }
}
