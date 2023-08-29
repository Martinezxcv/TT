package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductOrderId implements Serializable {
    @Column(name = "Product_id")
    int productId;
    @Column(name = "Order_id")
    int orderId;

}
