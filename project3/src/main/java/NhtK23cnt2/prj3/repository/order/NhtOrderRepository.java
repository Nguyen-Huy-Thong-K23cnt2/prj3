package NhtK23cnt2.prj3.repository.order;

import NhtK23cnt2.prj3.entity.order.NhtOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhtOrderRepository extends JpaRepository<NhtOrder, Long> {

    // tra cứu đơn theo SĐT khách
    List<NhtOrder> findByCustomerPhoneOrderByCreatedAtDesc(String phone);
}
