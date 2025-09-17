package co.com.wenstore.usecase.product;

import co.com.wenstore.model.offer.Offer;
import co.com.wenstore.model.offer.OfferBasic;
import co.com.wenstore.model.offer.OfferMaster;
import co.com.wenstore.model.offer.OfferPlus;
import co.com.wenstore.model.product.Product;
import co.com.wenstore.model.product.gateways.ProductRepository;
import co.com.wenstore.model.util.Constant;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductRepository productRepository;

    public Flux<Product> getProductsByOffer(int offerId){
        return productRepository.findAll()
                .map(product -> {
                    Offer offer = getOfferById(offerId);
                    product.setPrice(offer.calculateDiscountPrice(product.getPrice()));
                    return product;
                });
    }

    private Offer getOfferById(int offerId) {
        return switch (offerId) {
            case Constant.TYPE_OFFER_PLUS -> new OfferPlus();
            case Constant.TYPE_OFFER_MASTER -> new OfferMaster();
            default -> new OfferBasic();
        };
    }
}
