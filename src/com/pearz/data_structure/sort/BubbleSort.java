package com.pearz.data_structure.sort;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {9, 1, 52, 23, 3, 9};

        Bubble(arr);

        for (int ele : arr) {
            System.out.printf("%d\t", ele);
        }

//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; ++i) {
//            arr[i] = (int)(Math.random() * 8000000);
//        }

//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//        String s = simpleDateFormat.format(date);
//        System.out.println(s);

//        Bubble(arr);

//        Date date2 = new Date();
//        String s2 = simpleDateFormat.format(date2);
//        System.out.println(s2);
    }

    public static void Bubble(int[] arr) {
        int temp;
        boolean flag = true;
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!flag) {
                break;
            } else {
                flag = false;
                for (int j = 0; j < i; ++j) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        flag = true;
                    }
                }
            }
        }
    }
}
