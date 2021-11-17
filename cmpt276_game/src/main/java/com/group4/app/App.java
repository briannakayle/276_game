package com.group4.app;

import javax.swing.*;

class AppWindow extends JFrame{

    private Board currentBoard;
    private scoreTracker sTracker;
    private timeTracker tTracker;

    public void setBoard(boardHolder target){
        if ( currentBoard != null ) {
            currentBoard.stopTimer();
        }
        currentBoard = target.getHeld();
        currentBoard.startTimer();
    }

    public void addBoard(boardHolder target){
        add(target);
        target.getHeld().setWindow(this);
    }

    public void updateScoreTracker(int i){
        sTracker.addMarks(i);
    }

    public AppWindow(){
        JPanel content = new JPanel();
        setContentPane(content);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1024,880);
        setVisible(true);
        sTracker = new scoreTracker();
        add(sTracker.getHolder());
        tTracker = new timeTracker();
        add(tTracker.getHolder());

    }

    public static void main(String[] args) throws InterruptedException {
        AppWindow window = new AppWindow();

        character Player = new character();

        Board board1 = new Board(null,null,null,null,window);  //1,2
        board1.addPlayer(Player);

        boardHolder level_1 = new boardHolder(board1);


        board1.addSlotComponent("door","top");
        board1.addSlotComponent("wall","bottom");
        board1.addSlotComponent("door","right");
        board1.addSlotComponent("wall","left");
        board1.addBarrier(0,2);
        board1.addBarrier(1,2);
        board1.addBarrier(2,5);
        board1.addBarrier(2,6);
        board1.addBarrier(3,0);
        board1.addBarrier(3,1);
        board1.addBarrier(5,3);
        board1.addBarrier(5,4);
        board1.addBarrier(6,3);
        board1.addBarrier(7,2);
        board1.addBarrier(7,3);
        board1.addBarrier(8,3);
        board1.addBarrier(8,4);
        board1.addBarrier(8,5);
        board1.addBarrier(10,0);
        board1.addBarrier(10,1);
        board1.addBarrier(10,5);
        board1.addBonus(11,0);
        board1.addBarrier(11,5);
        board1.addRegularRewards(3,3);
        board1.addNonAnimatedEnemy(0,0);


        Board board2 = new Board(null,level_1,null,null,window);    //1,1

        boardHolder level_2 = new boardHolder(board2);
        board1.setUp(level_2);

        board2.addSlotComponent("wall","top");
        board2.addSlotComponent("door","bottom");
        board2.addSlotComponent("wall","right");
        board2.addSlotComponent("wall","left");
        board2.addBarrier(2,2);
        board2.addRegularRewards(4,4);

        Board board3 = new Board(null,null,null,level_1,window);    //1,1

        boardHolder level_3 = new boardHolder(board3);
        board1.setRight(level_3);

        board3.addSlotComponent("wall","top");
        board3.addSlotComponent("wall","bottom");
        board3.addSlotComponent("wall","right");
        board3.addSlotComponent("door","left");
        board3.addBarrier(11,6);

        window.addBoard(level_1);
        window.repaint();
        window.setBoard(level_1);

    }
}