package com.pearz.data_structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String expression = "(16*9)-2-6/3+4";
        List infix = toInfixExpressionList(expression);
        System.out.println(infix);
        List suffix = parseSuffixExpressionList(infix);
        System.out.println(suffix);

        System.out.println(calculate(suffix));
    }

    //将中缀表达式字符串转换成list
    public static List<String> toInfixExpressionList(String s) {
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        String num = "";
        char ch = ' ';

        while (count < s.length()) {
            ch = s.charAt(count);
            if (ch > '0' && ch < '9') {
                while (count < s.length() && ch > '0' && ch < '9') {
                    num = num + ch;
                    ++count;
                    if (count < s.length()) {
                        ch = s.charAt(count);
                    }
                }
                list.add(num);
                num = "";
            } else {
                list.add(ch + "");
                ++count;
            }
        }

        return list;
    }

    //将中缀表达式list转换成后缀表达式list
    public static List<String> parseSuffixExpressionList(List<String> infix) {
        Stack<String> stack = new Stack<>();//存放运算符
        ArrayList<String> list = new ArrayList<>();//存放数字，结果

        for (String elem : infix) {
            if (elem.matches("^\\d+$")) {
                list.add(elem);
            } else if (elem.equals("(")) {
                stack.push(elem);
            } else if (elem.equals(")")) {
                while (!stack.peek().equals("(")) {
                    list.add(stack.pop());
                }
                stack.pop();
            } else {
                if (stack.isEmpty() || stack.peek().equals("(") || priority(elem) > priority(stack.peek())) {
                    stack.push(elem);
                } else {
                    while (!stack.isEmpty() && priority(elem) <= priority(stack.peek())) {
                        list.add(stack.pop());
                    }
                    stack.push(elem);
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }

    //将字符串转换成list
    public static List<String> getListByString(String str) {
        List<String> list = new ArrayList<String>();
        String[] strs = str.split(" ");

        for (String s : strs) {
            list.add(s);
        }

        return list;
    }

    //计算后缀表达式
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<String>();
        int num1, num2, res;
        for (String ele : list) {
            if (ele.matches("^\\d+$")) {
                stack.push(ele);
            } else {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                if (ele.equals("+")) {
                    res = num1 + num2;
                } else if (ele.equals("-")) {
                    res = num2 - num1;
                } else if (ele.equals("/")) {
                    res = num2 / num1;
                } else if (ele.equals("*") || ele.equals("x") || ele.equals("X")) {
                    res = num1 * num2;
                } else {
                    throw new RuntimeException("抱歉，符号有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.peek());
    }

    //比较运算符的优先级
    public static int priority(String oper) {
        if (oper.equals("-") || oper.equals("+")) {
            return 0;
        } else if (oper.equals("/") || oper.equals("*")) {
            return 1;
        } else {
            return -1;
        }
    }
}
