package com.group4.app;

import javax.swing.*;
import java.awt.image.BufferedImage;

class baseElement extends JComponent {
    protected BufferedImage image;
    protected collisionBox collision;
    protected collisionBox getCollision(){
        return collision;
    }
}