package multiwarehouse.ecommerce;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.dto.create.CreatePaymentCommand;
import multiwarehouse.ecommerce.dto.create.CreatePaymentResponse;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.mapper.PaymentDataMapper;
import multiwarehouse.ecommerce.ports.output.message.publisher.payment.PaymentCreatedRequestMessagePublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentCreateCommandHandler {
    private final PaymentCreateHelper paymentCreateHelper;
    private final PaymentDataMapper paymentDataMapper;
    private final PaymentCreatedRequestMessagePublisher paymentCreatedRequestMessagePublisher;

    public PaymentCreateCommandHandler(PaymentCreateHelper paymentCreateHelper, PaymentDataMapper paymentDataMapper, PaymentCreatedRequestMessagePublisher paymentCreatedRequestMessagePublisher) {
        this.paymentCreateHelper = paymentCreateHelper;
        this.paymentDataMapper = paymentDataMapper;
        this.paymentCreatedRequestMessagePublisher = paymentCreatedRequestMessagePublisher;
    }

    public CreatePaymentResponse createPayment(CreatePaymentCommand createPaymentCommand) {
        PaymentCreatedEvent paymentCreatedEvent = paymentCreateHelper.createPayment(createPaymentCommand);
        log.info("Payment is created with id: {}", paymentCreatedEvent.getPayment().getId().getValue());
        paymentCreatedRequestMessagePublisher.publish(paymentCreatedEvent);
        return paymentDataMapper.paymentToCreatePaymentResponse(paymentCreatedEvent.getPayment());
    }
}
