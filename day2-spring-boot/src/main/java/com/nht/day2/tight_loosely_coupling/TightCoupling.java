package com.nht.day2.tight_loosely_coupling;

import java.util.Arrays;

public class TightCoupling {
    // Phụ thuộc chặt vào triển khai cụ thể
    private BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

    public TightCoupling() { }

    public TightCoupling(BubbleSortAlgorithm bubbleSortAlgorithm) {
        this.bubbleSortAlgorithm = bubbleSortAlgorithm;
    }

    /** Phải là public để gọi từ package com.nht.day2 */
    public void complexBusinessSort(int[] arr) {
        bubbleSortAlgorithm.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
