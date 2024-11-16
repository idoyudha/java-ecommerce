package multiwarehouse.ecommerce.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
@Jacksonized
public class CreateOrderCommand {
    @NotNull
    private final UUID userId;
    @NotNull
    private final OrderAddress address;
    @NotNull
    private final BigDecimal totalPrice;
    @NotNull
    private final List<OrderItem> orderItems;
}
