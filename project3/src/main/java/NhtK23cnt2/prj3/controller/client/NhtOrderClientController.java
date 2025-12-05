package NhtK23cnt2.prj3.controller.client;

import NhtK23cnt2.prj3.entity.order.NhtOrder;
import NhtK23cnt2.prj3.repository.order.NhtOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NhtOrderClientController {

    private final NhtOrderRepository orderRepository;

    @GetMapping("/order/{id}")
    public String orderDetail(@PathVariable Long id, Model model) {
        NhtOrder order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return "redirect:/";
        }
        model.addAttribute("order", order);
        return "NhtOrderDetail";
    }

    @GetMapping("/order/track")
    public String trackForm() {
        return "NhtOrderTrack";
    }

    @GetMapping("/order/search")
    public String searchByPhone(@RequestParam("phone") String phone, Model model) {
        List<NhtOrder> orders = orderRepository.findByCustomerPhoneOrderByCreatedAtDesc(phone);
        model.addAttribute("orders", orders);
        model.addAttribute("phone", phone);
        return "NhtOrderTrack";
    }
}
