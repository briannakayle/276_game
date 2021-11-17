package com.group4.app;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class Barrier extends entity{

    public Barrier(int x, int y){
        setSize(64,64);
        setLocation(x,y);
        try{
            image = ImageIO.read(new File("src/main/resources/obstacle.PNG"));
        }catch(IOException e){ System.out.println("Barrier Sprite not found"); }
        collision = new collisionBox(getX()+4,getY()+4,56,56);
        repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 4, 4, this);
    }
}