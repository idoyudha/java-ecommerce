package multiwarehouse.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages={"multiwarehouse.ecommerce"})
@EntityScan(basePackages={"multiwarehouse.ecommerce"})
@SpringBootApplication(scanBasePackages = {"multiwarehouse.ecommerce"})
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
