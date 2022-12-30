package com.bird.main;

import com.bird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* 游戏的前景类*/
public class GameFrontGround {
    //云彩的个数
    private static final int CLOUD_COUNT=2;
    //云彩的容器
    private List<CLoud>cLouds;
    //云彩的飞行速度
    private static final int CLOUD_SPEED=1;
    //使用到的图片资源
    private BufferedImage[] img;
    //用于产生随机数
    private Random random;
     //构造器初始化数据
    public GameFrontGround() {
        cLouds=new ArrayList<>();
        img=new BufferedImage[CLOUD_COUNT];
        //容器中添加云彩图片
        for (int i = 0; i < CLOUD_COUNT; i++) {
           img[i]= GameUtil.loadBufferedImage("img/cloud"+i+".png") ;
        }
        random=new Random();
    }

    //绘制云彩
    public void draw(Graphics g) {
/*        CLoud cLoud = new CLoud(img[1], CLOUD_SPEED, 300, 300);
        cLouds.add(cLoud);*/
        logic();
        for (int i = 0; i < cLouds.size(); i++) {
            cLouds.get(i).draw(g);
        }

    }

    /*用于云彩的个数控制*/
    private void logic() {
        if ((int)500*Math.random()<5)
        {
            CLoud cLoud = new CLoud(img[random.nextInt(CLOUD_COUNT)], CLOUD_SPEED, 600, random.nextInt(150));
            cLouds.add(cLoud);
        }
        for (int i = 0; i <cLouds.size() ; i++) {
            CLoud cLoud=cLouds.get(i);
            if (cLoud.isOutFrame()){
                cLouds.remove(i);
                i--;
                System.out.println("cloud has been removed "+cLoud);
            }
        }
    }


}
