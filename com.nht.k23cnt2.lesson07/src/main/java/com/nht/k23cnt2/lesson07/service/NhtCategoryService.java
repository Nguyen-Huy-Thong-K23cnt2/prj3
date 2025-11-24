package com.nht.k23cnt2.lesson07.service;

import com.nht.k23cnt2.lesson07.entity.NhtCategory;
import com.nht.k23cnt2.lesson07.repository.NhtCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhtCategoryService {

    @Autowired
    private NhtCategoryRepository categoryRepository;

    public NhtCategoryService(NhtCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Lấy toàn bộ danh sách category
    public List<NhtCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Lấy category theo id
    public Optional<NhtCategory> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Tạo hoặc cập nhật category
    public NhtCategory saveCategory(NhtCategory category) {
        return categoryRepository.save(category);
    }

    // Xóa category theo id
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
