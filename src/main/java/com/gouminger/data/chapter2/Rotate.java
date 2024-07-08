package com.gouminger.data.chapter2;

import java.util.Arrays;

//旋转矩阵
public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        Arrays.stream(matrix).forEach(r -> System.out.println(Arrays.toString(r)));
        matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(matrix);
        Arrays.stream(matrix).forEach(r -> System.out.println(Arrays.toString(r)));
    }

    /**
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     * 不占用额外内存空间能否做到？
     */
    public static void rotate(int[][] matrix) {
        //计算有几个圈
        int rotateCount = matrix.length/2;
        //临时变量位置
        int temp;
        int l = matrix.length;
        for (int i = 0; i < rotateCount; i++) {
            //该圈交换几次，每次交换四个数
            int rotateLen = matrix.length-2*i-1;
            for (int j = 0; j < rotateLen; j++) {
                temp = matrix[i][i+j];
                matrix[i][i+j] = matrix[l-1-i-j][i];
                matrix[l-1-i-j][i] = matrix[l-1-i][l-1-i-j];
                matrix[l-1-i][l-1-i-j] = matrix[i+j][l-1-i];
                matrix[i+j][l-1-i] = temp;
            }
            /**
             * (i,i+j)---(i+j,l-1-i)
             * |            |
             * |            |
             * (l-1-i-j,i)---(l-1-i,l-1-i-j)
             */
        }

    }
}
