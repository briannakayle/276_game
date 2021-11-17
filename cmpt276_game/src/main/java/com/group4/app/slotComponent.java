package com.group4.app;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class slotComponent extends entity{
    private final String type;
    private final String position;
    int wall_x = 0; int wall_y = 0; int door_x = 0; int door_y = 0;

    public slotComponent(String comp, String pos){
        type = comp; position = pos;
        try {
            if ( pos.equals("left" )){
                wall_x = 0; wall_y = 464;
                door_x = 64; door_y = 464;
                if ( comp.equals("wall") ) {
                    image = ImageIO.read(new File("src/main/resources/slotWallLeft.PNG"));
                    collision = new collisionBox(wall_x+64,wall_y,64,64);
                }
                if ( comp.equals("door") ) {
                    image = ImageIO.read(new File("src/main/resources/slotDoorLeft.PNG"));
                    collision = new collisionBox(door_x,door_y,6,64);
                }
            }
            if ( pos.equals("right") ){
                wall_x = 896; wall_y = 464;
                door_x = 967; door_y = 464;
                if ( comp.equals("wall") ) {
                    image = ImageIO.read(new File("src/main/resources/slotWallRight.PNG"));
                    collision = new collisionBox(wall_x,wall_y,64,64);
                }
                if ( comp.equals("door") ) {
                    image = ImageIO.read(new File("src/main/resources/slotDoorRight.PNG"));
                    collision = new collisionBox(door_x,door_y,6,64);
                }
            }
            if ( pos.equals("top") ){
                wall_x = 448; wall_y = 176;
                door_x = 447; door_y = 239;
                if ( comp.equals("wall") ) {
                    image = ImageIO.read(new File("src/main/resources/slotWallTop.PNG"));
                    collision = new collisionBox(wall_x,wall_y+64,64,64);
                }
                if ( comp.equals("door") ) {
                    image = ImageIO.read(new File("src/main/resources/slotDoorTop.PNG"));
                    collision = new collisionBox(door_x,door_y,64,6);
                }
            }
            if ( pos.equals("bottom") ){
                wall_x = 448; wall_y = 752;
                door_x = 448; door_y = 827;
                if ( comp.equals("wall") ) {
                    image = ImageIO.read(new File("src/main/resources/slotWallBottom.PNG"));
                    collision = new collisionBox(wall_x,wall_y,64,64);
                }
                if ( comp.equals("door") ) {
                    image = ImageIO.read(new File("src/main/resources/slotDoorBottom.PNG"));
                    collision = new collisionBox(door_x,door_y,64,6);
                }
            }
            setLocation(wall_x,wall_y);
        } catch(IOException e){ System.out.println("wall slot source not found"); }
        setSize(128,128);
        setDoubleBuffered(true);
        repaint();
    }
    public String getType(){
        return type;
    }
    public String getPosition(){
        return position;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public String toString(){
        return position + " " + type;
    }
}
