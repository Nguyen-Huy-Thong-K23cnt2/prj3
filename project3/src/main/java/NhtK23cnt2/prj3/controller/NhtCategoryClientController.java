package NhtK23cnt2.prj3.controller;

import NhtK23cnt2.prj3.entity.product.NhtCategory;
import NhtK23cnt2.prj3.service.product.NhtProductService;
import NhtK23cnt2.prj3.service.product.NhtCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class NhtCategoryClientController {

    private final NhtCategoryService categoryService;
    private final NhtProductService productService;

    @GetMapping("/category/{id}")
    public String categoryPage(@PathVariable Long id, Model model) {

        NhtCategory cat = categoryService.getById(id);
        if (cat == null) {
            return "redirect:/?error=category_not_found";
        }

        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("products", productService.getByCategory(id));
        model.addAttribute("activeCategoryId", id);
        model.addAttribute("currentCategory", cat);

        return "NhtCategory";
    }
}
