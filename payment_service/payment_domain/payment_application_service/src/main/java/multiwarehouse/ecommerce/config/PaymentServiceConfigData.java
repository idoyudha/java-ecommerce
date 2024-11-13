package multiwarehouse.ecommerce.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("payment-service")
public class PaymentServiceConfigData {
    private String paymentCreatedTopicName;
    private String paymentUpdatedTopicName;
}
