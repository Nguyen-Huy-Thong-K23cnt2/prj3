package pkg_default_method;

public final class Ansi {
    public static final String RESET = "\u001B[0m";
    public static final String RED   = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW= "\u001B[33m";
    public static final String BLUE  = "\u001B[34m";
    public static final String CYAN  = "\u001B[36m";

    public static String of(String name) {
        return switch (name.toLowerCase()) {
            case "red", "đỏ" -> RED;
            case "green", "xanh lá" -> GREEN;
            case "yellow", "vàng" -> YELLOW;
            case "blue", "xanh dương" -> BLUE;
            case "cyan" -> CYAN;
            default -> RESET;
        };
    }
}
