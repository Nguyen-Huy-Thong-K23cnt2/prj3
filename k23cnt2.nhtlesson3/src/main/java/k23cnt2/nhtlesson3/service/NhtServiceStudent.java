package k23cnt2.nhtlesson3.service;

import k23cnt2.nhtlesson3.entity.NhtStudent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NhtServiceStudent {

    List<NhtStudent> students = new ArrayList<>();

    public NhtServiceStudent() {
        students.addAll(Arrays.asList(
                new NhtStudent(1L, "NHT Student 1", 20, "Nam",
                        "Địa chỉ 1", "0123456789", "s1@gmail.com"),
                new NhtStudent(2L, "NHT Student 2", 22, "Nữ",
                        "Địa chỉ 2", "0987654321", "s2@gmail.com"),
                new NhtStudent(3L, "NHT Student 3", 21, "Nam",
                        "Địa chỉ 3", "0909090909", "s3@gmail.com")
        ));
    }
    // Lấy toàn bộ danh sách sinh viên
    public List<NhtStudent> getAll() {
        return students;
    }
    // Lấy sinh viên theo id
    public NhtStudent getStudent(long id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst().orElse(null);
    }
    // Thêm mới một sinh viên
    public NhtStudent addStudent(NhtStudent student) {
        students.add(student);
        return student;
    }
    // Cập nhật thông tin sinh viên
    public NhtStudent updateStudent(long id, NhtStudent student) {
        NhtStudent check = getStudent(id);
        if (check == null) {
            return null;
        }
        students.forEach(item -> {
            if (item.getId()==id) {
                item.setName(student.getName());
                item.setAddress(student.getAddress());
                item.setEmail(student.getEmail());
                item.setPhone(student.getPhone());
                item.setAge(student.getAge());
                item.setGender(student.getGender());
            }
        });
        return student;
    }
    // Xóa thông tin sinh viên
    public boolean deleteStudent(Long id){
        NhtStudent check = getStudent(id);
        return students.remove(check);
    }
}
