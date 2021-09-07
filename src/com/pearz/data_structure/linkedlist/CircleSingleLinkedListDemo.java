package com.pearz.data_structure.linkedlist;

public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.josepfu(1, 2, 5);
    }
}

class CircleSingleLinkedList {
    private CNode first = new CNode(-1);

    public void add(int n) {
        if (n < 1) {
            System.out.println("请至少输入一个数");
            return;
        }
        CNode temp = first;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                first.setNo(i);
                first.setNext(first);
            } else {
                CNode node = new CNode(i);
                temp.setNext(node);
                node.setNext(first);
                temp = node;
            }
        }
    }

    public void show() {
        if (first.getNo() == -1) {
            System.out.println("链表为空");
            return;
        }
        CNode temp = first;
        while (true) {
            System.out.println("小孩的编号为：" + temp.getNo());
            temp = temp.getNext();
            if (temp == first) {
                break;
            }
        }
    }

    public void josepfu(int startNo, int count, int nums) {
        if (first == null || startNo < 1 || startNo > nums || nums < 1 || count < 1) {
            System.out.println("参数错误");
            return;
        }

        add(nums);

        CNode temp = first;

        while (true) {
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }

        int cou = count;

        while (temp.getNext() != temp) {
            for (int i = 1; i < cou; i++) {
                temp = temp.getNext();
            }
            System.out.println(temp.getNext().getNo());
            temp.setNext(temp.getNext().getNext());
        }
        System.out.println(temp.getNo());
    }
}

class CNode {
    private int no;
    private CNode next;

    public CNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public CNode getNext() {
        return next;
    }

    public void setNext(CNode next) {
        this.next = next;
    }
}
