package com.pearz.data_structure.tree;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(str.length());

        /*List<HuffmanCodeNode> list = getNodes(bytes);
//        System.out.println(list);

        HuffmanCodeNode root = createHuffmanTree(list);
        preOrder(root);

        getCode(root);
        System.out.println(huffmanCodes);

        byte[] huffmanCodesByte = zip(bytes, huffmanCodes);
        System.out.println(Arrays.toString(huffmanCodesByte));*/

        byte[] hcb = huffmanZip(bytes);
        System.out.println(Arrays.toString(hcb));
    }

    //
    public static List<HuffmanCodeNode> getNodes(byte[] bytes) {
        List<HuffmanCodeNode> nodes = new ArrayList<>();

        Map<Byte, Integer> counts = new HashMap<>();

        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanCodeNode(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //创建哈夫曼树
    public static HuffmanCodeNode createHuffmanTree(List<HuffmanCodeNode> nodes) {

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HuffmanCodeNode left = nodes.get(0);
            HuffmanCodeNode right = nodes.get(1);
            HuffmanCodeNode parent = new HuffmanCodeNode(null, left.value + right.value);
            parent.left = left;
            parent.right = right;

            nodes.remove(0);
            nodes.remove(0);
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    public static void preOrder(HuffmanCodeNode root) {
        if (root != null) {
            System.out.println(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //存放哈夫曼编码
    public static Map<Byte, String> huffmanCodes = new HashMap<>();

    //生成哈夫曼树对应的哈夫曼编码
    public static void getCode(HuffmanCodeNode node, String code, StringBuilder stringBuilder) {

        if (node != null) {
            StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
            stringBuilder2.append(code);
            if (node.data == null) {
                getCode(node.left, "0", stringBuilder2);
                getCode(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    //重载getCode方法，使调用方便
    public static void getCode(HuffmanCodeNode root) {
        if (root != null) {
            getCode(root, "", new StringBuilder());
        }

    }

    /**
     * 根据哈夫曼编码，压缩得到哈夫曼编码字节数组
     * @param bytes 原始字符串对应的byte[]
     * @param huffmanCodes 生成的哈夫曼编码map
     * @return 返回哈夫曼编编码处理后的byte[]
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        int length;

        if (stringBuilder.length() / 8 == 0) {
            length = stringBuilder.length() / 8;
        } else {
            length = stringBuilder.length() / 8 + 1;
        }

        byte[] huffmanCodesByte = new byte[length];
        int index = 0;

        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodesByte[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return huffmanCodesByte;
    }

    //使用一个方法，把之前的方法封装起来，便于调用
    public static byte[] huffmanZip(byte[] bytes) {
        List<HuffmanCodeNode> list = getNodes(bytes);
        //根据节点权值生成哈夫曼树
        HuffmanCodeNode root = createHuffmanTree(list);
        //根据哈夫曼树生成哈夫曼编码
        getCode(root);
        //根据哈夫曼编码，压缩得到哈夫曼编码字节数组
        byte[] huffmanCodesByte = zip(bytes, huffmanCodes);

        return huffmanCodesByte;
    }

}

//创建节点类
class HuffmanCodeNode implements Comparable<HuffmanCodeNode> {
    Byte data;
    int value;
    HuffmanCodeNode left;
    HuffmanCodeNode right;

    public HuffmanCodeNode(Byte data, int value) {
        this.data = data;
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanCodeNode o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "HuffmanCodeNode{" +
                "data=" + data +
                ", value=" + value +
                '}';
    }
}