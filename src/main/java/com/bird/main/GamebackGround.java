package com.bird.main;

import com.bird.util.Constant;
import com.bird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static com.bird.util.Constant.*;
import static java.lang.Thread.sleep;

/* 游戏背景类*/
public class GamebackGround {
    //背景需要的图片资源
    private BufferedImage bking;
    //构造器初始化资源
    public GamebackGround(){
       bking= GameUtil.loadBufferedImage(Constant.BK_IMG_OATH);
    }
    //绘制图片          ，三种不同的颜色对应3个不同的难度
    public void drawHard(Graphics g) throws Exception {
        //填充背景色
        Random r=new Random();
        g.setColor( BK_Color1);
       // g.setColor(new Color(r.nextInt(10),r.nextInt(240,250),r.nextInt(240,250)));
        g.fillRect(0,0,FRAM_WIDTH,FRAM_HEIGHTH);
        g.setColor(Color.black);

        //得到图片的高度和宽度
        int height=bking.getHeight();
        int widtht=bking.getWidth();
        //图片的张数 (循环的次数)
        int count=Constant.FRAM_WIDTH/widtht+1;
        for (int i=0;i<count;i++){
            g.drawImage(bking,widtht*i,Constant.FRAM_HEIGHTH-height,null);
        }
        
    }
    public void drawNormal(Graphics g) {
        //填充背景色
        Random r=new Random();
        g.setColor( BK_Color2);
        //g.setColor(new Color(r.nextInt(10),r.nextInt(240,250),r.nextInt(240,250)));
        g.fillRect(0,0,FRAM_WIDTH,FRAM_HEIGHTH);
        g.setColor(Color.black);

        //得到图片的高度和宽度
        int height=bking.getHeight();
        int widtht=bking.getWidth();
        //图片的张数 (循环的次数)
        int count=Constant.FRAM_WIDTH/widtht+1;
        for (int i=0;i<count;i++){
            g.drawImage(bking,widtht*i,Constant.FRAM_HEIGHTH-height,null);
        }


    }
    public void draw(Graphics g) {  //easy
        //填充背景色
        Random r=new Random();
        g.setColor( BK_Color3);
        //g.setColor(new Color(r.nextInt(10),r.nextInt(240,250),r.nextInt(240,250)));
        g.fillRect(0,0,FRAM_WIDTH,FRAM_HEIGHTH);
        g.setColor(Color.black);

        //得到图片的高度和宽度
        int height=bking.getHeight();
        int widtht=bking.getWidth();
        //图片的张数 (循环的次数)
        int count=Constant.FRAM_WIDTH/widtht+1;
        for (int i=0;i<count;i++){
            g.drawImage(bking,widtht*i,Constant.FRAM_HEIGHTH-height,null);
        }  }
}
