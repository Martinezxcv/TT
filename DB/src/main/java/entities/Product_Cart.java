package entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Product_Cart {
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "Product_id")
    Product productId;

    @EmbeddedId
    @OneToOne
    @JoinColumn(name = "Cart_id")
    Cart cartId;
}
