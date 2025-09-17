package co.com.wenstore.model.offer;

import co.com.wenstore.model.util.Constant;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class OfferBasic extends Offer {
    @Override
    public double calculateDiscountPrice(double price) {

        return price - (price * Constant.DISCOUNT_PRICE_BASIC);
    }
}
