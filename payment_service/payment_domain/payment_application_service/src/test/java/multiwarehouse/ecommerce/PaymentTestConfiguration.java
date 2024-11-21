package multiwarehouse.ecommerce;

import multiwarehouse.ecommerce.ports.output.message.publisher.payment.PaymentCreatedRequestMessagePublisher;
import multiwarehouse.ecommerce.ports.output.repository.PaymentRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "multiwarehouse.ecommerce")
public class PaymentTestConfiguration {
    @Bean
    public PaymentCreatedRequestMessagePublisher paymentCreatedRequestMessagePublisher() {
        return Mockito.mock(PaymentCreatedRequestMessagePublisher.class);
    }

    @Bean
    public PaymentRepository paymentRepository() {
        return Mockito.mock(PaymentRepository.class);
    }

    @Bean
    public PaymentDomainService paymentDomainService() {
        return Mockito.mock(PaymentDomainService.class);
    }
}
