package NhtK23cnt2.prj3.controller;

import NhtK23cnt2.prj3.service.NhtCategoryService;
import NhtK23cnt2.prj3.service.NhtProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class NhtHomeController {

    private final NhtCategoryService categoryService;
    private final NhtProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("products", productService.getAll()); // sản phẩm nổi bật / mới nhất
        return "NhtHome"; // resources/templates/NhtHome.html
    }
}
