package com.example.object.domain.chapter10;

import org.springframework.util.Assert;

import java.util.Properties;
import java.util.Stack;

public class FragileBaseClassProblem {
    public static void main(String[] args) {
        initStackProblem();
        initPropertiesProblem();
    }

    public static void initStackProblem() {
        Stack<String> stack = new Stack<>();
        stack.push("1st");
        stack.push("2nd");
        stack.push("3rd");

        stack.add(0, "4th");

        Assert.isTrue(!"4th".equals(stack.pop()), "둘은 같지 않음");
    }

    public static void initPropertiesProblem() {
        Properties properties = new Properties();
        properties.setProperty("Bjarne Stroustrup", "C++");
        properties.setProperty("James Gosling", "Java");

        properties.put("Dennis Ritchie", 67);

        Assert.isTrue(properties.getProperty("Dennis Ritchie") == null, "getProperty는 메서드 반환값이 String이 아닐시 null을 반환");
    }
}
