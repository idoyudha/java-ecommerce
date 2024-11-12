package multiwarehouse.ecommerce.ports.output.message.publisher.payment;

import multiwarehouse.ecommerce.event.OrderFailedEvent;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

public interface PaymentFailedRequestMessagePublisher extends DomainEventPublisher<OrderFailedEvent> {
}
