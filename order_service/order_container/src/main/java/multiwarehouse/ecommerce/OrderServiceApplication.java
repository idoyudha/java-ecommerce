package multiwarehouse.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"java.ecommerce.service.dataaccess", "java.ecommerce.dataaccess"})
@EntityScan(basePackages = {"java.ecommerce.service.dataaccess", "java.ecommerce.dataaccess"})
@SpringBootApplication(scanBasePackages = {"java.ecommerce"})
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
