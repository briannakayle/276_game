package com.group4.app;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class RegularRewards extends baseElement{

    public RegularRewards(int x, int y){
        setSize(64,64);
        setLocation(x,y);
        try {
            image = ImageIO.read(new File("src/main/resources/point.PNG"));
        } catch(IOException e){ System.out.println("Point Sprite source not found"); }
        collision = new collisionBox(getX()+16,getY(),32,64);
        setDoubleBuffered(true);
    }

    RegularRewards() {
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 16, 0, this);
    }

    public String getIdentifier() {
        return "RR";
    }
}
