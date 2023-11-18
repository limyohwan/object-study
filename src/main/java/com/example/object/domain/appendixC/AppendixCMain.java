package com.example.object.domain.appendixC;

public class AppendixCMain {
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        Troll troll = new Troll();

        CompositionMonster compositionDragon = new CompositionMonster(new Breed("용", 230, "용은 불을 내뿜는다"));
        CompositionMonster compositionTroll = new CompositionMonster(new Breed("트롤", 48, "트롤은 곤봉으로 때린다"));
    }
}
