package com.pearz.data_structure.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 52, 23, 3, 9, -1, 0};
        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, temp);

        for (int ele : arr) {
            System.out.printf("%d\t", ele);
        }

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @param arr   原数组
     * @param left  左
     * @param mid   中
     * @param right 右
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int m = left, n = mid + 1, t = left;
        while (m <= mid && n <= right) {
            if (arr[m] < arr[n]) {
                temp[t] = arr[m];
                ++t;
                ++m;
            } else {
                temp[t] = arr[n];
                ++t;
                ++n;
            }
        }
        while (m <= mid) {
            temp[t++] = arr[m++];
        }
        while (n <= right) {
            temp[t++] = arr[n++];
        }
        for (int i = left; i <= right; ++i) {
            arr[i] = temp[i];
        }
    }
}
