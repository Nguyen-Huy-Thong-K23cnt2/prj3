package com.nht.k23cnt2.lesson6.repository;


import com.nht.k23cnt2.lesson6.entity.NhtStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhtStudentRepository extends JpaRepository<NhtStudent, Long> {


}
