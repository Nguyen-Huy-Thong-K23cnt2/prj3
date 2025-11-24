package com.nht.k23cnt2.lesson07.repository;

import com.nht.k23cnt2.lesson07.entity.NhtCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface NhtCategoryRepository extends JpaRepository<NhtCategory, Long>{

}
