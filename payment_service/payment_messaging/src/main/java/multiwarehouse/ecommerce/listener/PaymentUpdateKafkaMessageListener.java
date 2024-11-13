package multiwarehouse.ecommerce.listener;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.KafkaConsumer;
import multiwarehouse.ecommerce.mapper.PaymentMessagingDataMapper;
import multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel;
import multiwarehouse.ecommerce.ports.input.message.listener.payment.PaymentUpdateMessageListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PaymentUpdateKafkaMessageListener implements KafkaConsumer<PaymentUpdateAvroModel> {
    private final PaymentUpdateMessageListener paymentUpdateMessageListener;
    private final PaymentMessagingDataMapper paymentMessagingDataMapper;

    public PaymentUpdateKafkaMessageListener(PaymentUpdateMessageListener paymentUpdateMessageListener, PaymentMessagingDataMapper paymentMessagingDataMapper) {
        this.paymentUpdateMessageListener = paymentUpdateMessageListener;
        this.paymentMessagingDataMapper = paymentMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.payment-consumer-group-id}", topics = "${payment-service.payment-updated-topic-name}")
    public void receive(@Payload List<PaymentUpdateAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of payment update received with key:{}, partition:{}, and offsets: {}",
                messages.size(),
                keys,
                partitions.toString(),
                offsets.toString());

        messages.forEach(paymentUpdateAvroModel -> {
            log.info("Processing payment update for payment id: {}", paymentUpdateAvroModel.getPaymentId());
            paymentUpdateMessageListener.updatePayment(paymentMessagingDataMapper.paymentUpdateAvroModelToPaymentUpdate(paymentUpdateAvroModel));
        });
    };


}
