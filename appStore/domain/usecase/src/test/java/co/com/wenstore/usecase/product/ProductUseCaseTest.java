package co.com.wenstore.usecase.product;

import co.com.wenstore.model.messagenotification.gateways.MessageNotificationRepository;
import co.com.wenstore.model.product.Product;
import co.com.wenstore.model.product.gateways.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ProductUseCaseTest {

    @InjectMocks
    ProductUseCase productUseCase;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    void setUp(){

        when(productRepository.findAll()).thenReturn(Flux.just(
                Product.builder().id(1).name("Florero otono").description("").price(250000).type(1).build(),
                Product.builder().id(2).name("Florero primavera").description("").price(210000).type(1).build(),
                Product.builder().id(3).name("Lampara entrada verano").description("").price(54000).type(2).build()));
    }

    @Test
    void getProductOfferBasicSuccess(){
        StepVerifier.create(productUseCase.getProductsByOffer(1))
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void getProductOfferPlusFail(){
        StepVerifier.create(productUseCase.getProductsByOffer(5))
                .expectError();
    }
}
