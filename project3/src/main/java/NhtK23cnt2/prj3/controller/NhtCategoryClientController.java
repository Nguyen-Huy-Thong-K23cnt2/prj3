package NhtK23cnt2.prj3.controller;

import NhtK23cnt2.prj3.entity.NhtCategory;
import NhtK23cnt2.prj3.service.NhtCategoryService;
import NhtK23cnt2.prj3.service.NhtProductService;
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

        model.addAttribute("categories", categoryService.getAll());

        model.addAttribute("products", productService.getByCategory(id));

        model.addAttribute("activeCategoryId", id);

        NhtCategory cat = categoryService.getById(id);
        model.addAttribute("currentCategory", cat);

        return "NhtCategory";
    }
}
