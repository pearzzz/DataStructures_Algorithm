package com.pearz.data_structure.sort;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 52, 23, 3, 9, 155, 0};

        radix(arr);

        for (int ele : arr) {
            System.out.printf("%d\t", ele);
        }
    }

    public static void radix(int[] arr) {
        int max = arr[0], length = arr.length;
        for (int m = 1; m < length; ++m) {
            max = max > arr[m] ? max : arr[m];
        }
        int maxLength = (max + "").length();

        int[][] buckets = new int[10][length];
        int[] loc = new int[10];

        int digitOfElement;
        for (int i = 0, n = 1; i < maxLength; ++i, n *= 10) {
            for (int j = 0; j < length; ++j) {
                digitOfElement = arr[j] / n % 10;
                buckets[digitOfElement][loc[digitOfElement]++] = arr[j];
            }

            int index = 0;
            for (int k = 0; k < buckets.length; ++k) {
                if (loc[k] != 0) {
                    for (int p = 0; p < loc[k]; ++p) {
                        arr[index++] = buckets[k][p];
                    }
                }
                loc[k] = 0;
            }

        }
    }
}
