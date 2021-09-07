package com.pearz.data_structure.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        char ch = ' ';
        boolean loop = true;

        while (loop) {
            System.out.println("请输入您的操作：");
            System.out.println("s(show):显示数据");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):显示对头数据");
            System.out.println("q(quit):退出");

            ch = scanner.next().charAt(0);

            switch (ch) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    try {
                        System.out.println("请输入要加入的数字：");
                        int num = scanner.nextInt();
                        queue.add(num);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int nu = queue.get();
                        System.out.println("输出的数字是：" + nu);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int n = queue.head();
                        System.out.println("队头的数字是：" + n);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'q':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出程序");
    }
}

class CircleArrayQueue {
    private int[] arrayQueue;//定义数组
    private int maxSize;
    private int front;
    private int rear;//默认为0

    //定义构造器
    public CircleArrayQueue(int size) {
        maxSize = size;
        arrayQueue = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空，无数据");
            return;
        }
        System.out.println("队列中的数据为：");
        for (int i = front; i < front + ((rear + maxSize - front) % maxSize); i++) {
            System.out.println(arrayQueue[i % maxSize]);
        }
    }

    public void add(int data) {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法加入数据");
        }
        arrayQueue[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取出数据");
        }
        int temp = arrayQueue[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无队头");
        }
        return arrayQueue[front];
    }
}