package com.nht.day2.tight_loosely_coupling;

public class BubbleSortAlgorithm implements SortAlgorithm {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        System.out.println("Sắp xếp theo giải thuật BubbleSort");
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
