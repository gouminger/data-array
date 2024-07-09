package com.gouminger.data.chapter3;

//实现 strStr()
public class StrStr {

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));

        haystack = "leetcode";
        needle = "leeto";
        System.out.println(strStr(haystack, needle));

        haystack = "mississippi";
        needle = "issip";
        System.out.println(strStr(haystack, needle));

        haystack = "mississippi";
        needle = "pi";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
     * 如果 needle 不是 haystack 的一部分，则返回 -1 。
     */
    public static int strStr(String haystack, String needle) {
        char[] txtArr = haystack.toCharArray();
        char[] childArr = needle.toCharArray();

        //时间复杂度O(m+n) -1 -1 0 1 2 -1 0
        int[] matchLen = new int[childArr.length];
        for (int i=0; i<childArr.length; i++) {
            int len = -1;
            for (int j=0;j<i;j++) {
                boolean f = true;
                for (int k=0;k<=j;k++) {
                    if (childArr[k] != childArr[i-j+k]) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    len = j;
                }
            }
            matchLen[i] = len;
        }

        int ptr0 = 0;
        int ptr1 = 0;
        while (ptr0<txtArr.length) {
            if (txtArr[ptr0] == childArr[ptr1]) {
                if (ptr1 == childArr.length-1) {
                    return ptr0-childArr.length+1;
                    //ptr1 = matchLen[childArr.length-1];
                }
                ptr0++;
                ptr1++;
            } else {
                if (ptr1 == 0) {
                    ptr0++;
                } else if (matchLen[ptr1-1] == -1) {
                    ptr1 = 0;
                } else {
                    ptr1 = matchLen[ptr1-1]+1;
                }
            }

        }
        return -1;
    }
}
