package co.com.wenstore.r2dbc.product;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<ProductData
        , Integer>, ReactiveQueryByExampleExecutor<ProductData> {

}
