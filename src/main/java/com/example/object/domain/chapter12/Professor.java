package com.example.object.domain.chapter12;

import java.util.List;

public class Professor {
    private String name;
    private Lecture lecture;

    public Professor(String name, Lecture lecture) {
        this.name = name;
        this.lecture = lecture;
    }

    public String compileStatistics() {
        return String.format("[%s] %s - Avg: %.1f", name, lecture.evaluate(), lecture.average());
    }

    public static void main(String[] args) {
        Professor professor = new Professor("다익스트라", new Lecture(70, "알고리즘", List.of(81, 95, 75, 50, 45)));
        Professor professor2 = new Professor("다익스트라", new GradeLecture(70,
                "객체지향 프로그래밍",
                List.of(81, 95, 75, 50, 45),
                List.of(new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 50),
                        new Grade("F", 49, 0))));

        System.out.println(professor.compileStatistics());
        System.out.println(professor2.compileStatistics());
    }
}
