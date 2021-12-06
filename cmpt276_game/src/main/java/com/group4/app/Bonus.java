package com.group4.app;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Bonus extends RegularRewards{

    /**
     * Bonus point that gives the player 3 points. These 3 points do not go towards
     * the player's progress in the game, but serve as a padding to their score to
     * make them feel better.
     */

    public Bonus(int x, int y) {
        super(x, y);
        try {
            image = ImageIO.read(new File("src/main/resources/bonus.PNG"));
        }catch (IOException e) { System.out.println("Bonus Sprite not found"); }

    }

    @Override
    public String getIdentifier() {
        return "BR";
    }
}
