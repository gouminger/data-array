package com.gouminger.data.chapter1;

//寻找数组的中心索引
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

    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     */
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
