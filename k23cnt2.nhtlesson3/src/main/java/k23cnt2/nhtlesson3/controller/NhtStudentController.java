package k23cnt2.nhtlesson3.controller;

import k23cnt2.nhtlesson3.entity.NhtStudent;
import k23cnt2.nhtlesson3.service.NhtServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NhtStudentController {

    @Autowired
    private NhtServiceStudent studentService;

    @GetMapping("/student-list")
    public List<NhtStudent> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/student/{id}")
    public NhtStudent getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/student-add")
    public NhtStudent addStudent(@RequestBody NhtStudent student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/student/{id}")
    public NhtStudent updateStudent(@PathVariable Long id,
                                    @RequestBody NhtStudent student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/student/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
