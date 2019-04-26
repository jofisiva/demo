package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class StudentVo {

    private Map<String, ClassB> map = new HashMap<>();

    public Map<String, ClassB> getMap() {
        return map;
    }

    public void setMap(Map<String, ClassB> map) {
        this.map = map;
    }

    public StudentVo() {
    }

    public StudentVo(Map<String, ClassB> map) {
        this.map = map;
    }
}
