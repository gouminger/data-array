package com.gouminger.data.chapter2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//零矩阵
public class SetZeroes {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
        Arrays.stream(matrix).forEach(r -> System.out.println(Arrays.toString(r)));
        matrix = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(matrix);
        Arrays.stream(matrix).forEach(r -> System.out.println(Arrays.toString(r)));
    }

    /**
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     */
    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int r : rows) {
            for (int i=0; i<matrix[0].length; i++) {
                matrix[r][i] = 0;
            }
        }
        for (int c : cols) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
