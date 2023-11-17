package com.example.object.domain.appendixB;

import java.awt.*;

public interface Displayable extends GameObject {
    Point getPosition();
    void update(Graphics graphics);
}
