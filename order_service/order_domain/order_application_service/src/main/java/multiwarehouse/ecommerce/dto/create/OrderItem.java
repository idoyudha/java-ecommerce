package multiwarehouse.ecommerce.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import multiwarehouse.ecommerce.valueobject.ProductId;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
@Jacksonized
public class OrderItem {
    @NotNull
    private final UUID productId;
    @NotNull
    private final int quantity;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final BigDecimal subtotal;
}
