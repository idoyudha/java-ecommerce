package multiwarehouse.ecommerce.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.Money;
import multiwarehouse.ecommerce.valueobject.PaymentMethod;
import multiwarehouse.ecommerce.valueobject.ReferenceId;

@Getter
@AllArgsConstructor
@Builder
public class CreatePaymentCommand {
    @NotNull
    private final ReferenceId referenceId;
    @NotNull
    private final PaymentMethod paymentMethod;
    @NotNull
    private final Money amount;
}
