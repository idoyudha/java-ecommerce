package multiwarehouse.ecommerce.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PaymentUpdateRequest {
    private final String paymentId;
    private final String sagaId;
    private final String referenceId;
    private final String userId;
    private final String paymentStatus;
    private final String failedMessage;
}
