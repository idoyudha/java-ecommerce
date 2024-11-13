package multiwarehouse.ecommerce.service;

import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.support.SendResult;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public interface KafkaProducer<K extends Serializable, V extends SpecificRecordBase> {
    void sendWithCallback(String topicName, K key, V message, CompletableFuture<SendResult<K, V>> callback);
    void sendWithoutCallback(String topicName, K key, V message);
}
