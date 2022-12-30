package com.bird.main;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static com.bird.util.Constant.*;

public class GameFrameAlter extends Frame {
    private GamebackGround gamebackGround;
    //实例化Bird类
    private Bird bird;
    //实例化GameBarrierLayerAlter类
    private GameBarrierLayerAlter gameBarrierLayerAlter;
    //示例化GameFrontGround类
    private  GameFrontGround gameFrontGround;
    //存放图片的图片
    private BufferedImage buffimg=new BufferedImage(FRAM_WIDTH,FRAM_HEIGHTH,BufferedImage.TYPE_4BYTE_ABGR);
    public JFrame GS;//GameSettings
    public JFrame SP;//speed
    public JFrame BR;//Barrier
    public JFrame CR;//Color
    public int Speed=0;
    public int color=1;
    public int BCount=0;//障碍物数量
    public GameSettings gameSettings;
    public ArrayList<Integer> settings;  //speed,color,Bcount

    public GameFrameAlter()  {   //构造器
        //设置 菜单栏
        MenuBar menubar;
        Menu menu, subMenu;
        MenuItem item1, item2;
        menubar=new MenuBar();
        menu=new Menu("MainMENU");
        /*
         *  一级菜单*/
        subMenu =new Menu("changeLevel");
        item1=new MenuItem("Record");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //响应菜单记录窗口
                new LastFifthRecord();
            }
        });
        item2=new MenuItem("GameSettings");   //游戏设置
        menu.add(item1);
        menu.add(item2);
        menu.addSeparator();
        menu.add(subMenu);
        /*
         * 添加二级菜单项*/        //更改游戏level
        MenuItem easy = new MenuItem("easy");
        MenuItem normal = new MenuItem("normal");
        MenuItem hard = new MenuItem("hard");
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFactory().creatGameFrame(0);
                dispose();
            }
        });
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFactory().creatGameFrame(1);
                dispose();
            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFactory().creatGameFrame(2);
                dispose();
            }
        });
        subMenu.add(easy); //添加二级菜单组件
        subMenu.addSeparator();
        subMenu.add(normal);
        subMenu.addSeparator();
        subMenu.add(hard);
        menubar.add(menu);
        setMenuBar(menubar);

        //添加GameSettings的触发器
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 gameSettings=new GameSettings();
                settings= gameSettings.initGameSettings();
                //initGameSettings();
                dispose();
            }
        });


        //窗口是否可见
        setVisible(true);
        //窗口大小
        setSize(FRAM_WIDTH, FRAM_HEIGHTH);
        //窗口标题
        setTitle(FRAM_TITLE_EASY);
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
        gameBarrierLayerAlter=new GameBarrierLayerAlter();
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
            gamebackGround.drawAlter(graphics,settings.get(1));
            switch (settings.get(0)){ //更改小鸟速度
                case 0:bird.drawSlow(graphics);
                    break;
                case 1:bird.draw(graphics);
                    break;
                case 2:bird.drawSpeed(graphics);
            }
            // bird.draw(graphics);
            gameFrontGround.draw(graphics);
            gameBarrierLayerAlter.draw(graphics,bird,settings.get(2));
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
        gameBarrierLayerAlter.restant();
        bird.restartDraw();
    }
    //初始化GameSettings
    public void initGameSettings(){
        GS=new JFrame("Settings");
        GS.setSize(600,500);
        GS.setLocation(200,200);
        GS.setResizable(false);
        JLabel label=new JLabel("游戏设置",JLabel.CENTER);
        JButton j1=new JButton("Speed");
        JButton j2=new JButton("Color");
        JButton j3=new JButton("Barrier");
        label.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initSpeed();
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initColor();
            }
        });
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initBarrier();
            }
        });
        GS.getContentPane().setBackground(new Color(0x4b4cf));
        GS.setLayout(null);
        label.setBounds(200,30,200,100);
        j1.setBounds(200,130,200,100);
        j2.setBounds(200,240,200,100);
        j3.setBounds(200,350,200,100);
        GS.add(label);
        GS.add(j1);
        GS.add(j2);
        GS.add(j3);
        GS.setVisible(true);

    }
    public void initSpeed(){
        SP=new JFrame("Speed");
        SP.setSize(600,500);
        SP.setLocation(200,200);
        SP.setResizable(false);
        JLabel label=new JLabel("移动速度",JLabel.CENTER);
        JButton j1=new JButton("慢速");
        JButton j2=new JButton("中速");
        JButton j3=new JButton("快速");
        label.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Speed=0;
                dispose();
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Speed=1;
                dispose();
            }
        });
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Speed=2;
                dispose();
            }
        });
        SP.getContentPane().setBackground(new Color(0x4b4cf));
        SP.setLayout(null);
        label.setBounds(200,30,200,100);
        j1.setBounds(200,130,200,100);
        j2.setBounds(200,240,200,100);
        j3.setBounds(200,350,200,100);

        SP.add(label);
        SP.add(j1);
        SP.add(j2);
        SP.add(j3);
        SP.setVisible(true);

    }
    public void initColor(){
        CR=new JFrame("BackgroudColor");
        CR.setSize(600,500);
        CR.setLocation(200,200);
        CR.setResizable(false);
        CR.setLayout(null);
        JLabel label=new JLabel("背景颜色",JLabel.CENTER);
        CR.getContentPane().setBackground(new Color(0x4b4cf));
        JButton j1=new JButton("天空蓝");
        JButton j2=new JButton("深空黑");
        JButton j3=new JButton("雾霾绿");
        JButton j4=new JButton("国旗红");
        JButton j5=new JButton("小麦黄");
        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=1;
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=2;
            }
        });
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=3;
            }
        });
        j4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=4;
            }
        });
        j5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=5;
            }
        });
        label.setBounds(200,10,150,50);
        j1.setBounds(200,70,150,50);
        j2.setBounds(200,130,150,50);
        j3.setBounds(200,190,150,50);
        j4.setBounds(200,250,150,50);
        j5.setBounds(200,310,150,50);
        CR.add(label);
        CR.add(j1);
        CR.add(j2);
        CR.add(j3);
        CR.add(j4);
        CR.add(j5);
        CR.setVisible(true);

    }
    public void initBarrier(){
        BR=new JFrame("BarrierCounts");
        BR.setSize(600,500);
        BR.setLocation(200,200);
        BR.setResizable(false);
        JLabel label=new JLabel("障碍物数量",JLabel.CENTER);
        JButton j1=new JButton("中等");
        JButton j2=new JButton("大量");
        //  JButton j3=new JButton("快速");
        label.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        //   j3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        BR.getContentPane().setBackground(new Color(0x4b4cf));
        BR.setLayout(null);
        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BCount=0;
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BCount=1;
            }
        });
        label.setBounds(200,30,200,100);
        j1.setBounds(200,130,200,100);
        j2.setBounds(200,240,200,100);
        //j3.setBounds(200,350,200,100);

        BR.add(label);
        BR.add(j1);
        BR.add(j2);
        // f.add(j3);
        BR.setVisible(true);
    }
}
