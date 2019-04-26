package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private Map<String ,ClassA> map = new HashMap();

    public Student(Map<String, ClassA> map) {
        this.map = map;
    }

    public Student() {
    }

    public Map<String, ClassA> getMap() {
        return map;
    }

    public void setMap(Map<String, ClassA> map) {
        this.map = map;
    }
}
