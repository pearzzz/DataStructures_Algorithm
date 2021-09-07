package com.pearz.data_structure.recurtion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[9][10];
        for (int i = 0; i < map[0].length; ++i) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        for (int j = 0; j < map.length; ++j) {
            map[j][0] = 1;
            map[j][map[0].length - 1] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
//        map[3][3] = 1;
//        map[2][3] = 1;
//        map[1][3] = 1;

        System.out.println("原地图为：");
        for (int[] row : map) {
            for (int num : row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }

        setWay(map, 1, 1, 7, 8);

        System.out.println("路线为：");
        for (int[] row : map) {
            for (int num : row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
    }

    //map[i][j]的值为0表示未走过，1表示是墙，2表示已走过且通，3表示走不通
    public static boolean setWay(int[][] map, int i, int j, int m, int n) {
        if (map[m][n] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i+1, j, m, n)) {
                    return true;
                } else if (setWay(map, i, j+1, m, n)) {
                    return true;
                } else if (setWay(map, i-1, j, m, n)) {
                    return true;
                } else if (setWay(map, i, j-1, m, n)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
