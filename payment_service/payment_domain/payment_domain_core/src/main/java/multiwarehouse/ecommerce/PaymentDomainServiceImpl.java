package multiwarehouse.ecommerce;

import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

public class PaymentDomainServiceImpl implements PaymentDomainService {
    @Override
    public PaymentCreatedEvent createPayment(Payment payment, DomainEventPublisher<PaymentCreatedEvent> PaymentCreatedEventDomainEventPublisher) {
        payment.createPayment();
        return new PaymentCreatedEvent(payment, PaymentCreatedEventDomainEventPublisher);
    }
}
