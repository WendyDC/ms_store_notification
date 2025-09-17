package co.com.wenstore.model.customer.gateways;

import co.com.wenstore.model.customer.Customer;
import reactor.core.publisher.Mono;

public interface CustomerRepository {
    Mono<Customer> findById(int id);
}
