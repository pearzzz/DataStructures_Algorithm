package com.pearz.data_structure.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        DoubleLinked doubleLinked = new DoubleLinked();

        DNode n1 = new DNode(8, "翟洪颢", "老翟");
        DNode n2 = new DNode(4, "张添祥", "添祥");
        DNode n3 = new DNode(2, "张梦麟", "梦麟");
        DNode n4 = new DNode(9, "张渊灰", "灰灰");

        DNode n5 = new DNode(9, "黄立", "立哥");

//        doubleLinked.add(n1);
//        doubleLinked.add(n2);
//        doubleLinked.add(n3);
//        doubleLinked.add(n4);

        doubleLinked.addByOrder(n1);
        doubleLinked.addByOrder(n2);
        doubleLinked.addByOrder(n3);
        doubleLinked.addByOrder(n4);

        doubleLinked.list();
        System.out.println();

        doubleLinked.update(n5);
        doubleLinked.list();
        System.out.println();

        doubleLinked.delete(4);
        doubleLinked.list();

    }
}

class DoubleLinked {
    private DNode head = new DNode(0, "", "");

    public DNode getHead() {
        return head;
    }

    //添加元素到列表尾
    public void add(DNode node) {
        DNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //按编号no添加元素
    public void addByOrder(DNode node) {
        DNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
//                System.out.println("编号已存在，无法插入");
//                return;
                throw new RuntimeException("编号" + node.no + "已存在，无法插入");
            }

            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        if (node.next != null) {
            node.pre = node.next.pre;
            node.next.pre = node;
        }
    }

    public void update(DNode node) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DNode temp = head.next;
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

        DNode temp = head.next;
        while (temp != null) {
            if (temp.no == n) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.printf("不存在编号为%d的节点\n", n);
        }
    }

    //输出链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

class DNode {
    int no;
    String name;
    String nickName;
    DNode next;
    DNode pre;

    public DNode(int no, String name, String nickName) {
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