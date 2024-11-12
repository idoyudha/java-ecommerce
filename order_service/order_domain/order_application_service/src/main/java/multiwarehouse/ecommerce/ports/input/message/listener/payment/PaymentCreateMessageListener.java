package multiwarehouse.ecommerce.ports.input.message.listener.payment;

import multiwarehouse.ecommerce.dto.message.PaymentCreateRequest;

public interface PaymentCreateMessageListener {
    void paymentProcess(PaymentCreateRequest paymentCreateRequest);
}
