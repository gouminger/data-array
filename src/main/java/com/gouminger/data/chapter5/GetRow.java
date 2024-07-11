package com.gouminger.data.chapter5;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

//杨辉三角 II
public class GetRow {

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(JSON.toJSONString(getRow(numRows)));

        numRows = 1;
        System.out.println(JSON.toJSONString(getRow(numRows)));
    }

    /**
     * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     */
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<=rowIndex; i++) {
            List<Integer> child = new ArrayList<>();
            for (int j=0; j<i+1; j++) {
                if (j==0 || j==i) {
                    child.add(1);
                } else {
                    List<Integer> preChild = result.get(i-1);
                    child.add(preChild.get(j-1)+preChild.get(j));
                }
            }
            result.add(child);
        }
        return result.get(rowIndex);
    }
}
