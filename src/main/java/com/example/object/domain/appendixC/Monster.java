package com.example.object.domain.appendixC;

public abstract class Monster {
    private int health;

    public Monster(int health) {
        this.health = health;
    }

    abstract public String getAttack();
}

// 새로운 몬스터를 추가할 때마다 클래스를 계속해서 생성하고 getAttack 메서드를 오버라이딩 해야함
