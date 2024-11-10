package multiwarehouse.ecommerce.payment.adapter;

import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.payment.mapper.PaymentDataAccessMapper;
import multiwarehouse.ecommerce.payment.repository.PaymentJpaRepository;
import multiwarehouse.ecommerce.ports.output.repository.PaymentRepository;
import multiwarehouse.ecommerce.valueobject.ReferenceId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PaymentRepositoryImpl implements PaymentRepository {
   private final PaymentJpaRepository paymentJpaRepository;
   private final PaymentDataAccessMapper paymentDataAccessMapper;

    public PaymentRepositoryImpl(PaymentJpaRepository paymentJpaRepository, PaymentDataAccessMapper paymentDataAccessMapper) {
        this.paymentJpaRepository = paymentJpaRepository;
        this.paymentDataAccessMapper = paymentDataAccessMapper;
    }

    @Override
    public Payment save(Payment payment) {
        return paymentDataAccessMapper.paymentEntityToPayment(paymentJpaRepository.saveAndFlush(paymentDataAccessMapper.paymentToPaymentEntity(payment)));
    }

    @Override
    public Optional<Payment> findPaymentByReferenceId(ReferenceId referenceId) {
        return paymentJpaRepository.findByReferenceId(referenceId.getValue()).map(paymentDataAccessMapper::paymentEntityToPayment);
    }
}
