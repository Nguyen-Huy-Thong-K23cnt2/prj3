package NhtK23cnt2.prj3.entity.product;

import NhtK23cnt2.prj3.entity.user.NhtUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "nht_product_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NhtProductComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private int star; // 1–5

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private NhtProduct product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private NhtUser user;
}
