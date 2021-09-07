package com.pearz.data_structure.search;

import java.util.ArrayList;
import java.util.List;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 98, 106, 50, 23, -9, 3, 3, 6, 100};
        System.out.println(seqSearch(arr, 0));
    }

    public static List<Integer> seqSearch(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == target) {
                list.add(i);
            }
        }
        return list;
    }
}
