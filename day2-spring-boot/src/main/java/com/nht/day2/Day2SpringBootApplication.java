package com.nht.day2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import com.nht.day2.tight_loosely_coupling.TightCoupling;
import com.nht.day2.tight_loosely_coupling.SortAlgorithm;
import com.nht.day2.tight_loosely_coupling.BubbleSortAlgorithm;


import java.util.Arrays;

@SpringBootApplication
public class Day2SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(Day2SpringBootApplication.class, args);
    }



    @Bean @Order(1)
    CommandLineRunner demoLooseCoupling() {
        return args -> {
            System.out.println("\n=== Demo 1: Loose Coupling (Strategy) ===");
            SortAlgorithm algorithm = new BubbleSortAlgorithm();
            int[] data = {11, 21, 13, 42, 15};
            algorithm.sort(data);
            System.out.println("Kết quả (tăng dần):");
            Arrays.stream(data).forEach(System.out::println);
        };
    }
}
