package co.com.wenstore.r2dbc.product;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Table(name = "product")
public class ProductData {

    @Id
    @Column("id")
    Integer id;
    @Column("name")
    String name;
    @Column("description")
    String description;
    @Column("price")
    double price;
    @Column("type")
    int type;
}
