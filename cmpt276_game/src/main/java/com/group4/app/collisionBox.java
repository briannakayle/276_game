package com.group4.app;

import java.awt.*;

class collisionBox extends Rectangle {
    public collisionBox(int x, int y, int width, int height){
        setSize(width, height);
        setLocation(x, y);
    }
}