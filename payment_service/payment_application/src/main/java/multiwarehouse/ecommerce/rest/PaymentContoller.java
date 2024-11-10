package multiwarehouse.ecommerce.rest;

import multiwarehouse.ecommerce.dto.create.CreatePaymentCommand;
import multiwarehouse.ecommerce.dto.create.CreatePaymentResponse;
import multiwarehouse.ecommerce.dto.get.GetPaymentByRefIdQuery;
import multiwarehouse.ecommerce.dto.get.GetPaymentByRefIdResponse;
import multiwarehouse.ecommerce.ports.input.service.PaymentApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentContoller {
    private final PaymentApplicationService paymentApplicationService;

    public PaymentContoller(PaymentApplicationService paymentApplicationService) {
        this.paymentApplicationService = paymentApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreatePaymentResponse> createPayment(@RequestBody CreatePaymentCommand createPaymentCommand) {
        CreatePaymentResponse createPaymentResponse = paymentApplicationService.createPayment(createPaymentCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPaymentResponse);
    }

    @GetMapping("/{referenceId}")
    public ResponseEntity<GetPaymentByRefIdResponse> getPaymentByRefId(@PathVariable GetPaymentByRefIdQuery getPaymentByRefIdQuery) {
        GetPaymentByRefIdResponse getPaymentByRefIdResponse = paymentApplicationService.getPaymentByRefId(getPaymentByRefIdQuery) ;
        return ResponseEntity.status(HttpStatus.OK).body(getPaymentByRefIdResponse);
    }
}
