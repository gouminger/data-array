package com.gouminger.data.chapter2;

import java.util.Arrays;

//对角线遍历
public class FindDiagonalOrder {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] result = findDiagonalOrder(mat);
        // 1 2 4 7 5 3 6 8 9
        System.out.println(Arrays.toString(result));
        mat = new int[][]{
                {1, 2, 3, 11},
                {4, 5, 6, 12},
                {7, 8, 9, 13}
        };
        result = findDiagonalOrder(mat);
        // 1, 2, 4, 7, 5, 3, 11, 6, 8, 9, 12, 13
        System.out.println(Arrays.toString(result));
        mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}
        };
        result = findDiagonalOrder(mat);
        // 1 2 4 7 5 3 6 8 9
        System.out.println(Arrays.toString(result));
    }

    /**
     * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        int length = mat[0].length;
        int width = mat.length;
        int[] result = new int[length*width];

        int left = 0;
        int right = 0;
        int i = 0;
        // 向上的线
        boolean flag = true;
        while (i < result.length) {
            result[i++] = mat[left][right];
            if (flag) {
                if (left > 0 && right < length - 1) {
                    left--;
                    right++;
                } else {
                    if (right < length - 1) {
                        right++;
                    } else {
                        left++;
                    }
                    flag = false;
                }
            } else {
                if (left < width - 1 && right > 0) {
                    left++;
                    right--;
                } else {
                    if (left < width - 1) {
                        left++;
                    } else {
                        right++;
                    }
                    flag = true;
                }
            }
        }
        return result;
    }
}
