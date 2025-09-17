package co.com.wenstore.r2dbc.product;

import co.com.wenstore.model.product.Product;
import co.com.wenstore.r2dbc.product.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryAdapter extends ReactiveAdapterOperations<Product, ProductData, Integer, ProductRepository>
        implements co.com.wenstore.model.product.gateways.ProductRepository {
    public ProductRepositoryAdapter(ProductRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Product.class));
    }
}
