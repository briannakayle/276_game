package com.group4.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Board extends JLayeredPane implements ActionListener {
    private boardHolder up, down, left, right, Holder;
    private BufferedImage BaseBoard;
    private AppWindow window;
    private int bonusTicker = 0;
    private int bX, bY;
    private character player;
    private final entity[][] grid = new entity[12][7];
    /*
     * INDICES:
     * [0] = TOP SLOT
     * [1] = BOTTOM SLOT
     * [2] = RIGHT SLOT
     * [3] = LEFT SLOT
     * */
    private ArrayList<slotComponent> slots = new ArrayList<>(4);
    private final Timer t;

    private final collisionBox[] baseCollisionBoxes = new collisionBox[8];

    public void setWallBounds(){
        baseCollisionBoxes[0] = new collisionBox(577,177,320,128);  //right top hor
        baseCollisionBoxes[1] = new collisionBox(902,305,128,160);  //right top vert
        baseCollisionBoxes[2] = new collisionBox(577,753,320,128);  //right bottom hor
        baseCollisionBoxes[3] = new collisionBox(896,592,128,160);  //right bottom vert
        baseCollisionBoxes[4] = new collisionBox(129,177,320,128);  //left top hor
        baseCollisionBoxes[5] = new collisionBox(1,305,128,160);    //left top vert
        baseCollisionBoxes[6] = new collisionBox(129,753,320,128);  //left bottom hor
        baseCollisionBoxes[7] = new collisionBox(1,593,128,160);    //left bottom vert
    }

    public Board(boardHolder setUp, boardHolder setDown, boardHolder setRight, boardHolder setLeft, AppWindow setWindow){
        up = setUp; down = setDown; right = setRight; left = setLeft; window = setWindow;
        try {
            BaseBoard = ImageIO.read(new File("src/main/resources/BaseBoardFloor.PNG"));
        } catch(IOException e){ System.out.println("Walls/floor Sprite source not found"); }
        setSize(1024,880);
        setWallBounds();
        setDoubleBuffered(true);
        setOpaque(false);
        setFocusable(false);
        t = new Timer(1, this);
    }

    public void setUp(boardHolder up){
        this.up = up;
    }
    public void setDown(boardHolder down){
        this.down = down;
    }
    public void setRight(boardHolder right){
        this.right = right;
    }
    public void setLeft(boardHolder left){
        this.left = left;
    }

    public void addPlayer(character target){
        add(target,0);
        player = target;
    }

    public void setHolder(boardHolder target){
        Holder = target;
    }

    public void stopTimer(){
        t.stop();
    }

    public void startTimer(){
        t.start();
    }

    public void addSlotComponent(String comp, String pos){
        slotComponent component = new slotComponent(comp, pos);
        add(component,2);
        slots.add(component);
        repaint();
    }

    public void addBarrier(int x, int y){
        grid[x][y] = new Barrier((x*64)+128,(y*64)+304);
        add(grid[x][y]);
        grid[x][y].repaint();
    }

    public void addRegularRewards(int x, int y){
        grid[x][y] = new RegularRewards((x*64)+128,(y*64)+304);
        add(grid[x][y]);
        grid[x][y].repaint();
    }

    public void addBonus(int x, int y){
        grid[x][y] = new Bonus((x*64)+128,(y*64)+304);
        add(grid[x][y]);
        grid[x][y].repaint();
        bX = x; bY = y;
    }

    public void addNonAnimatedEnemy(int x, int y){
        grid[x][y] = new NonAnimatedEnemy((x*64)+128,(y*64)+304);
        add(grid[x][y]);
        grid[x][y].repaint();
    }

    public void setWindow(AppWindow window){
        this.window = window;
    }

    private void change(boardHolder Dir, int x, int y){
        remove(player);
        window.remove(Holder);
        window.add(Dir);
        window.setBoard(Dir);
        Dir.getHeld().addPlayer(player);
        player.setLocation(x,y);
        player.refresh();
        Dir.repaint();
    }

    private void collectPoint(int i, int j, String identifier){
        if ( identifier.equals("RR") )
            window.updateScoreTracker(1);
        if ( identifier.equals("BR") )
            window.updateScoreTracker(3);
        if ( identifier.equals("NAA") ){
            window.updateScoreTracker(-1);
        }
        remove(grid[i][j]);
        grid[i][j] = null;
        repaint();
    }

    private void removeBonus(){
        if ( grid[bX][bY] != null ) {
            remove(grid[bX][bY]);
            grid[bX][bY] = null;
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BaseBoard, 0, 0, this);
    }

    private int checkCollision(){
        RegularRewards test1 = null;
        NonAnimatedEnemy test2 = null;
        collisionBox projectedBox = new collisionBox(player.getX(),player.getY(),64,64);
        int x = (int)projectedBox.getX();
        int y = (int)projectedBox.getY();

        if (player.getDirection() == 180)
            projectedBox.setLocation(x - 10, y);
        if (player.getDirection() == 0)
            projectedBox.setLocation(x + 10, y);
        if (player.getDirection() == 270)
            projectedBox.setLocation(x, y + 10);
        if (player.getDirection() == 90)
            projectedBox.setLocation(x, y - 10);

        for ( int i = 0; i<8; i++ ) {
            if (projectedBox.intersects(baseCollisionBoxes[i])) {
                return i;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (projectedBox.intersects(slots.get(i).getCollision())){
                if ( slots.get(i).getType().equals("door") ) {
                    t.stop();
                    if (slots.get(i).getPosition().equals("top"))
                        change(up,490,700);
                    if (slots.get(i).getPosition().equals("bottom"))
                        change(down,490,285);
                    if (slots.get(i).getPosition().equals("right"))
                        change(right,100,495);
                    if (slots.get(i).getPosition().equals("left"))
                        change(left,855,495);
                }
                else
                    return (i + 1) * 10;
            }
        }
        for ( int i = 0; i < 12; i++ ){
            for ( int j = 0; j < 7; j++ ){
                try {
                    if (projectedBox.intersects(grid[i][j].getCollision()))
                        try {
                            test1 = (RegularRewards)grid[i][j];
                            collectPoint(i,j,test1.getIdentifier());
                        }catch(ClassCastException e1){ return player.getDirection() + 15; }
                }catch (NullPointerException ignored){}
            }
        }
        return -1;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        bonusTicker++;
        if ( bonusTicker >= 15000 ){
            removeBonus();
        }
        if ( player != null ) {
            int colDir = checkCollision();
            if (colDir != -1) {
                if (colDir == 0) {
                    if (player.getY() >= 304)
                        player.setNoMove(90);
                    else
                        player.setNoMove(0);
                }
                if (colDir == 4) {
                    if (player.getY() >= 304)
                        player.setNoMove(90);
                    else
                        player.setNoMove(180);
                }
                if (colDir == 2) {
                    if (player.getY() >= 699) {
                        player.setNoMove(0);
                    }
                    else {
                        player.setNoMove(270);
                    }
                }
                if (colDir == 6) {
                    if (player.getY() >= 699)
                        player.setNoMove(180);
                    else
                        player.setNoMove(270);
                }
                if (colDir == 5) {
                    if (player.getX() <= 128)
                        player.setNoMove(90);
                    else
                        player.setNoMove(180);
                }
                if (colDir == 7) {
                    if (player.getX() <= 128)
                        player.setNoMove(270);
                    else
                        player.setNoMove(180);
                }
                if (colDir == 1) {
                    if (player.getX() >= 850) {
                        player.setNoMove(90);
                    }
                    else {
                        player.setNoMove(0);
                    }
                }
                if (colDir == 3) {
                    if (player.getX() >= 850)
                        player.setNoMove(270);
                    else {
                        player.setNoMove(0);
                    }
                }
                if ( colDir == 10 || colDir == 105 ) {
                    player.setNoMove(90);
                }
                if ( colDir == 20 || colDir == 285) {
                    player.setNoMove(270);
                }
                if ( colDir == 30 || colDir == 15) {
                    player.setNoMove(0);
                }
                if ( colDir == 40 || colDir == 195 ){
                    player.setNoMove(180);
                }
            } else
                player.setNoMove(-1);
        }
    }
}
