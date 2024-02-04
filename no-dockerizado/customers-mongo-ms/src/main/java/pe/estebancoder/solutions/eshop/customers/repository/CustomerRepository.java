package pe.estebancoder.solutions.eshop.customers.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.estebancoder.solutions.eshop.customers.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
}
