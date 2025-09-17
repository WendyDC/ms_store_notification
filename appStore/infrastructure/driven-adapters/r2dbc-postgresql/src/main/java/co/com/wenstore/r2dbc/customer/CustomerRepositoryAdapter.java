package co.com.wenstore.r2dbc.customer;

import co.com.wenstore.model.customer.Customer;
import co.com.wenstore.r2dbc.customer.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CustomerRepositoryAdapter extends ReactiveAdapterOperations<Customer, CustomerData, Integer, CustomerRepository>
        implements co.com.wenstore.model.customer.gateways.CustomerRepository {

    public CustomerRepositoryAdapter(CustomerRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Customer.class));
    }

    @Override
    public Mono<Customer> findById(int id) {
        return repository.findById(id)
                .map(customerData -> {
                    return Customer.builder()
                                    .id(customerData.getId())
                                    .idType(customerData.idType)
                                    .idNumber(customerData.idNumber)
                                    .fullName(customerData.fullName)
                                    .email(customerData.getEmail())
                                    .typeOffer(customerData.getTypeOffer())
                                    .build();

                });
    }
}
