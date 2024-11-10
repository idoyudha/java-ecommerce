package multiwarehouse.ecommerce.dto.get;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.*;

@Getter
@AllArgsConstructor
@Builder
public class GetPaymentByRefIdResponse {
    @NotNull
    private final PaymentId paymentId;
    @NotNull
    private final ReferenceId referenceId;
    @NotNull
    private final PaymentMethod paymentMethod;
    @NotNull
    private final PaymentStatus paymentStatus;
    private final String failedMessage;
    @NotNull
    private final Money amount;
    @NotNull
    private final CreatedAt createdAt;
}
