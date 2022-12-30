package com.bird.main;

import static com.bird.util.Constant.*;
import com.bird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird {
    //小鸟矩形：
    private  Rectangle rect;
    //小鸟的加速度
    private int accleration;

    //小鸟的生命
    public boolean life=true;
    
    //存放小鸟图片
private BufferedImage[]images;
                                            
   public static final int Brid_IMG_Count=3;
   
    //鸟的状态
    private  int State;
    public static final int STATE_NORMAL=0;
    public static final int STATE_UP=1;
    public static final int STATE_DOWN=2;

    //小鸟的位置
     private  int x=200,y=200;
    //小鸟移动方向 上下
    private boolean up=false,down=false;
    //小鸟的移动速度
    private int speed=4;
    
    //构造方法对资源的优化
    public Bird(){
             images=new BufferedImage[Brid_IMG_Count] ;
        for (int i = 0; i < Brid_IMG_Count; i++) {
            images[i]=GameUtil.loadBufferedImage(BIRD_IMG[i])  ;
        }
        int w=images[0].getWidth();
        int h=images[0].getHeight();
        rect=new Rectangle(w,h);
    }


    public void drawSlow(Graphics g){  //慢速小鸟
        flylogicSlow();
        g.drawImage(images[State],x,y,null);
        //绘制小鸟矩形
        //    g.drawRect(x,y, rect.width, rect.height);
        rect.x=this.x;
        rect.y=this.y;
    }
    //绘制小鸟
    public void draw(Graphics g){  //中速小鸟
        flylogic();
        g.drawImage(images[State],x,y,null);
        //绘制小鸟矩形
    //    g.drawRect(x,y, rect.width, rect.height);
        rect.x=this.x;
        rect.y=this.y;
    }
    //绘制加速小鸟
    public void drawSpeed(Graphics g){
        flylogicSpeed();
        g.drawImage(images[State],x,y,null);
        //绘制小鸟矩形
        //    g.drawRect(x,y, rect.width, rect.height);
        rect.x=this.x;
        rect.y=this.y;
    }
           //控制小鸟移动方向
    public void flylogic(){   //小鸟中速
        if (up){
            accleration-=2;
            y+=accleration;
            if (accleration<-10){
                accleration=-10;
            }
            if (y<45) {
                y=45;
                accleration=0;  
            }

        }
        if (!up){
            accleration+=2;
            y+= accleration;
            if (accleration>10)
            {
                accleration=10;
            }
            y+=speed;
            if (y>475)  {
                y=475;
                accleration=0;
            }

        }

    }

    public void flylogicSpeed(){     //小鸟加速
        if (up){
            accleration-=3;
            y+=accleration;
            if (accleration<-20){
                accleration=-20;
            }
            if (y<45) {
                y=45;
                accleration=0;
            }

        }
        if (!up){
            accleration+=3;
            y+= accleration;
            if (accleration>20)
            {
                accleration=20;
            }
            y+=speed;
            if (y>475)  {
                y=475;
                accleration=0;
            }

        }

    }
    public void flylogicSlow(){     //小鸟慢速
        if (up){
            accleration-=1;
            y+=accleration;
            if (accleration<-5){
                accleration=-5;
            }
            if (y<45) {
                y=45;
                accleration=0;
            }

        }
        if (!up){
            accleration+=1;
            y+= accleration;
            if (accleration>5)
            {
                accleration=5;
            }
            y+=speed;
            if (y>475)  {
                y=475;
                accleration=0;
            }

        }

    }
/*    public void ChooseSpeed(int Speed){       //速度选择
        switch (speed){
            case 0:drawSlow(Graphics g);
            break;
            case 1:flylogic();
            break;
            case 2:flylogicSpeed();
            default:
                break;
        }

    }*/
    public void  fly(int fly){
        switch (fly){
            case 1:
                State=1;
                up=true;
                break;
            case 5:
                State=2;
                up=false;
                break;

        }
        
    }

    public Rectangle getRect() {
        return rect;
    }

    /*
    * 重新绘制小鸟位置*/
    public void restartDraw(){
        life=true;
        x=200;
        y=200;
    }
}
