package com.keeppeng.lc.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣第一题两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 */
public class ClassOne {


    /**
     * 优化,以Map存之前遍历过的数据中想要的值
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        if (null == nums || nums.length <= 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length * 2 / 3);

        for (int i = 0; i < nums.length; i++) {
            Integer ano = map.get(nums[i]);
            if (null != ano){
                return new int[]{ano,i};
            }else {
                map.put(target - nums[i],i);
            }
        }
        return null;
    }


    /**
     * 暴力法 双层遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length <= 1) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
