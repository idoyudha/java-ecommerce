package multiwarehouse.ecommerce.publisher;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.KafkaMessageHelper;
import multiwarehouse.ecommerce.config.PaymentServiceConfigData;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.mapper.PaymentMessagingDataMapper;
import multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel;
import multiwarehouse.ecommerce.ports.output.message.publisher.payment.PaymentCreatedRequestMessagePublisher;
import multiwarehouse.ecommerce.service.KafkaProducer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreatePaymentKafkaMessagePublisher implements PaymentCreatedRequestMessagePublisher {
    private final PaymentMessagingDataMapper paymentMessagingDataMapper;
    private final PaymentServiceConfigData paymentServiceConfigData;
    private final KafkaProducer<String, PaymentCreatedAvroModel> kafkaProducer;
    private final KafkaMessageHelper paymentKafkaMessageHelper;

    public CreatePaymentKafkaMessagePublisher(PaymentMessagingDataMapper paymentMessagingDataMapper,
                                              PaymentServiceConfigData paymentServiceConfigData,
                                              KafkaProducer<String, PaymentCreatedAvroModel> kafkaProducer,
                                              KafkaMessageHelper paymentKafkaMessageHelper) {
        this.paymentMessagingDataMapper = paymentMessagingDataMapper;
        this.paymentServiceConfigData = paymentServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.paymentKafkaMessageHelper = paymentKafkaMessageHelper;
    }

    @Override
    public void publish(PaymentCreatedEvent domainEvent) {
        String referenceId = domainEvent.getPayment().getReferenceId().getValue().toString();
        log.info("Publishing PaymentCreatedEvent with referenceId: {}", referenceId);
        try {
            PaymentCreatedAvroModel paymentCreatedAvroModel = paymentMessagingDataMapper.paymentCreatedEventToPaymentCreatedAvroModel(domainEvent);
            kafkaProducer.sendWithoutCallback(paymentServiceConfigData.getPaymentCreatedTopicName(),
                    referenceId,
                    paymentCreatedAvroModel);
        } catch (Exception e) {
            log.error("Error while publishing PaymentCreatedEvent with referenceId: {}", referenceId, e);
        }
    }
}
