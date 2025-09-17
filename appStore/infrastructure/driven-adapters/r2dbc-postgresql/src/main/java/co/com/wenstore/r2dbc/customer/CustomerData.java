package co.com.wenstore.r2dbc.customer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "customer")
public class CustomerData {

    @Id
    @Column("id")
    Integer id;
    @Column("id_type")
    String idType;
    @Column("id_number")
    String idNumber;
    @Column("full_name")
    String fullName;
    @Column("email")
    String email;
    @Column("type")
    int typeOffer;
}
