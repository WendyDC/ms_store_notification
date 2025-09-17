package co.com.wenstore.model.product.gateways;

import co.com.wenstore.model.product.Product;
import reactor.core.publisher.Flux;

public interface ProductRepository {
    Flux<Product> findAll();
}
