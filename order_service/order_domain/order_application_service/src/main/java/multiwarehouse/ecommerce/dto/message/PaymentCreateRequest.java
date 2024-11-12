package multiwarehouse.ecommerce.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class PaymentCreateRequest {
    private final String paymentId;
    private final String sagaId;
    private final String referenceId;
    private final BigDecimal amount;
    private final Instant createdAt;
}
