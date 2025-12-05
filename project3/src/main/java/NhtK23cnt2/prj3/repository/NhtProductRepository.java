package NhtK23cnt2.prj3.repository;

import NhtK23cnt2.prj3.entity.NhtProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhtProductRepository extends JpaRepository<NhtProduct, Long> {

    List<NhtProduct> findByCategoryId(Long categoryId);
}
