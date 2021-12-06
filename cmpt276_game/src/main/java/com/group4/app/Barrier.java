package com.group4.app;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

class Barrier extends baseElement{

    /**
     *Basic Barrier that obstructs the player, to be used to set mazes within the maze.
     */

    public Barrier(int x, int y){
        setSize(64,64);
        setLocation(x,y);
        try{
            image = ImageIO.read((getClass().getResourceAsStream("/obstacle.png")));
        }catch(IOException e){ System.out.println("Barrier Sprite not found"); }
        collision = new collisionBox(getX()+7,getY()+7,50,50);
        repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 4, 4, this);
    }
}
