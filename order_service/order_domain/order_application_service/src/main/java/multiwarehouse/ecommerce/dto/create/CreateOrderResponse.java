package multiwarehouse.ecommerce.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    @NotNull
    private final OrderStatus orderStatus;
    @NotNull
    private final BigDecimal totalPrice;
    @NotNull
    private final Instant createdAt;
}
