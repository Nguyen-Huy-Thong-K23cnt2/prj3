package pkg_default_method;

public interface Shape {
    void draw(); // vẽ hình ra console

    default void setColor(String color) { // màu chỉ để in chữ/ASCII (ANSI)
        System.out.println("Vẽ hình với màu: " + color);
    }
}
