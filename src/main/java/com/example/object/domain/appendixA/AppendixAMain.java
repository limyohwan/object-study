package com.example.object.domain.appendixA;

public class AppendixAMain {
    // 공변성 = S와 T 사이의 서브타입 관계가 그대로 유지됨
    // 반공변성 = S와 T 사이의 서브타입 관계가 역전됨
    // 무공변성 = S와 T 사이의 아무런 관계도 존재하지 않음
    public static void main(String[] args) {
        new Customer().order(new BookStall());
        new Customer().order(new MagazineStore());
        // 부모클래스에서 구현된 메서드를 자식 클래스에서 오버라이딩 할 때
        // 부모 클래스에서 선언한 반환타입의 서브타입으로 지정할 수 있는 특성을
        // 리턴 타입 공변성이라고 부름
        // 메서드를 구현한 클래스의 타입 계층 방향과 리턴 타입의 타입 계층 방향이 동일한 경우
    }
}
