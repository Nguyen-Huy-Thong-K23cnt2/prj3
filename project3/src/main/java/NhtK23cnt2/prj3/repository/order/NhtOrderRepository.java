package NhtK23cnt2.prj3.repository.order;

import NhtK23cnt2.prj3.entity.order.NhtOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NhtOrderRepository extends JpaRepository<NhtOrder, Long> {

    Optional<NhtOrder> findByIdAndPhone(Long id, String phone);

    List<NhtOrder> findByPhone(String phone);

    List<NhtOrder> findByUser_IdOrderByCreatedAtDesc(Long userId);

}
