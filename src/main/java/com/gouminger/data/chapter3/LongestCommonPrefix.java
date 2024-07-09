package com.gouminger.data.chapter3;

//最长公共前缀
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);

        strs = new String[]{"dog","racecar","car"};
        result = longestCommonPrefix(strs);
        System.out.println(result);

        strs = new String[]{"ab","a"};
        result = longestCommonPrefix(strs);
        System.out.println(result);

        strs = new String[]{"cir","car"};
        result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     */
    public static String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        int len = result.length();
        for (int i=1; i<strs.length; i++) {
            String s = strs[i];
            int tl = 0;
            for (int j=0;j<s.length()&&j<len;j++) {
                if (result.charAt(j) == s.charAt(j)) {
                    tl++;
                } else {
                    break;
                }
            }
            len = tl;
            if (len == 0) {
                break;
            }
        }
        return result.substring(0, len);
    }
}
