package com.bird.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameSettings {
    public GameSettings() {
    }
    JFrame SP;
    JFrame CR;
    JFrame BR;
    int Speed=0;
    int color=4;
    int BCount=0;

    public static void main(String[] args) {
        GameSettings gameSettings=new GameSettings();
        ArrayList<Integer> integers = gameSettings.initGameSettings();
 /*       for (Integer integer : integers) {
            System.out.println(integer);
            System.out.println("----------");
        }*/
    }
    public ArrayList<Integer> initGameSettings(){
        ArrayList<Integer> settings=new ArrayList<>();
/*        int Speed=0;
        int color=1;
        int BCount=0;*/
       JFrame GS=new JFrame("Settings");
        GS.setSize(600,500);
        GS.setLocation(200,200);
        GS.setResizable(false);
        JLabel label=new JLabel("游戏设置",JLabel.CENTER);
        JButton j1=new JButton("Speed");
        JButton j2=new JButton("Color");
        JButton j3=new JButton("Barrier");
        JButton j4=new JButton("StartGame");
        label.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Speed=initSpeed();
                System.out.println(Speed);
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=initColor();
                System.out.println(color);
            }
        });
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               BCount= initBarrier();
                System.out.println(BCount);
            }
        });
        j4.addActionListener(new ActionListener() {    //开启新窗口
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFrameAlter2(Speed,color,BCount);
            }
        });



        GS.getContentPane().setBackground(new Color(0x4b4cf));
        GS.setLayout(null);
        label.setBounds(200,30,200,100);
        j1.setBounds(200,130,200,100);
        j2.setBounds(200,240,200,100);
        j3.setBounds(200,350,200,100);
        j4.setBounds(410,350,150,80);
        GS.add(label);
        GS.add(j1);
        GS.add(j2);
        GS.add(j3);
        GS.add(j4) ;
        GS.setVisible(true);
        settings.add(Speed);
        settings.add(color);
        settings.add(BCount);
        //settings.g
        for (Integer setting : settings) {
            System.out.println(setting);
            System.out.println("\\\\");
        }
        return settings;
    }

    public int initSpeed() {

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
        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Speed=0;
                SP.dispose();
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Speed=1;
                SP.dispose();
            }
        });
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Speed=2;
               SP.dispose();
            }
        });

        return Speed;
    }
    public int initColor(){
        CR=new JFrame("BackgroudColor");
        CR.setSize(600,500);
        CR.setLocation(200,200);
        CR.setResizable(false);
        CR.setLayout(null);
        JLabel label=new JLabel("背景颜色",JLabel.CENTER);
        CR.getContentPane().setBackground(new Color(0x4b4cf));
        JButton j1=new JButton("深空黑");
        JButton j2=new JButton("天空蓝");
        JButton j3=new JButton("雾霾绿");
        JButton j4=new JButton("国旗红");
        JButton j5=new JButton("小麦黄");
        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=1;
                CR.dispose();
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=2;
                CR.dispose();
            }
        });
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=3;
                CR.dispose();
            }
        });
        j4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=4;
                CR.dispose();
            }
        });
        j5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=5;
                CR.dispose();
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
        return color;
    }
    public int initBarrier(){
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
                BR.dispose();
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BCount=1;
                BR.dispose();
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
        return BCount;
    }
}
