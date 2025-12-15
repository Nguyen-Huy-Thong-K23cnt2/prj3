package NhtK23cnt2.prj3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NhtPromotionController {

    @GetMapping("/promotion")
    public String promotion() {
        return "NhtPromotion";
    }
}
