package multiwarehouse.ecommerce.service.impl;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.exception.KafkaProducerException;
import multiwarehouse.ecommerce.service.KafkaProducer;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class KafkaProducerImpl<K extends Serializable, V extends SpecificRecordBase> implements KafkaProducer<K, V> {
    private final KafkaTemplate<K, V> kafkaTemplate;

    public KafkaProducerImpl(KafkaTemplate<K, V> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendWithCallback(String topicName, K key, V message, CompletableFuture<SendResult<K, V>> callback) {
        log.info("Sending with callback message={} to topic {}", message, topicName);
        try {
            CompletableFuture<SendResult<K, V>> kafkaResultFuture = kafkaTemplate.send(topicName, key, message);
            kafkaResultFuture.whenComplete(
                    (result, exception) -> {
                        if (exception != null) {
                            log.error("Error on kafka callback producer with key: {}, message: {} and exception: {}", key, message, exception.getMessage());
                            callback.completeExceptionally(exception);
                        } else {
                            RecordMetadata metadata = result.getRecordMetadata();
                            log.info("Success on kafka producer with key: {}, message: {} and partition: {}", key, message, metadata.partition());
                            callback.complete(result);
                        }
                    }
            );
        } catch (KafkaException e) {
            log.error("Error on kafka producer with key: {}, message: {} and exception: {}", key, message, e.getMessage());
            throw new KafkaProducerException("Error on kafka producer with key: " + key + " and message: " + message);
        }
    }

    @Override
    public void sendWithoutCallback(String topicName, K key, V message) {
        log.info("Sending without callback message={} to topic {}", message, topicName);
        kafkaTemplate.send(topicName, key, message);
    }

    @PreDestroy
    public void close() {
        if (kafkaTemplate != null) {
            log.info("Destroying kafka producer");
            kafkaTemplate.destroy();
        }
    }
}
