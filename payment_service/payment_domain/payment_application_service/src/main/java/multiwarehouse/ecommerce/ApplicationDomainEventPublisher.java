package multiwarehouse.ecommerce;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationDomainEventPublisher implements ApplicationEventPublisherAware, DomainEventPublisher<PaymentCreatedEvent> {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(PaymentCreatedEvent paymentCreatedEvent) {
        log.info("Publishing PaymentCreatedEvent with id: {}", paymentCreatedEvent.getPayment().getId().getValue());
        applicationEventPublisher.publishEvent(paymentCreatedEvent);
    }
}
