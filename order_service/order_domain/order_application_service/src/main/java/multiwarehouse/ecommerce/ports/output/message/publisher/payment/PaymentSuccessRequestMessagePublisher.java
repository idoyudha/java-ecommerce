package multiwarehouse.ecommerce.ports.output.message.publisher.payment;

import multiwarehouse.ecommerce.event.OrderPaidEvent;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

public interface PaymentSuccessRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
