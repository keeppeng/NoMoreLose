package com.keeppeng.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestCase {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.keeppeng.reflection.Person");
            Person o = (Person)aClass.newInstance();
            o.pri();
            Constructor<?>[] constructors = aClass.getConstructors();
            for (int i = 0; i < constructors.length; i++) {
            }
            Method prt = aClass.getMethod("prt");
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
