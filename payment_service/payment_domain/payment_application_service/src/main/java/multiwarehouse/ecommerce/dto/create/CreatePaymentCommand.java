package multiwarehouse.ecommerce.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.PaymentMethod;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreatePaymentCommand {
    @NotNull
    private final UUID referenceId;
    @NotNull
    private final PaymentMethod paymentMethod;
    @NotNull
    private final BigDecimal amount;
}
