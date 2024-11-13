package multiwarehouse.ecommerce;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

//@Slf4j
public class PaymentDomainServiceImpl implements PaymentDomainService {
    @Override
    public PaymentCreatedEvent createPayment(Payment payment, DomainEventPublisher<PaymentCreatedEvent> PaymentCreatedEventDomainEventPublisher) {
        payment.initializePayment();
//        log.info("Payment with id: {} already initialized", payment.getId().getValue());
        return new PaymentCreatedEvent(payment, PaymentCreatedEventDomainEventPublisher);
    }
}
