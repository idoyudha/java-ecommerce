package multiwarehouse.ecommerce.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.OrderStatus;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class PaymentUpdateResponse {
    private final String id;
    private final String sagaId;
    private final String orderId;
    private final String userId;
    private final String paymentId;
    private final String paymentStatus;
    private final BigDecimal totalPrice;
    private final OrderStatus orderStatus;
}
