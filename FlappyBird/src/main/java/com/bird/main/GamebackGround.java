package com.bird.main;

import com.bird.util.Constant;
import com.bird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.bird.util.Constant.*;

/* 游戏背景类*/
public class GamebackGround {
    //背景需要的图片资源
    private BufferedImage bking;
    //构造器初始化资源
    public GamebackGround(){
       bking= GameUtil.loadBufferedImage(Constant.BK_IMG_OATH);
    }
    //绘制图片                           
    public void draw(Graphics g) {
        //填充背景色
        g.setColor( BK_Color);
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
    
}
