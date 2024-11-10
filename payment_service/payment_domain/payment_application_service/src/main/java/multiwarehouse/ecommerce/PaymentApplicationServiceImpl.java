package multiwarehouse.ecommerce;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.dto.create.CreatePaymentCommand;
import multiwarehouse.ecommerce.dto.create.CreatePaymentResponse;
import multiwarehouse.ecommerce.dto.get.GetPaymentByRefIdQuery;
import multiwarehouse.ecommerce.dto.get.GetPaymentByRefIdResponse;
import multiwarehouse.ecommerce.ports.input.service.PaymentApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class PaymentApplicationServiceImpl implements PaymentApplicationService {
    private final PaymentCreateCommandHandler paymentCreateCommandHandler;
    private final PaymentGetCommandHandler paymentGetCommandHandler;

    public PaymentApplicationServiceImpl(PaymentCreateCommandHandler paymentCreateCommandHandler, PaymentGetCommandHandler paymentGetCommandHandler) {
        this.paymentCreateCommandHandler = paymentCreateCommandHandler;
        this.paymentGetCommandHandler = paymentGetCommandHandler;
    }

    @Override
    public CreatePaymentResponse createPayment(@Valid CreatePaymentCommand createPaymentCommand) {
        return paymentCreateCommandHandler.createPayment(createPaymentCommand);
    }

    @Override
    public GetPaymentByRefIdResponse getPaymentByRefId(@Valid GetPaymentByRefIdQuery getPaymentByRefIdQuery) {
        return paymentGetCommandHandler.getPaymentByRefId(getPaymentByRefIdQuery);
    }
}
