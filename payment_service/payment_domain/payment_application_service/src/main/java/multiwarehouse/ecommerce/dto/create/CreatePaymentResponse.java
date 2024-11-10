package multiwarehouse.ecommerce.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.*;

@Getter
@Builder
@AllArgsConstructor
public class CreatePaymentResponse {
    private final PaymentId paymentId;
    private final ReferenceId referenceId;
    private final PaymentMethod paymentMethod;
    private final PaymentStatus paymentStatus;
    private final FailedMessage failedMessage;
    private final Money amount;
    private final CreatedAt createdAt;
}
