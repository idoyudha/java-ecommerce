package multiwarehouse.ecommerce.event;

import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

public class PaymentCreatedEvent extends PaymentEvent {
    private final DomainEventPublisher<PaymentCreatedEvent> PaymentCreatedEventDomainEventPublisher;

    public PaymentCreatedEvent(Payment payment, DomainEventPublisher<PaymentCreatedEvent> PaymentCreatedEventDomainEventPublisher) {
        super(payment);
        this.PaymentCreatedEventDomainEventPublisher = PaymentCreatedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        PaymentCreatedEventDomainEventPublisher.publish(this);
    }

}
