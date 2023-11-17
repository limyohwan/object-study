package com.example.object.domain.appendixB;

public interface Collidable extends Displayable {
    boolean collideWith(Collidable other);
}
