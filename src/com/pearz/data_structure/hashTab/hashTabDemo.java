package com.pearz.data_structure.hashTab;

import java.util.Scanner;

public class hashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(6);

        Scanner sc = new Scanner(System.in);
        String key;

        while (true) {
            System.out.println("请输入操作：");
            System.out.println("a(add):添加员工");
            System.out.println("d(delete):删除员工");
            System.out.println("f(find):寻找员工");
            System.out.println("l(list):遍历所有员工");
            System.out.println("e(exit):退出程序");

            key = sc.next();
            int no;
            switch (key) {
                case "a":
                    System.out.println("请输入员工id：");
                    no = sc.nextInt();
                    System.out.println("请输入员工姓名：");
                    String name = sc.next();
                    Emp emp = new Emp(no, name);
                    hashTab.add(emp);
                    break;
                case "d":
                    System.out.println("请输入要删除员工的id：");
                    no = sc.nextInt();
                    hashTab.delete(no);
                    break;
                case "f":
                    System.out.println("请输入要查找员工的id：");
                    no = sc.nextInt();
                    hashTab.find(no);
                    break;
                case "l":
                    hashTab.list();
                    break;
                case "e":
//                    sc.close();
                    return;
                default:
                    break;
            }
        }
    }
}

class HashTab {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; ++i) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int num = hashFun(emp.no);
        empLinkedLists[num].add(emp);
    }

    public void delete(int no) {
        int num = hashFun(no);
        empLinkedLists[num].delete(no);
    }

    public void find(int no) {
        int num = hashFun(no);
        empLinkedLists[num].find(no);
    }

    public void list() {
        for (int i = 0; i < size; ++i) {
            empLinkedLists[i].list(i);
            System.out.println();
        }
    }

    public int hashFun(int no) {
        return no % size;
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = emp;
    }

    public void delete(int no) {
        if (head == null) {
            System.out.println("无编号为" + no + "的员工");
            return;
        }

        if (head.no == no) {
            head = head.next;
            System.out.println("删除成功");
        }

        Emp temp = head;
        while (temp.next != null) {
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                System.out.println("删除成功");
                break;
            }
        }
        System.out.println("无编号为" + no + "的员工");
    }

    public void find(int no) {
        Emp temp = head;
        while (temp != null) {
            if (temp.no == no) {
                System.out.println("存在编号为" + no + "的员工，姓名为：" + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("无编号为" + no + "的员工");
    }

    public void list(int i) {
        if (head == null) {
            System.out.println(i + "号链表为空");
            return;
        }
        System.out.print(i + "号链表");
        Emp temp = head;
        while (temp != null) {
            System.out.print(" ====> no:" + temp.no + " name:" + temp.name);
            temp = temp.next;
        }
    }
}

class Emp {
    int no;
    String name;
    Emp next;

    public Emp(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
