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

    public void resize(Rectangle rectangle, int width, int height) {
        rectangle.setHeight(width);
        rectangle.setHeight(height);
        assert rectangle.getWidth() == width && rectangle.getHeight() == height;
    }

    public void resize() {
        Square square = new Square(10, 10, 10);
        resize(square, 50, 100);
    }
}
