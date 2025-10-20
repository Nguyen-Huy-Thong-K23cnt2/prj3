package com.devmaster.lesson01_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import pkg_default_method.MultiInheritance;

@SpringBootApplication
public class Lesson01SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson01SpringBootApplication.class, args);
        System.out.println("Hello world");
    }

    // Runner 1: demo Lambda sort (chạy TRƯỚC)
    @Bean("lambdaSortDemo")
    @Order(1)
    CommandLineRunner lambdaSortDemo() {
        return args -> {
            var list = new java.util.ArrayList<>(java.util.List.of(
                    "Java SpringBoot", "C# NetCore", "PHP", "JavaScript"
            ));
            list.sort(String::compareToIgnoreCase);
            System.out.println("[Lambda] Tăng dần (ignore case): " + list);
        };
    }

    // Runner 2: demo default method & đa thừa kế (chạy SAU)
    @Bean("demoDefaultMethodApp")
    @Order(2)
    CommandLineRunner demoDefaultMethodApp() {
        return args -> {
            MultiInheritance mi = new MultiInheritance();
            mi.method1();
            mi.method2();
        };
    }
}
