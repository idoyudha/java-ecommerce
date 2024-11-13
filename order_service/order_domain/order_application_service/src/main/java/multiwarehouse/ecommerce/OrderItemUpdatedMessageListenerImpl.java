package multiwarehouse.ecommerce;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.dto.message.ProductUpdateRequest;
import multiwarehouse.ecommerce.ports.input.message.listener.product.ProductUpdateMessageListener;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
@Slf4j
public class OrderItemUpdatedMessageListenerImpl implements ProductUpdateMessageListener {
    @Override
    public void updateProduct(ProductUpdateRequest productUpdateRequest) {
        log.info("Product updating start process for id: {}", productUpdateRequest.getProductId().getValue());
    }
}
