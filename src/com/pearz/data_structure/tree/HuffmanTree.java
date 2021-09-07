package com.pearz.data_structure.tree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffmanNode root = createHuffmanTree(arr);

        preOrder(root);

    }

    public static void preOrder(HuffmanNode root) {
        if (root != null) {
            System.out.println(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static HuffmanNode createHuffmanTree(int[] arr) {
        ArrayList<HuffmanNode> huffmanNodes = new ArrayList<>();
        for (int value : arr) {
            huffmanNodes.add(new HuffmanNode(value));
        }

        while (huffmanNodes.size() > 1) {
            Collections.sort(huffmanNodes);

            HuffmanNode leftNode = huffmanNodes.get(0), rightNode = huffmanNodes.get(1);
            HuffmanNode parent = new HuffmanNode(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            huffmanNodes.remove(0);
            huffmanNodes.remove(0);
            huffmanNodes.add(parent);
        }

        return huffmanNodes.get(0);
    }
}

class HuffmanNode implements Comparable<HuffmanNode> {
    int value;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }
}
