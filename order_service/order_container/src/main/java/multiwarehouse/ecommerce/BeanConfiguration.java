package multiwarehouse.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public OrderDomainService orderDomainService() {
        return new OrderDomainServiceImpl();
    }
}
