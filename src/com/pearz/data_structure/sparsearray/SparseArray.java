package com.pearz.sparsearray;

public class SparseArray {
    public static void main(String[] args) {

        //定义二维数组
        int[][] cheryArr1 = new int[11][11];
        cheryArr1[1][2] = 1;
        cheryArr1[2][3] = 2;

        //显示二维数组
        System.out.println("原二维数组为：");
        for (int[] row : cheryArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //遍历原数组得到二维数组中不为0的元素的个数sum
        int sum = 0;
        for (int i = 0; i < cheryArr1.length; i++) {
            for (int j = 0; j < cheryArr1[i].length; j++) {
                if (cheryArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //定义稀疏数组
        int[][] cheryArr2 = new int[sum + 1][3];

        //定义第一行
        cheryArr2[0][0] = cheryArr1.length;
        cheryArr2[0][1] = cheryArr1[0].length;
        cheryArr2[0][2] = sum;

        int count = 0;
        //遍历原数组定义其余行
        for (int i = 0; i < cheryArr1.length; i++) {
            for (int j = 0; j < cheryArr1[i].length; j++) {
                if (cheryArr1[i][j] != 0) {
                    count++;
                    cheryArr2[count][0] = i;
                    cheryArr2[count][1] = j;
                    cheryArr2[count][2] = cheryArr1[i][j];
                }
            }
        }

        //显示稀疏数组
        System.out.println("稀疏数组为：");
        for (int[] row : cheryArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将稀疏数组转换成二维数组
        //根据稀疏数组第一行创建二维数组
        int[][] cheryArr3 = new int[cheryArr2[0][0]][cheryArr2[0][1]];
        //填充非0元素
        for (int i = 1; i < cheryArr2.length; i++) {
            cheryArr3[cheryArr2[i][0]][cheryArr2[i][1]] = cheryArr2[i][2];
        }

        //显示二维数组
        System.out.println("二维数组为：");
        for (int[] row : cheryArr3) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
