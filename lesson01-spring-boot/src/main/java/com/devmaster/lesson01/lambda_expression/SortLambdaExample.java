package com.devmaster.lesson01.lambda_expression;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortLambdaExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "Java SpringBoot", "C# NetCore", "PHP", "JavaScript"
        );

        // C1: dùng Collections.sort + lambda
        Collections.sort(list, (String s1, String s2) -> s1.compareTo(s2));
        System.out.println("Tăng dần (A→Z):");
        for (String s : list) System.out.println(s);

        // C2: viết gọn hơn
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));

        // C3: ngắn nhất với method reference
        Collections.sort(list, String::compareTo);

        // Giảm dần
        Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
        System.out.println("\nGiảm dần (Z→A):");
        list.forEach(System.out::println);
    }
}
