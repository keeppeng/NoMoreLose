package com.keeppeng.lc;

import java.util.*;

import static java.util.Collections.*;

/**
 * 求出大于或等于 N 的最小回文素数。
 * <p>
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 * <p>
 * 例如，2，3，5，7，11 以及 13 是素数。
 * <p>
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 * <p>
 * 例如，12321 是回文数。
 * 1 <= N <= 10^8
 */
public class ClassEightSixSix {
    public static void main(String[] args) {
        System.out.println(primePalindrome(9989900));
    }

    /**
     * 下面这种方法直接太可怕了 直接回导致栈的oom
     * @param n
     * @return
     */
    public static int primePalindrome(int n) {
        if (1 == n) {
            return 2;
        }
        if (isSym(n) && isPrime(n)) {
            return n;
        } else {
            return primePalindrome(n + 1);
        }
    }

    /**
     * 判断是否为回文数
     *
     * @param n
     * @return
     */
    private static boolean isSym(int n) {
        if (n < 10) {
            return true;
        }
        String right = String.valueOf(n);
        char[] chars = right.toCharArray();
        for (int i = 0; i < (chars.length >> 1); i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否为素数
     *
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        if (1 == n || 2 == n || 3 == n || 5 == n || 7 == n) {
            return true;
        }
        Set<Integer> notPrime = new HashSet<>();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                notPrime.add(n);
                return false;
            }
        }
        return true;
    }

}
