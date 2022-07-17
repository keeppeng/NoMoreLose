package com.keeppeng.datastructure.array;

/**
 * 稀疏数组 时间换空间的方法
 * 二维棋盘和稀疏数组的切换
 */
public class SparseArray {
    public static void main(String[] args) {
        //1. 创建原始的二维数组
        int[][] ints = new int[11][11];
        ints[0][2] = 1;
        ints[1][3] = 2;
        // 打印棋盘 原始二维数组
        showSimple(ints);

        // 转换为稀疏数组
        int[][] spareInts = getSpareInts(ints);
        System.out.println("transfer over ... ");
        showSimple(spareInts);

    }

    private static int[][] getSpareInts(int[][] ints) {
        int countNotZero = 0;
        // 首先要看有几个数
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] != 0) {
                    countNotZero++;
                }
            }
        }
        int[][] spareInts = new int[countNotZero + 1][3];
        spareInts[0][0] = 11;
        spareInts[0][1] = 11;
        spareInts[0][2] = 2;

        int index = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] != 0) {
                    index++;
                    spareInts[index][0] = i;
                    spareInts[index][1] = j;
                    spareInts[index][2] = ints[i][j];
                }
            }
        }

        return spareInts;
    }

    /**
     * 打印棋盘的方法
     *
     * @param ints 棋盘数据
     */
    private static void showSimple(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
