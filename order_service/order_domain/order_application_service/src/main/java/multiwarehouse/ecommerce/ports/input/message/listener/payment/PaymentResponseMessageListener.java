package multiwarehouse.ecommerce.ports.input.message.listener.payment;

import multiwarehouse.ecommerce.dto.message.PaymentUpdateResponse;

public interface PaymentResponseMessageListener {
    void paymentSuccess(PaymentUpdateResponse paymentUpdateResponse);
    void paymentFailed(PaymentUpdateResponse paymentUpdateResponse);
}
