package multiwarehouse.ecommerce.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.Money;
import multiwarehouse.ecommerce.valueobject.ProductId;
import multiwarehouse.ecommerce.valueobject.WarehouseId;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ProductUpdateRequest {
    private ProductId productId;
    private String name;
    private WarehouseId warehouseId;
    private Money price;
}
