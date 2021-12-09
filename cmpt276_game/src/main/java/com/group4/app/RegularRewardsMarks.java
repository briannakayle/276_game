package com.group4.app;


public class RegularRewardsMarks {
    private int mark = 1;
    private int realMark=1;
    public int getmarks(){
        return mark;
    }
    public int getrealMarks(){
        return realMark;
    }
    public void addRRrealmark(AppWindow window){
        window.updateRealTracker(realMark);


    }
    public void addRRmark(AppWindow window){
        window.updateRealTracker(mark);
    }
}
