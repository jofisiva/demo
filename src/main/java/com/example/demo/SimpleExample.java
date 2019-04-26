package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerBeanMapper;

public class SimpleExample {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.setAddress("India");
        classA.setName("Sajal");
        classA.setAge("50");

        Map<String, ClassA> map = new HashMap<>();
        map.put("result", classA);


        ClassB classB = new DozerBeanMapper().map(classA, ClassB.class);
        System.out.println(classB);
    }
}
