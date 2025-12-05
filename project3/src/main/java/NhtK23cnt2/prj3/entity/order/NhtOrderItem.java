package NhtK23cnt2.prj3.entity.order;

import NhtK23cnt2.prj3.entity.NhtProduct;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "order_items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhtOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    NhtOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    NhtProduct product;

    String productName;
    Double productPrice;
    Integer quantity;
}
