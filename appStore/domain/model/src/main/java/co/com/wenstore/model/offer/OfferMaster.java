package co.com.wenstore.model.offer;
import co.com.wenstore.model.util.Constant;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder(toBuilder = true)
public final class OfferMaster extends Offer {
    @Override
    public double calculateDiscountPrice(double price) {

        return price - (price * Constant.DISCOUNT_PRICE_MASTER);
    }
}
