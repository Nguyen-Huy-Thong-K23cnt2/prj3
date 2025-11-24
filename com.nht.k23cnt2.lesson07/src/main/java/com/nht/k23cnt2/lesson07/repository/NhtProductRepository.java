package com.nht.k23cnt2.lesson07.repository;

import com.nht.k23cnt2.lesson07.entity.NhtProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhtProductRepository extends JpaRepository<NhtProduct, Long> {
}
