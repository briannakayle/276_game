package com.group4.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MovingEnemy extends NonAnimatedEnemy{
    private int drawX = 0; private int drawY = 0;
    private int direction, noMove;
    public MovingEnemy(int x, int y) {
        super(x,y);
        t.stop();
        t = new Timer(100,this);
        try{
            sprites[0] = ImageIO.read(new File("src/main/resources/bat1.PNG"));
            sprites[1] = ImageIO.read(new File("src/main/resources/bat2.PNG"));
            image = sprites[0];
        }catch(IOException e){ System.out.println("AnimatedEnemy Sprite not found"); }
        adjust(64,32);
    }

    private void adjust(int width, int height){
        collision.setSize(width, height);
        drawX = (64-width)/2;
        drawY = (64-height)/2;
    }

    public int getDirection() {
        return direction;
    }

    public void startTimer(){
        t.start();
    }
    public void stopTimer(){
        t.stop();
    }

    public void setNoMove(int noMove) {
        this.noMove = noMove;
    }

    public void paintComponent(Graphics g){
        g.drawImage(image, drawX, drawY, this);
    }

    @Override
    public String getIdentifier(){
        return "ME";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        direction = new Random().nextInt(4);

        if ( direction == 3 && noMove != 180 ) {
            setLocation(getX() - 10, getY());
            collision.setLocation(getX() - 10, getY());
        }
        if ( direction == 2 && noMove != 0 ) {
            setLocation(getX()+10,getY());
            collision.setLocation(getX() + 10, getY());
        }
        if ( direction == 0 && noMove != 90 ) {
            setLocation(getX(), getY() - 10);
            collision.setLocation(getX(), getY() - 10);
        }
        if ( direction == 1 && noMove != 270 ) {
            setLocation(getX(), getY() + 10);
            collision.setLocation(getX(), getY() + 10);
        }

        if ( frameCount == 0 ) {
            frameCount++;
            adjust(40,40);
        }
        else {
            frameCount--;
            adjust(65,32);
        }
        image = sprites[frameCount];
        repaint();
    }
}
