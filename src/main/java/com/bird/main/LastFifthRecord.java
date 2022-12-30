package com.bird.main;

import com.bird.dao.BTService;
import com.bird.dao.Bird_Time;
import com.bird.dao.DataBaseConnection;
import com.bird.dao.RandomData;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class LastFifthRecord extends JFrame {
    TextArea textshow;
    //ReadListen listen1;
    public LastFifthRecord() throws HeadlessException {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
       @Test
    public void init(){
        setBounds(100,100,310,260);
        setTitle("前五名记录");
        textshow=new TextArea(9,30);
        BTService btService = new BTService();
        List<Bird_Time> all = btService.findAll();
        int i=1;
        textshow.append("排名：  "+"存活时间:     "+"昵称:\n");
        for (Bird_Time bird_time : all) {

            textshow.append("第"+i+"名"+":  "+bird_time.getTime()+"秒              "+bird_time.getName()+"\n");
            i++;
        }
        textshow.setEditable(false);
        add(new JScrollPane(textshow));
    }

}
/*class ReadListen implements ActionListener{ //将从数据库中提取的集合输出到textshow中
    TextArea textshow;

    public void setTextshow(TextArea textshow) {
        this.textshow = textshow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BTService btService = new BTService();
        List<Bird_Time> all = btService.findAll();
        int i=1;
        textshow.append("排名：   "+"昵称：   "+"存活时间：");
        for (Bird_Time bird_time : all) {

                  textshow.append("第"+i+"名"+":  "+bird_time.getName()+"         "+bird_time.getTime()+"秒\n");
                  i++;
        }
        textshow.setEditable(false);
    }
}*/
