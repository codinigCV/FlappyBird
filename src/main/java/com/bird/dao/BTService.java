package com.bird.dao;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public  class BTService<K> {      //查询前五名记录                ,运用了泛型
    public  List<Bird_Time > findAll(){
        List<Bird_Time> Bird_Times=new ArrayList<>();
        //idea快速生成try..catch，快捷键crtl+alt+t
        try(Connection conn= DataBaseConnection.getConnection()) {//创建数据库连接
            String sql= "select * from n_t_r order by time desc limit 5" ;//定义查询所有数据sql语句
            PreparedStatement ps=conn.prepareStatement(sql);//填充sql语句
            ResultSet rs=ps.executeQuery();//执行sql语句
            while(rs.next()){//判断数据集是否有数据
                //获取数据集中每个字段的值，实例化学生信息对象
                Bird_Time bird_Time=new Bird_Time(rs.getString(1),rs.getInt(2));
                Bird_Times.add(bird_Time);//将学生对象添加至集合
              //  System.out.println(bird_Time.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Bird_Times;
    }
    public void insertRecord (K name ,int time){   //插入记录到表中

        try (Connection conn = DataBaseConnection.getConnection()) {
            String sql="insert ignore into  n_t_r ( name ,time ) values (?,?)";//可使用idea的database面板快速生成sql语句
            PreparedStatement pstmt = conn.prepareStatement(sql);//实例化PreparedStatement对象
                pstmt.setString(1,(String) name);
                pstmt.setInt(2, time);
                pstmt.addBatch();//加入批处理等待执行
            pstmt.executeBatch();//批量执行sql语句
            System.out.println("data insert succssesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
