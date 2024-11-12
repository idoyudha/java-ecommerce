package multiwarehouse.ecommerce.rest;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.dto.create.CreateOrderCommand;
import multiwarehouse.ecommerce.dto.create.CreateOrderResponse;
import multiwarehouse.ecommerce.ports.input.service.OrderApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/orders", produces = "application/vnd.api.v1+json")
public class OrderController {
    private final OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        log.info("Creating order: {}", createOrderCommand);
        CreateOrderResponse createOrderResponse = orderApplicationService.createOrder(createOrderCommand);
        log.info("Order created: {}", createOrderResponse);
        return ResponseEntity.ok(createOrderResponse);
    }
}
