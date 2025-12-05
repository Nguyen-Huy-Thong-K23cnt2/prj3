package NhtK23cnt2.prj3.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhtCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String categoryName;

    // Tạm thời chưa dùng status trong DB nên có thể bỏ
    // Boolean categoryStatus;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    List<NhtProduct> products;
}
