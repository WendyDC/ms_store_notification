package co.com.wenstore.model.offer;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public sealed abstract class Offer
        permits OfferBasic, OfferPlus, OfferMaster {
    public abstract double calculateDiscountPrice(double price);
}
