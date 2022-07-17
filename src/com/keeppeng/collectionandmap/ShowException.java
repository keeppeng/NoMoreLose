package com.keeppeng.collectionandmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ShowException {
    public static void main(String[] args) {
        List<Stu> list = new ArrayList<>();
        list.add(new Stu("KP",null));
        list.add(new Stu("MZ","25"));
        Map<String, String> StuMap = list.stream().collect(Collectors.toMap(Stu::getName, Stu::getNumber));

    }

}
class Stu{
    public Stu(String name, String number) {
        this.name = name;
        this.number = number;
    }

    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
