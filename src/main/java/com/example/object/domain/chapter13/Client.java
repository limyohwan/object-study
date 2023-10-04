package com.example.object.domain.chapter13;

public class Client {
//    public void flyBird(Bird bird) {
//        if(!(bird instanceof Penguin)) {
//            bird.fly();
//        }
//    }

    public void flyBird(FlyingBird bird) {
        bird.fly();
    }
}
