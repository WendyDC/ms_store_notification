package co.com.wenstore.model.product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int type;

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}
