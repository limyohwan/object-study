package com.example.object.domain.chapter4;

public class Rectangle {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rectangle(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    class AnyClass {
        // 너비와 높이를 증가시키는 코드
        void anyMethod(Rectangle rectangle, int multiple) {
            rectangle.setRight(rectangle.getRight() * multiple);
            rectangle.setBottom(rectangle.getBottom() * multiple);
        }
    }
}
