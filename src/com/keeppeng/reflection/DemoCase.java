package com.keeppeng.reflection;

public class DemoCase {
    public static void main(String[] args) {
//        classLoaderOne();
        try {
            Class<?> aClass = Class.forName("com.keeppeng.reflection.Case");
            aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static void classLoaderOne() {
        try {
            ClassLoader.getSystemClassLoader().loadClass("com.keeppeng.reflection.Case");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Case{
    static void init(){
        System.out.println("This is init method ...");
    }
}
