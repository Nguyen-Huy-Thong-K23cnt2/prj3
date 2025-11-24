package com.nht.k23cnt2.lesson07.service;

import com.nht.k23cnt2.lesson07.entity.NhtProduct;
import com.nht.k23cnt2.lesson07.repository.NhtProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhtProductService {

    @Autowired
    private NhtProductRepository productRepository;

    public List<NhtProduct> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<NhtProduct> findById(Long id) {
        return productRepository.findById(id);
    }

    public NhtProduct saveProduct(NhtProduct product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
