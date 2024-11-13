package multiwarehouse.ecommerce.ports.input.message.listener.product;

import multiwarehouse.ecommerce.dto.message.ProductUpdateRequest;

public interface ProductUpdateMessageListener {
    void updateProduct(ProductUpdateRequest productUpdateRequest);
}
