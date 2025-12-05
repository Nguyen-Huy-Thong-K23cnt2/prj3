package NhtK23cnt2.prj3.service.cart;

import NhtK23cnt2.prj3.entity.NhtProduct;
import NhtK23cnt2.prj3.model.cart.NhtCartItem;
import NhtK23cnt2.prj3.service.NhtProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NhtCartService {

    private final NhtProductService productService;

    private static final String CART_SESSION_KEY = "cart";

    @SuppressWarnings("unchecked")
    private Map<Long, NhtCartItem> getCart(HttpSession session) {
        Object obj = session.getAttribute(CART_SESSION_KEY);
        if (obj == null) {
            Map<Long, NhtCartItem> cart = new LinkedHashMap<>();
            session.setAttribute(CART_SESSION_KEY, cart);
            return cart;
        }
        return (Map<Long, NhtCartItem>) obj;
    }

    public void addToCart(Long productId, HttpSession session) {
        Map<Long, NhtCartItem> cart = getCart(session);
        NhtCartItem item = cart.get(productId);

        if (item == null) {
            NhtProduct p = productService.getById(productId);
            if (p == null) return;

            item = NhtCartItem.builder()
                    .productId(p.getId())
                    .productName(p.getProductName())
                    .productImage(p.getProductImage())
                    .price(p.getProductPrice())
                    .quantity(1)
                    .build();
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }

        cart.put(productId, item);
    }

    public void updateQuantity(Long productId, int quantity, HttpSession session) {
        Map<Long, NhtCartItem> cart = getCart(session);
        NhtCartItem item = cart.get(productId);
        if (item != null) {
            if (quantity <= 0) {
                cart.remove(productId);
            } else {
                item.setQuantity(quantity);
            }
        }
    }

    public void removeItem(Long productId, HttpSession session) {
        Map<Long, NhtCartItem> cart = getCart(session);
        cart.remove(productId);
    }

    public List<NhtCartItem> getItems(HttpSession session) {
        return new ArrayList<>(getCart(session).values());
    }

    public double getTotal(HttpSession session) {
        return getCart(session).values().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }

    public void clear(HttpSession session) {
        session.removeAttribute(CART_SESSION_KEY);
    }
}
