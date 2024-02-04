package pe.estebancoder.solutions.eshop.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomersMongoMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersMongoMsApplication.class, args);
    }

}
