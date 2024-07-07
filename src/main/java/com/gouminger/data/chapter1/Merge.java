package com.gouminger.data.chapter1;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

//合并区间
public class Merge {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{8, 10}, {1, 3}, {2, 6}, {15, 18}};
        System.out.println(JSON.toJSONString(merge(intervals)));
        intervals = new int[][]{{1, 4}, {4, 5}};
        System.out.println(JSON.toJSONString(merge(intervals)));
        intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        System.out.println(JSON.toJSONString(merge(intervals)));
        intervals = new int[][]{{1, 4}, {0, 2}, {3, 5}};
        System.out.println(JSON.toJSONString(merge(intervals)));
    }

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [start-i, end-i] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     */
    public static int[][] merge(int[][] intervals) {
        // 转成list结构，避免每次数组拷贝
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }
        int length = list.size();

        //按顺序合并数组
        for (int i = 0; i < list.size(); i++) {
            int[] left = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                int[] right = list.get(j);
                if ((left[1] >= right[0] && left[1] <= right[1])
                        || (right[1] >= left[0] && right[1] <= left[1])) {
                    left[0] = Math.min(left[0], right[0]);
                    left[1] = Math.max(left[1], right[1]);
                    list.set(i, left);
                    list.remove(j);
                    j = i;
                    length--;
                }
            }
        }

        //list转数组并返回
        int[][] result = new int[length][2];
        for (int i = 0; i < length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
