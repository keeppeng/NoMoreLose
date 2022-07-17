package com.keeppeng.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 565 数组嵌套
 * 深度优化的题目
 * <p>
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * <p>
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * <p>
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * <p>
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 */
public class DeepFixed {
    public static void main(String[] args) {
        DeepFixed instance = new DeepFixed();
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(instance.arrayNesting(nums));
    }

    /**
     * 思路
     * 分析可以看到不管哪种方式,其实都是一个环
     *
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return 2;
        }
        int countMax = 0;
        Map<Integer, Boolean> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int countLength = 0;
            if (null == maps.get(i) || !maps.get(i)) {
                while (true) {
                    countLength++;
                    int reIndex = nums[i]; // 5
                    if (null != maps.get(reIndex)) {
                        break;
                    }
                    i = reIndex;  // i = 5
                    maps.put(i, true);
                }
                countMax = Math.max(countLength - 1, countMax);
            }
            maps.put(i, true);
        }
        return countMax;
    }
}
