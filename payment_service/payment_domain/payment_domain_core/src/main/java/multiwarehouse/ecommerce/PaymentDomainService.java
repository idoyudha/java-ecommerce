package multiwarehouse.ecommerce;

import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

public interface PaymentDomainService {
    PaymentCreatedEvent createPayment(Payment payment, DomainEventPublisher<PaymentCreatedEvent> PaymentCreatedEventDomainEventPublisher);
}
