package multiwarehouse.ecommerce.ports.output.message.publisher.payment;

import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

public interface PaymentCreatedRequestMessagePublisher extends DomainEventPublisher<PaymentCreatedEvent> {
}
