package NhtK23cnt2.prj3.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhtProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String productName;

    @Column(name = "price")
    Double productPrice;

    @Column(name = "image")
    String productImage;

    @Column(name = "description")
    String productDescription;

    @ManyToOne
    @JoinColumn(name = "category_id")
    NhtCategory category;
}
