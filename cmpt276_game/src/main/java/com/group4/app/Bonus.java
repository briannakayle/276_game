package com.group4.app;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Bonus extends RegularRewards{
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
