package com.gouminger.data.chapter5;

import java.util.Arrays;

//移动零
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     */
    public static void moveZeroes(int[] nums) {
        int i=0,j=0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            while (j<nums.length) {
                if (j <= i) {
                    j++;
                    continue;
                }
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                    j++;
                    break;
                }
                j++;
            }
        }
    }
}
