package com.gouminger.data.chapter4;

//长度最小的子数组
public class MinSubArrayLen {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));

        target = 4;
        nums = new int[]{1,4,4};
        System.out.println(minSubArrayLen(target, nums));

        target = 11;
        nums = new int[]{1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
     * 如果不存在符合条件的子数组，返回 0 。
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int sum=0,start=0,t,len=Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            sum+=nums[i];
            while (sum >= target) {
                t = i - start + 1;
                if (t < len) {
                    len = t;
                }
                sum -= nums[start];
                start++;
            }
        }
        if (len==Integer.MAX_VALUE) {
            return 0;
        }
        return len;
    }

}
