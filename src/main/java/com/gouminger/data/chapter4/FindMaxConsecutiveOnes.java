package com.gouminger.data.chapter4;

//最大连续1的个数
public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));

        nums = new int[]{1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    /**
     * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int r=0,t=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                t++;
            } else if (t>r) {
                r=t;
                t=0;
            } else {
                t = 0;
            }
        }
        if (t>r) {
            r=t;
        }
        return r;
    }
}
