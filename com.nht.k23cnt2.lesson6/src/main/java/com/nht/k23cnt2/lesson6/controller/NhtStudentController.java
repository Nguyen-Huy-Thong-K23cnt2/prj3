package com.nht.k23cnt2.lesson6.controller;

import com.nht.k23cnt2.lesson6.dto.NhtStudentDTO;
import com.nht.k23cnt2.lesson6.service.NhtStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/students")
public class NhtStudentController {

    private final NhtStudentService studentService;

    @Autowired
    public NhtStudentController(NhtStudentService studentService) {
        this.studentService = studentService;
    }

    // Hiển thị danh sách sinh viên
    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/student-list";
    }

    // Form thêm sinh viên mới
    @GetMapping("/add-new")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new NhtStudentDTO());
        return "students/student-add";
    }

    // Form chỉnh sửa sinh viên
    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        NhtStudentDTO student = studentService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id: " + id));
        model.addAttribute("student", student);
        return "students/student-edit";
    }

    // Lưu sinh viên mới
    @PostMapping
    public String saveStudent(@ModelAttribute("student") NhtStudentDTO student) {
        studentService.save(student);
        return "redirect:/students";
    }

    // Cập nhật sinh viên
    @PostMapping("/update/{id}")
    public String updateStudent(
            @PathVariable("id") Long id,
            @ModelAttribute("student") NhtStudentDTO student) {
        studentService.updateStudentById(id, student);
        return "redirect:/students";
    }

    // Xóa sinh viên
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}