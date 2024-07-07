package com.gouminger.data.chapter1;

public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
        nums = new int[]{1, 2, 3};
        System.out.println(pivotIndex(nums));
        nums = new int[]{2, 1, -1};
        System.out.println(pivotIndex(nums));
        nums = new int[]{-1, 1, 3};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int left = 0;
        int right = sum;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                left += nums[i - 1];
            }
            right -= nums[i];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

}
