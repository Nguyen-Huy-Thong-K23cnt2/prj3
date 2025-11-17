package com.nht.k23cnt2.lesson6.service;

import com.nht.k23cnt2.lesson6.dto.NhtStudentDTO;
import com.nht.k23cnt2.lesson6.entity.NhtStudent;
import com.nht.k23cnt2.lesson6.repository.NhtStudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class NhtStudentService {

    private final NhtStudentRepository studentRepository;

    @Autowired
    public NhtStudentService(NhtStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<NhtStudent> findAll() {
        return studentRepository.findAll();
    }

    public Optional<NhtStudentDTO> findById(Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    NhtStudentDTO dto = new NhtStudentDTO();
                    dto.setId(student.getId());
                    dto.setName(student.getName());
                    dto.setEmail(student.getEmail());
                    dto.setAge(student.getAge());
                    return dto;
                });
    }

    public Boolean save(NhtStudentDTO studentDTO) {
        NhtStudent student = new NhtStudent();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
        try {
            studentRepository.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public NhtStudent updateStudentById(Long id, NhtStudentDTO updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setAge(updatedStudent.getAge());
                    return studentRepository.save(student);
                })
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid student ID: " + id));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}



