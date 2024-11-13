package multiwarehouse.ecommerce.ports.input.message.listener.payment;

import multiwarehouse.ecommerce.dto.message.PaymentUpdateRequest;

public interface PaymentUpdateMessageListener {
    void updatePayment(PaymentUpdateRequest paymentUpdateRequest);
}
