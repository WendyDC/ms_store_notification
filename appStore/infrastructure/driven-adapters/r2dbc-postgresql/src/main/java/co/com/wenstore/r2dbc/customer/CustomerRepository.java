package co.com.wenstore.r2dbc.customer;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<CustomerData
        , Integer>, ReactiveQueryByExampleExecutor<CustomerData> {

}
