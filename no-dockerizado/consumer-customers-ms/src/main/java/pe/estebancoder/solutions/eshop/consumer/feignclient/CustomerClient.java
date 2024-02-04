package pe.estebancoder.solutions.eshop.consumer.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pe.estebancoder.solutions.eshop.consumer.model.Customer;

import java.util.List;

@FeignClient(name = "mclientes")
public interface CustomerClient {

    @GetMapping("/customers")
    public List<Customer> listar();
}
