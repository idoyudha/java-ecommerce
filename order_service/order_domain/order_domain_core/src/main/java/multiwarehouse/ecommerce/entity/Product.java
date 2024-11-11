package multiwarehouse.ecommerce.entity;

import multiwarehouse.ecommerce.valueobject.Money;
import multiwarehouse.ecommerce.valueobject.ProductId;
import multiwarehouse.ecommerce.valueobject.WarehouseId;

public class Product extends BaseEntity<ProductId> {
    private String name;
    private WarehouseId warehouseId;
    private Money price;

    public Product(ProductId id, String name, WarehouseId warehouseId, Money price) {
        super.setId(id);
        this.name = name;
        this.warehouseId = warehouseId;
        this.price = price;
    }

    public Product(ProductId productId) {
        super.setId(productId);
    }

    public String getName() {
        return name;
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public Money getPrice() {
        return price;
    }
}
