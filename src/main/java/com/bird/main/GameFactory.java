package com.bird.main;

public class GameFactory {      //簡單的工場模式
    int easy=0;
    int normal=1;
    int hard=2;
    void creatGameFrame(int level){
        switch (level){
            case 0:
                new GameFrameEasy();          //先改一下
                break;
            case 1:
                new GameFrame2();
                break;
            case 2:
                new GameFrameHard();
                break;
            default:
                break;
        }
    }
}
