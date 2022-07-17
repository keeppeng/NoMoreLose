package com.keeppeng.collectionandmap;

import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
    public static void main(String[] args) {
//        extracted();
        List myList = Arrays.asList(1, 2, 3);
        myList.add(4);//运行时报错：UnsupportedOperationException
        myList.remove(1);//运行时报错：UnsupportedOperationException
        myList.clear();//运行时报错：UnsupportedOperationException
    }

    private static void extracted() {
        String[] strings = {"kp", "mz", "dm"};
        List<String> strings1 = Arrays.asList(strings);
        System.out.println(strings1.get(0));
        System.out.println(strings1.get(1));
    }
}
