package NhtK23cnt2.prj3.controller.client;

import NhtK23cnt2.prj3.entity.order.NhtOrder;
import NhtK23cnt2.prj3.entity.order.NhtOrderItem;
import NhtK23cnt2.prj3.model.cart.NhtCartItem;
import NhtK23cnt2.prj3.repository.order.NhtOrderRepository;
import NhtK23cnt2.prj3.service.NhtProductService;
import NhtK23cnt2.prj3.service.cart.NhtCartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NhtCheckoutClientController {

    private final NhtCartService cartService;
    private final NhtOrderRepository orderRepository;
    private final NhtProductService productService;

    @GetMapping("/checkout")
    public String checkoutPage(Model model, HttpSession session) {
        List<NhtCartItem> items = cartService.getItems(session);
        if (items.isEmpty()) {
            return "redirect:/cart";
        }
        model.addAttribute("items", items);
        model.addAttribute("total", cartService.getTotal(session));
        return "NhtCheckout";
    }

    @PostMapping("/checkout")
    public String submitOrder(
            @RequestParam String customerName,
            @RequestParam String customerPhone,
            @RequestParam String customerAddress,
            @RequestParam(required = false) String note,
            HttpSession session) {

        List<NhtCartItem> items = cartService.getItems(session);
        if (items.isEmpty()) {
            return "redirect:/cart";
        }

        double total = cartService.getTotal(session);

        NhtOrder order = new NhtOrder();
        order.setCustomerName(customerName);
        order.setCustomerPhone(customerPhone);
        order.setCustomerAddress(customerAddress);
        order.setNote(note);
        order.setTotalAmount(total);
        order.setStatus("WAITING");
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        List<NhtOrderItem> orderItems = items.stream()
                .map(ci -> {
                    NhtOrderItem oi = new NhtOrderItem();
                    oi.setOrder(order);
                    oi.setProduct(productService.getById(ci.getProductId()));
                    oi.setProductName(ci.getProductName());
                    oi.setProductPrice(ci.getPrice());
                    oi.setQuantity(ci.getQuantity());
                    return oi;
                }).toList();

        order.setItems(orderItems);

        NhtOrder saved = orderRepository.save(order);

        cartService.clear(session);

        return "redirect:/order/" + saved.getId();
    }
}
