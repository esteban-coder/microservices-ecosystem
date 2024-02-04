package pe.estebancoder.solutions.eshop.consumer.service.impl;

import org.springframework.stereotype.Service;
import pe.estebancoder.solutions.eshop.consumer.feignclient.CustomerClient;
import pe.estebancoder.solutions.eshop.consumer.model.Customer;
import pe.estebancoder.solutions.eshop.consumer.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerClient customerClient;

    public CustomerServiceImpl(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerClient.listar();
    }
}
