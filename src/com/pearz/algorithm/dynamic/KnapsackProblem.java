package com.pearz.algorithm.dynamic;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {1, 4, 3};
        int[] value = {1500, 3000, 2000};
        int max = 4;//背包容量
        int n = weight.length;//物品数量

        int[][] valueMax = new int[n + 1][max + 1];
        int[][] path = new int[n + 1][max + 1];

        for (int i = 0; i < valueMax.length; ++i) {
            valueMax[i][0] = 0;
        }
        for (int i = 0; i < valueMax[0].length; ++i) {
            valueMax[0][i] = 0;
        }

        for (int i = 1; i < valueMax.length; ++i) {
            for (int j = 1; j < valueMax[0].length; ++j) {
                if (weight[i - 1] > j) {
                    valueMax[i][j] = valueMax[i - 1][j];
                } else {
                    if (value[i - 1] + valueMax[i - 1][j - weight[i - 1]] > valueMax[i - 1][j]) {
                        valueMax[i][j] = value[i - 1] + valueMax[i - 1][j - weight[i - 1]];
                        path[i][j] = 1;
                    } else {
                        valueMax[i][j] = valueMax[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < valueMax.length; ++i) {
            for (int j = 0; j < valueMax[0].length; ++j) {
                System.out.print(valueMax[i][j] + " ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("取出第" + i + "个物品");
                j -= weight[i - 1];
            }
            --i;
        }
    }
}
