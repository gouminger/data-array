package com.gouminger.data.chapter5;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

//杨辉三角
public class Generate {

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(JSON.toJSONString(generate(numRows)));

        numRows = 1;
        System.out.println(JSON.toJSONString(generate(numRows)));
    }

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
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
        return result;
    }
}
