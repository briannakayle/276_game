package com.group4.app;

import javax.swing.*;
import java.awt.image.BufferedImage;

class entity extends JComponent {
    final public String Barrierirectory = "/Users/efe/Documents/Simon Fraser University/FALL 2021/CMPT 276/project/cmpt276_game/src/main";
    protected BufferedImage image;
    protected collisionBox collision;
    protected collisionBox getCollision(){
        return collision;
    }
}