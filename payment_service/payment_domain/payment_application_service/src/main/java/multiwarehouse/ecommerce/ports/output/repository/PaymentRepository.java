package multiwarehouse.ecommerce.ports.output.repository;

import multiwarehouse.ecommerce.entity.Payment;
import multiwarehouse.ecommerce.valueobject.ReferenceId;

import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findPaymentByReferenceId(ReferenceId referenceId);
}
