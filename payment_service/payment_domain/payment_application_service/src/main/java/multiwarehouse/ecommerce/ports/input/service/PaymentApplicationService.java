package multiwarehouse.ecommerce.ports.input.service;

import jakarta.validation.Valid;
import multiwarehouse.ecommerce.dto.create.CreatePaymentCommand;
import multiwarehouse.ecommerce.dto.create.CreatePaymentResponse;
import multiwarehouse.ecommerce.dto.get.GetPaymentByRefIdQuery;
import multiwarehouse.ecommerce.dto.get.GetPaymentByRefIdResponse;

public interface PaymentApplicationService {
    public CreatePaymentResponse createPayment(@Valid CreatePaymentCommand createPaymentCommand);
    public GetPaymentByRefIdResponse getPaymentByRefId(@Valid GetPaymentByRefIdQuery getPaymentByRefIdQuery);
}
