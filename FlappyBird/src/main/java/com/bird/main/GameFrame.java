package com.bird.main;

import com.bird.util.Constant;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static com.bird.util.Constant.*;

public class GameFrame extends Frame {
    //示例化参数gamebackground类
    private GamebackGround gamebackGround;
    //实例化Bird类
    private Bird bird;
    //实例化GameBarrierLayer类
    private GameBarrierLayer gameBarrierLayer;
       //示例化GameFrontGround类
    private  GameFrontGround gameFrontGround;
    //存放图片的图片
    private BufferedImage buffimg=new BufferedImage(FRAM_WIDTH,FRAM_HEIGHTH,BufferedImage.TYPE_4BYTE_ABGR);
    public GameFrame()  {
        //窗口是否可见
        setVisible(true);
        //窗口大小
        setSize(FRAM_WIDTH, FRAM_HEIGHTH);
        //窗口标题
        setTitle(FRAM_TITLE);
        //窗口的初始化位置
        setLocation(FRAM_X,FRAM_Y);
        //窗口的大小不可改变
        setResizable(false);
        //窗口的关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//结束程序
            }
        });
      //对象初始化
        initGame();
        new run().start();
        //按键监听器
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               add(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                     minu(e);
            }
        });
    }
    
    //游戏中对象初始化
    public void initGame(){
        gamebackGround=new GamebackGround();
        bird=new Bird();
        gameFrontGround=new GameFrontGround();
        gameBarrierLayer=new GameBarrierLayer();
    }
    //  
    class run extends Thread{
       @Override
      public void  run(){

           while (true) {
               repaint(); 
               try {
                   Thread.sleep(33);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
    }

    @Override
    public void update(Graphics g) {
        if (bird.life==true){
            //得到图片的画笔
            Graphics graphics = buffimg.getGraphics();
            gamebackGround.draw(graphics);
            bird.draw(graphics);
            gameFrontGround.draw(graphics);
            gameBarrierLayer.draw(graphics,bird);
            //一次性将图片绘制到屏幕中
            g.drawImage(buffimg,0,0,null);

        }else {
            String over="游戏结束";
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑",1,60));
            g.drawString(over,300,250);
              //differ与数据库中的第五名进行比较的逻辑，if>第五名则需要弹出一个窗口进行名称输入，并将名称和记录储存到数据库中，然后点击菜单栏可显示前五名的记录和名称
            String reset="Space Reset Game" ;
            g.drawString(   reset,25,350);
        }

    }
    //按键
    public void add(KeyEvent e){                
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                bird.fly(1);
                break;
            case KeyEvent.VK_SPACE:
                if (bird.life==false){
                    restart();
                }
                break;
        }
    }
    
    //抬键
    public void minu(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                bird.fly(5);
                break;
        }
    }

    /*重置游戏*/
    public void restart(){
        gameBarrierLayer.restant();
        bird.restartDraw();
    }
}
