package multiwarehouse.ecommerce.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.ProductId;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class OrderItem {
    @NotNull
    private final ProductId productId;
    @NotNull
    private final int quantity;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final BigDecimal subtotal;
}