package co.com.wenstore.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class RQProductsByOffer {

    @JsonProperty("typeOffer")
    int typeOffer;
}
