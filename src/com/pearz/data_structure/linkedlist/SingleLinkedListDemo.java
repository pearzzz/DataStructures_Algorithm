package com.pearz.data_structure.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();

        Node n1 = new Node(8, "翟洪颢", "老翟");
        Node n2 = new Node(4, "张添祥", "添祥");
        Node n3 = new Node(2, "张梦麟", "梦麟");
        Node n4 = new Node(9, "张渊灰", "灰灰");

        Node n5 = new Node(9, "黄立", "立哥");



//        singleLinked.add(n1);
//        singleLinked.add(n2);
//        singleLinked.add(n3);
//        singleLinked.add(n4);

        /*try {
            singleLinked.addByOrder(n1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            singleLinked.addByOrder(n2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            singleLinked.addByOrder(n3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            singleLinked.addByOrder(n4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        //增
        singleLinked.addByOrder(n1);
        singleLinked.addByOrder(n2);
        singleLinked.addByOrder(n3);
        singleLinked.addByOrder(n4);

        System.out.println("修改前的链表为：");
        singleLinked.list();
        System.out.println();

        //改
        singleLinked.update(n5);
        System.out.println("修改后的链表为：");
        singleLinked.list();
        System.out.println();

        //删
        singleLinked.delete(7);
        System.out.println("删除后的链表为：");
        singleLinked.list();
        System.out.println();

        System.out.println("链表的长度为：" + getLength(singleLinked.getHead()));
        System.out.println();

        System.out.println(findLastIndexNode(singleLinked.getHead(), 1));
        System.out.println();

        /*System.out.println("反转后的链表为：");
        reverseList(singleLinked.getHead());
        singleLinked.list();
        System.out.println();*/

        System.out.println("逆序打印：");
        reversePrint(singleLinked.getHead());
        System.out.println();

    }

    //求单链表中有效节点的个数（不含头节点）
    public static int getLength(Node head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        Node temp = head.next;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    //查找链表中的倒数第k哥节点
    public static Node findLastIndexNode(Node head, int k) {
        if (head.next == null) {
            System.out.println("链表为空");
            return null;
        }
        if (k <= 0 || k > getLength(head)) {
            System.out.println("取值范围错误");
            return null;
        }
        Node res = head;
        Node temp = res;

        //temp在res后k个
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }

        while (temp != null) {
            res = res.next;
            temp = temp.next;
        }

        return res;
    }

    //单链表的反转
    public static void reverseList(Node head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        Node p = head.next.next;
        Node q = p.next;

        head.next.next = null;

        while (p != null) {
            p.next = head.next;
            head.next = p;

            p = q;
            if (p != null){
                q = p.next;
            }
        }
    }

    //不破坏链表的情况下反向打印节点
    public static void reversePrint(Node head) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = head.next;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

class SingleLinked {
    private Node head = new Node(0, "", "");

    public Node getHead() {
        return head;
    }

    //添加元素到列表尾
    public void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    //按编号no添加元素
    public void addByOrder(Node node) {
        Node temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }else if (temp.next.no > node.no) {
                break;
            }else if (temp.next.no == node.no) {
//                System.out.println("编号已存在，无法插入");
//                return;
                throw new RuntimeException("编号" + node.no + "已存在，无法插入");
            }

            temp = temp.next;
        }

        node.next = temp.next;
        temp.next =node;
    }

    public void update(Node node) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (temp != null) {
            if (temp.no == node.no) {
                temp.name = node.name;
                temp.nickName = node.nickName;
                break;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("不存在编号为" + node.no + "的节点");
        }
    }

    public void delete(int n) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.no == n) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.printf("不存在编号为%d的节点\n", n);
        }
    }

    //输出链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

class Node {
    int no;
    String name;
    String nickName;
    Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
