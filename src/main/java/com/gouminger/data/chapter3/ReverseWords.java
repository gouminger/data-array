package com.gouminger.data.chapter3;

//翻转字符串里的单词
public class ReverseWords {

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));

        s = "  hello world  ";
        System.out.println(reverseWords(s));

        s = "a good   example";
        System.out.println(reverseWords(s));
    }

    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     */
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        String result = "";
        boolean world = false;
        int start = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == ' ' && !world) {
                continue;
            }
            if (arr[i] != ' ' && !world) {
                world = true;
                start = i;
            }
            if (arr[i] == ' ' && world) {
                world = false;
                if (result.isEmpty()) {
                    result = s.substring(start, i);
                } else {
                    result = s.substring(start, i) + " " + result;
                }
            }
            if (i == arr.length-1 && world) {
                if (result.isEmpty()) {
                    result = s.substring(start, i+1);
                } else {
                    result = s.substring(start, i+1) + " " + result;
                }
            }
        }
        return result;
    }
}
