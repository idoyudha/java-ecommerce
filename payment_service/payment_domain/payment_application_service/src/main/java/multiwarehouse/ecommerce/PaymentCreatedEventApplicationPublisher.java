package multiwarehouse.ecommerce;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.ports.output.message.publisher.payment.PaymentCreatedRequestMessagePublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
//@Component
public class PaymentCreatedEventApplicationPublisher {
    private final PaymentCreatedRequestMessagePublisher paymentCreatedRequestMessagePublisher;

    public PaymentCreatedEventApplicationPublisher(PaymentCreatedRequestMessagePublisher paymentCreatedRequestMessagePublisher) {
        this.paymentCreatedRequestMessagePublisher = paymentCreatedRequestMessagePublisher;
    }

    @TransactionalEventListener
    void process(PaymentCreatedEvent paymentCreatedEvent) {
        paymentCreatedRequestMessagePublisher.publish(paymentCreatedEvent);
    }
}
