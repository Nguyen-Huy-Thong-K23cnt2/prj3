package com.nht.k23cnt2.lesson07.controller;

import com.nht.k23cnt2.lesson07.entity.NhtCategory;
import com.nht.k23cnt2.lesson07.service.NhtCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NhtCategoryController {

    @Autowired
    private NhtCategoryService categoryService;

    @GetMapping("/category")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/category-list";
    }

    @GetMapping("/category/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new NhtCategory());
        return "category/category-form";
    }

    @GetMapping("/category/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category",
                categoryService.getCategoryById(id).orElse(null));
        return "category/category-form";
    }

    @PostMapping("/category/create")
    public String saveCategory(@ModelAttribute("category") NhtCategory category) {
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    @PostMapping("/category/create/{id}")
    public String updateCategory(@PathVariable Long id,
                                 @ModelAttribute("category") NhtCategory category) {
        category.setId(id);
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }
}
