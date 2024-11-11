package multiwarehouse.ecommerce.ports.input.service;

import multiwarehouse.ecommerce.dto.create.CreateOrderCommand;
import multiwarehouse.ecommerce.dto.create.CreateOrderResponse;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand);
}
