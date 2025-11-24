package com.nht.k23cnt2.lesson07.controller;

import com.nht.k23cnt2.lesson07.entity.NhtProduct;
import com.nht.k23cnt2.lesson07.service.NhtProductService;
import com.nht.k23cnt2.lesson07.service.NhtCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NhtProductController {

    @Autowired
    private NhtProductService productService;

    @Autowired
    private NhtCategoryService categoryService;

    // GET /products
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/product-list";
    }

    // GET /products/create
    @GetMapping("/products/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new NhtProduct());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/product-form";
    }

    // GET /products/edit/{id}
    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        NhtProduct product = productService.findById(id).orElse(null);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/product-form";
    }

    // POST /products/create (create)
    @PostMapping("/products/create")
    public String saveProduct(@ModelAttribute("product") NhtProduct product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // POST /products/create/{id} (update)
    @PostMapping("/products/create/{id}")
    public String updateProduct(@PathVariable Long id,
                                @ModelAttribute("product") NhtProduct product) {
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // GET /products/delete/{id}
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
