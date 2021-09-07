package com.pearz.data_structure.stack;

import java.util.Scanner;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack lls = new LinkedListStack();
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean loop = true;

        while (loop) {
            System.out.println("请输入您的操作对应的序号：");
            System.out.println("1.push :进栈");
            System.out.println("2.pop :出栈");
            System.out.println("3.list :遍历栈");
            System.out.println("4.exit :退出程序");

            num = sc.nextInt();

            switch (num) {
                case 1:
                    System.out.println("请输入进栈的数据：");
                    num = sc.nextInt();
                    lls.push(num);
                    break;
                case 2:
                    try {
                        System.out.println("出栈的数据为：" + lls.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    lls.list();
                    break;
                case 4:
                    loop = false;
                default:
                    break;
            }
        }
    }
}

class LinkedListStack {
    Node head = new Node();
    Node top = head;
    Node temp = head, topp;

    public boolean isEmpty() {
        return top == head;
    }

    public void push(int num) {
        Node node = new Node(num, null);
        top.next = node;
        top = node;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法出栈");
        }
        temp = head;
        while (temp.next != top) {
            temp = temp.next;
        }
        top = temp;
        return top.next.val;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        temp = head;
        topp = top;
        System.out.println("栈中的元素为：");
        while (topp != head) {
            while (head.next != topp) {
                head = head.next;
            }
            System.out.println(topp.val);
            topp = temp;
            temp = head;
        }
    }
}

class Node {
    int val;
    Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
