package pe.estebancoder.solutions.eshop.customers.service;

import pe.estebancoder.solutions.eshop.customers.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long customerId);

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long customerId, Customer updatedCustomer);

    void deleteCustomer(Long customerId);
}