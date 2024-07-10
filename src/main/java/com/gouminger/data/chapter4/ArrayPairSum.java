package com.gouminger.data.chapter4;

//数组拆分 I
public class ArrayPairSum {

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,9,2,8,9,1,4};
        System.out.println(arrayPairSum(nums));
    }

    /**
     * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
     * 使得从 1 到 n 的 min(ai, bi) 总和最大。返回该 最大总和 。
     */
    public static int arrayPairSum(int[] nums) {
        int[] standNums = new int[20001];
        for (int i=0; i<20001; i++) {
            standNums[i] = 0;
        }
        for (int i=0; i<nums.length; i++) {
            standNums[nums[i]+10000]++;
        }
        boolean add = true;
        int res = 0;
        for (int i=0; i<20001; i++) {
            while (standNums[i] > 0) {
                standNums[i]--;
                if (add) {
                    res+=i;
                }
                add = !add;
            }
        }
        res = res-10000*(nums.length/2);
        return res;
    }
}
