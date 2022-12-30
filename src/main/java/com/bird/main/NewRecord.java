package com.bird.main;

import com.bird.dao.BTService;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewRecord {
     GameTime gameTime=new GameTime();
     BTService btService=new BTService();

    void init( long differ){
        Action listen=new Action();
        JFrame frame=new JFrame("新纪录！！！");
        JTextField name= new JTextField(30);
        JTextField noed=new JTextField(differ+"秒",10);
        JLabel namelab=new JLabel("昵称");
        JLabel noedlab=new JLabel("新记录");
        JButton button=new JButton("保存");
        noed.setEnabled(false);
        namelab.setBounds(10,10,100,20);
        noedlab.setBounds(10,40,100,20);
        name.setBounds(110,10,80,20);
        noed.setBounds(110,40,80,20);
        button.setBounds(200,10,70,20);
        frame.setLayout(null);
        frame.add(namelab);
        frame.add(name);
        frame.add(noed);
        frame.add(noedlab);
        frame.add(button) ;
        frame.setSize(300,100);
        frame.setLocation(300,200);
        frame.setVisible(true);
    /*    name.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              String TXT=name.getText();    //   有问题
              System.out.println(TXT);
           }
        });*/

        listen.setButton(button);
        listen.setName(name);
        listen.setBtService(btService);
        listen.setDiffer(differ);
        button.addActionListener(listen);
        name.addActionListener(listen);

    }

}
class  Action implements ActionListener {
    JButton button;
    JTextField name;
    BTService btService;
    long differ;
    public void setButton(JButton button) {
        this.button = button;
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public void setBtService(BTService<String> btService) {
        this.btService = btService;
    }

    public void setDiffer(long differ) {
        this.differ = differ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String TXT=name.getText();
 /*     while (TXT==null)//   有问题
      {
         System.out.println("重新输入");
         break;
      }*/  //是否空值也是名字
        System.out.println(TXT);
        btService.insertRecord(TXT,(int) differ);
        JFrame f = new JFrame("提示");
        JLabel lab=new JLabel("已保存!!!",JLabel.CENTER);
        Dimension dim=new Dimension();
        dim.setSize(300,80);
        f.setSize(dim);
        f.setBackground(Color.BLUE);
        Point p=new Point(300,500) ;
        f.setLocation(p);
        f.add(lab);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
