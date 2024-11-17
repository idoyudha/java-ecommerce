package multiwarehouse.ecommerce.dto.get;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class GetPaymentByRefIdResponse {
    @NotNull
    private final UUID paymentId;
    @NotNull
    private final UUID referenceId;
    @NotNull
    private final PaymentMethod paymentMethod;
    @NotNull
    private final PaymentStatus paymentStatus;
    private final String failedMessage;
    @NotNull
    private final BigDecimal amount;
    @NotNull
    private final Instant createdAt;
}
