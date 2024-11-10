package multiwarehouse.ecommerce;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class KafkaMessageHelper {
    public <T>ListenableFutureCallback<SendResult<String, T>> getKafkaCallback(String responseTopicName, T avroModel, String orderId, String avroModelName) {
        return new ListenableFutureCallback<SendResult<String, T>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Error on kafka producer with key: {}, message: {} to topic: {} and exception: {}", orderId, avroModel, responseTopicName, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, T> result) {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("Success on kafka producer with key: {}, message: {} and partition: {}", orderId, avroModel, metadata.partition());
            }
        };
    }
}
