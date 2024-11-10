package multiwarehouse.ecommerce;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.dto.get.GetPaymentByRefIdQuery;
import multiwarehouse.ecommerce.dto.get.GetPaymentByRefIdResponse;
import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.exception.PaymentNotFoundException;
import multiwarehouse.ecommerce.mapper.PaymentDataMapper;
import multiwarehouse.ecommerce.ports.output.repository.PaymentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class PaymentGetCommandHandler {
    private final PaymentDataMapper paymentDataMapper;
    private final PaymentRepository paymentRepository;

    public PaymentGetCommandHandler(PaymentDataMapper paymentDataMapper, PaymentRepository paymentRepository) {
        this.paymentDataMapper = paymentDataMapper;
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public GetPaymentByRefIdResponse getPaymentByRefId(GetPaymentByRefIdQuery getPaymentByRefIdQuery) {
        Optional<Payment> paymentResult = paymentRepository.findPaymentByReferenceId(getPaymentByRefIdQuery.getReferenceId());
        if (paymentResult.isEmpty()) {
            log.error("Payment with reference id: {} not found", getPaymentByRefIdQuery.getReferenceId());
            throw new PaymentNotFoundException("Payment with reference id: " + getPaymentByRefIdQuery.getReferenceId() + " not found");
        }
        return paymentDataMapper.paymentToGetPaymentByRefIdResponse(paymentResult.get());
    }
}
