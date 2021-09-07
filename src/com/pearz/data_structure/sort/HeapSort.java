package com.pearz.data_structure.sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 52, 23, 3, 9, -1, 0};

        heapSort(arr);

        for (int ele : arr) {
            System.out.printf("%d\t", ele);
        }

//        int[] arr = new int[80000000];
//        for (int i = 0; i < 80000000; ++i) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
//
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//        String s = simpleDateFormat.format(date);
//        System.out.println(s);
//
//        heapSort(arr);
//
//        Date date2 = new Date();
//        String s2 = simpleDateFormat.format(date2);
//        System.out.println(s2);
    }

    public static void heapSort(int[] arr) {

        //初建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; --i) {
            adjustHeap(arr, i, arr.length);
        }

        int temp;
        //依次选出最大数放在（除去以存放最大数的）堆末
        for (int j = arr.length - 1; j > 0; --j) {
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * i + 1) {
            if (2 * i + 2 < length && arr[2 * i + 2] > arr[j]) {
                ++j;
            }
            if (arr[j] > arr[i]) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
