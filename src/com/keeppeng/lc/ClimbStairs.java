package com.keeppeng.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣第70题
 * 爬楼梯
 * 三年前应该是总结了算的规律然后写的方式，但是其实递归的规律没那么好找
 */
public class ClimbStairs {
    /**
     * 通过一个Map解决递归重复计算的问题 ， 注意这个Map中存值的时候 其实就存当前的值就行了
     */
    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (1 == n) {
            map.put(1, 1);
            return 1;
        }
        if (2 == n) {
            map.put(2, 2);
            return 2;
        }
        if (null != map.get(n)) {
            return map.get(n);
        } else {
            map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
            return map.get(n);
        }
    }

    /**
     * 第二种方式 ， 采用循环的方式来求解
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }
        int res = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; i++) {
            res = pre + prePre;
            prePre = pre;
            pre = res;
        }
        return res;
    }

    public int climbStairs2(int n) {
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
