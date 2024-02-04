package pe.estebancoder.solutions.eshop.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UsersMysqlMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersMysqlMsApplication.class, args);
    }

}
