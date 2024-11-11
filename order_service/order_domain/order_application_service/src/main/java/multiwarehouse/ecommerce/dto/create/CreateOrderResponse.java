package multiwarehouse.ecommerce.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.CreatedAt;
import multiwarehouse.ecommerce.valueobject.Money;
import multiwarehouse.ecommerce.valueobject.OrderId;
import multiwarehouse.ecommerce.valueobject.OrderStatus;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    @NotNull
    private final OrderId orderId;
    @NotNull
    private final OrderStatus orderStatus;
    @NotNull
    private final Money totalPrice;
    @NotNull
    private final CreatedAt createdAt;
}
