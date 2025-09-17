package co.com.wenstore.model.customer;
import lombok.*;


@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Customer {
    private int id;
    private String idType;
    private String idNumber;
    private String fullName;
    private String email;
    private int typeOffer;
}
