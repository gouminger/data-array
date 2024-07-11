package com.gouminger.data.chapter5;

//反转字符串中的单词 III
public class ReverseWords {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));

        s = "Mr Ding";
        System.out.println(reverseWords(s));
    }

    /**
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     */
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i=0,j=0,jt;
        char t;
        while (true) {
            if (j == arr.length) {
                break;
            } else if (arr[j] != ' ') {
                if (i==-1) {
                    i=j;
                }
                j++;
                continue;
            }
            jt = j;
            j--;
            while (i<j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
            i=-1;
            j = jt+1;
        }
        j--;
        while (i<j) {
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        return new String(arr);
    }
}
