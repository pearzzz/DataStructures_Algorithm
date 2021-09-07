package com.pearz.data_structure.recurtion;

public class Queen8 {

    int num = 8;
    int[] array = new int[num];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("count = " + count);
        System.out.println("judgeCount = " + judgeCount);
    }

    public void check(int n) {
        if (n == num) {
            print();
            return;
        }
        for (int i = 1; i <= num; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public boolean judge(int n) {

        ++judgeCount;
        for (int i = 0; i < n; ++i) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        ++count;
        for (int i = 0; i < array.length; ++i) {
            System.out.printf("%d\t", array[i]);
        }
        System.out.println();
    }
}
