package multiwarehouse.ecommerce;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.dto.create.CreatePaymentCommand;
import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.event.PaymentCreatedEvent;
import multiwarehouse.ecommerce.exception.PaymentDomainException;
import multiwarehouse.ecommerce.mapper.PaymentDataMapper;
import multiwarehouse.ecommerce.ports.output.message.publisher.payment.PaymentCreatedRequestMessagePublisher;
import multiwarehouse.ecommerce.ports.output.repository.PaymentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class PaymentCreateHelper {
    private final PaymentDomainService paymentDomainService;
    private final PaymentRepository paymentRepository;
    private final PaymentDataMapper paymentDataMapper;
    private final PaymentCreatedRequestMessagePublisher paymentCreatedRequestMessagePublisher;

    public PaymentCreateHelper(PaymentDomainService paymentDomainService, PaymentRepository paymentRepository, PaymentDataMapper paymentDataMapper, PaymentCreatedRequestMessagePublisher paymentCreatedRequestMessagePublisher) {
        this.paymentDomainService = paymentDomainService;
        this.paymentRepository = paymentRepository;
        this.paymentDataMapper = paymentDataMapper;
        this.paymentCreatedRequestMessagePublisher = paymentCreatedRequestMessagePublisher;
    }

    @Transactional
    public PaymentCreatedEvent createPayment(CreatePaymentCommand createPaymentCommand) {
        Payment payment = paymentDataMapper.createPaymentCommandToPayment(createPaymentCommand);
        PaymentCreatedEvent paymentCreatedEvent = paymentDomainService.createPayment(payment, paymentCreatedRequestMessagePublisher);
        log.info("Payment created with id: {}", paymentCreatedEvent.getPayment().getId().getValue());
        paymentRepository.save(payment);
        return paymentCreatedEvent;
    }

    private Payment savePayment(Payment payment) {
        Payment paymentResult = paymentRepository.save(payment);
        if (paymentResult == null) {
            log.error("Failed to save payment");
            throw new PaymentDomainException("Failed to save payment");
        }
        log.info("Payment saved with id: {}", paymentResult.getId().getValue());
        return paymentResult;
    }
}
