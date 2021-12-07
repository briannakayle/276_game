package com.group4.app;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

class RegularRewards extends Collectible{

    /**
     * The main points that are found scattered across the maze, that increment the player's Marks and realMarks
     * by 1. The player must collect all 17 to win the game.
     */

    public RegularRewards(int x, int y){
        super(x, y);
        try {
            image = ImageIO.read((getClass().getResourceAsStream("/point.png")));
        } catch(IOException e){ System.out.println("Point Sprite source not found"); }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 16, 0, this);
    }

    @Override
    public String getIdentifier() {
        return "RR";
    }
}
