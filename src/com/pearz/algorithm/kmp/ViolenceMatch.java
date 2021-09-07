package com.pearz.algorithm.kmp;

public class ViolenceMatch {
    public static void main(String[] args) {
        String s1 = "我爱你你爱我蜜雪冰城甜蜜蜜";
        String s2 = "爱我蜜m";

        System.out.println(violenceMatch(s1, s2));
    }

    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int i = 0, j = 0;

        int len1 = s1.length, len2 = s2.length;

        while (i < len1 && j < len2) {
            if (s1[i] == s2[j]) {
                ++i;
                ++j;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == len2) {
            return i - j;
        }
        return -1;
    }
}
