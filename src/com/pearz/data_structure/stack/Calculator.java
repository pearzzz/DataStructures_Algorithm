package com.pearz.data_structure.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "2*(2*(2+2))";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        char ch = ' ';
        int num1, num2, oper, count = 0;
        String num = "";

        while (count < expression.length()) {
            ch = expression.charAt(count);
            if (isOper(ch)) {
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    while (!operStack.isEmpty() && priority(ch) <= priority(operStack.peek())) {
                        num2 = numStack.pop();
                        num1 = numStack.pop();
                        oper = operStack.pop();
                        numStack.push(cal(num1, num2, oper));
                    }
                    operStack.push(ch);
                }
                ++count;
            } else if (ch == '(') {
                operStack.push(ch);
                ++count;
            } else if (ch == ')') {
                while (true) {
                    oper = operStack.pop();
                    if (oper == '(') {
                        break;
                    }
                    num2 = numStack.pop();
                    num1 = numStack.pop();
                    numStack.push(cal(num1, num2, oper));
                }
                ++count;
            } else {
                num = num + expression.charAt(count);
                while (count < expression.length() - 1 && expression.charAt(count + 1) >= '0' && expression.charAt(count + 1) <= '9') {
                    ++count;
                    num = num + expression.charAt(count);
                }
                numStack.push(Integer.parseInt(num));
                num = "";
                ++count;
            }
        }

        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num2 = numStack.pop();
            num1 = numStack.pop();
            oper = operStack.pop();
            numStack.push(cal(num1, num2, oper));
        }

        System.out.println(expression + " = " + numStack.peek());
    }

    public static boolean isOper(char ch) {
        return (ch == '+' || ch == '-' || ch == '/' || ch == '*');
    }

    public static int priority(int ch) {
        if (ch == '-' || ch == '+') {
            return 0;
        } else if (ch == '/' || ch == '*') {
            return 1;
        } else {
            return -1;
        }
    }

    public static int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            default:
                break;
        }
        return res;
    }
}

class ArrayStack2 {
    int[] stack;
    int maxSize;
    int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满，无法进栈");
            return;
        }
        stack[++top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法出栈");
        }
        int num = stack[top--];
        return num;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int num = stack[top];
        return num;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        System.out.println("栈中的元素为：");
        for (int i = top; i > -1; --i) {
            System.out.println(stack[i]);
        }
    }
}
