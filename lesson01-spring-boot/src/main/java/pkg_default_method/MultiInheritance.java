package pkg_default_method;

public class MultiInheritance implements Interface1, Interface2 {

    // 1) method1 chỉ tồn tại ở Interface1 → có thể dùng mặc định
    //    nhưng ví dụ minh họa override để "chọn rõ" phiên bản của Interface1
    @Override
    public void method1() {
        Interface1.super.method1(); // gọi đúng default method trong Interface1
        // có thể thêm logic khác ở đây
    }

    // 2) method2 có sẵn ở Interface2, ví dụ override để thay đổi hành vi
    @Override
    public void method2() {
        System.out.println("MultiInheritance.method2()");
        // nếu muốn gọi lại mặc định:
        // Interface2.super.method2();
    }
}
