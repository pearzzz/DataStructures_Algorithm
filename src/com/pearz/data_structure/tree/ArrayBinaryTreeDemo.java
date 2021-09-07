package com.pearz.data_structure.tree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder(0);
    }
}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int n) {
        if (arr == null || arr.length == 0) {
            System.out.println("树空");
            return;
        }
        System.out.println(arr[n]);
        if (2 * n + 1 < arr.length) {
            preOrder(2 * n + 1);
        }
        if (2 * n + 2 < arr.length) {
            preOrder(2 * n + 2);
        }
    }
}
