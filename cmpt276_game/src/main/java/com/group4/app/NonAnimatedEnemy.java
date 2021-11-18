package com.group4.app;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class NonAnimatedEnemy extends RegularRewards implements ActionListener {
    final protected BufferedImage[] sprites = new BufferedImage[2];
    protected int frameCount = 0;
    protected Timer t;

    public NonAnimatedEnemy(int x, int y){
        t = new Timer(750,this);
        t.start();
        setSize(64,64);
        setLocation(x,y);
        try{
            sprites[0] = ImageIO.read(new File("src/main/resources/stalfos1.PNG"));
            sprites[1] = ImageIO.read(new File("src/main/resources/stalfos2.PNG"));
            image = sprites[0];
        }catch(IOException e){ System.out.println("NonAnimatedEnemy Sprite not found"); }
        collision = new collisionBox(getX()+27,getY()+27,10,10);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(image, 4, 4, this);
    }

    @Override
    public String getIdentifier(){
        return "NAA";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( frameCount == 0 )
            frameCount++;
        else
            frameCount--;
        image = sprites[frameCount];
        repaint();
    }
}
