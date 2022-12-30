package com.bird.main;

import com.bird.util.Constant;
import com.bird.util.GameUtil;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseLevel extends JFrame {
    JFrame frame;
    JLabel label;
    JButton easy;//无敌
    JButton normal;
    JButton hard;
   public void init(){
       frame=new JFrame("飞翔的小鸟——>CHANGE_LEVEL") ;
       label =new JLabel("请选择游戏难度",JLabel.CENTER) ;
      label.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
       easy=new JButton("无敌");
       normal=new JButton("普通");
       hard=new JButton("困难");
       frame.getContentPane().setBackground(null);    //设置背景颜色
       frame.setLayout(null);          //很重要
      // frame.setLayout(new CardLayout());
       Rectangle r=new Rectangle(Constant.FRAM_X,Constant.FRAM_Y,Constant.FRAM_WIDTH,Constant.FRAM_HEIGHTH);
       frame.setBounds(r);
       label.setBounds(200,30,200,100);
       easy.setBounds(200,130,200,100);
       normal.setBounds(200,240,200,100);
       hard.setBounds(200,350,200,100);
      //设置字体
       easy.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
       normal.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));
       hard.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,20));

       //添加组件
        frame.add(label);
        frame.add(easy);
        frame.add(normal);
        frame.add(hard);
        //添加监听器
       easy.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("easy");
               //添加gameframe
               new GameFactory().creatGameFrame(0);
               frame.dispose();
           }
       });
       normal.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("normal");
               //添加gameframe
               new GameFactory().creatGameFrame(1);
               frame.dispose();
           }
       });
       hard.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               System.out.println("hard");
               //添加gameframe
               new GameFactory().creatGameFrame(2);
               frame.dispose();
           }
       });
        frame.setBackground(new Color(240,255,255));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }

    public static void main(String[] args) {
        new ChooseLevel().init();
    }


}

