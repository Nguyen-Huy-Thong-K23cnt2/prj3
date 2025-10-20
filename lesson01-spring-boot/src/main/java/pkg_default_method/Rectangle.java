package pkg_default_method;

public class Rectangle implements Shape {
    private final int width;
    private final int height;
    private String color = "reset";

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        String c = Ansi.of(color);
        for (int i = 0; i < height; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < width; j++) {
                row.append(c).append('*').append(Ansi.RESET);
            }
            System.out.println(row);
        }
    }

    @Override
    public void setColor(String color) { // ghi đè để lưu màu
        this.color = color;
        System.out.println("Rectangle dùng màu: " + color);
    }
}
