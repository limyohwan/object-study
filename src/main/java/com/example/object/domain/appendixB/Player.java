package com.example.object.domain.appendixB;

import java.awt.*;

public class Player implements Collidable { // 여러 클래스가 동일한 타입을 구현할 수 있음(Player, Monster)
    @Override
    public boolean collideWith(Collidable other) {
        return false;
    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public void update(Graphics graphics) {

    }

    @Override
    public String getName() {
        return null;
    }
}
// 클래스와 타입 간의 차이를 이해하는 것이 중요함
// 객체가 클래스의 인터페이스라고 말할 때 객체는 클래스가 정의하고 있는 인터페이스를 지원한다
