package com.bird.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BTService {      //查询前五名记录
    public List<Bird_Time > findAll(){
        List<Bird_Time> Bird_Times=new ArrayList<>();
        //idea快速生成try..catch，快捷键crtl+alt+t
        try(Connection conn= DataBaseConnection.getConnection()) {//创建数据库连接
            String sql="select *" +
                    "from n_t_r" +
                    "order by time desc" +
                    "limit 5";//定义查询所有数据sql语句
            PreparedStatement ps=conn.prepareStatement(sql);//填充sql语句
            ResultSet rs=ps.executeQuery();//执行sql语句
            while(rs.next()){//判断数据集是否有数据
                //获取数据集中每个字段的值，实例化学生信息对象
                Bird_Time bird_Time=new Bird_Time(rs.getString(1),rs.getInt(2));
                Bird_Times.add(bird_Time);//将学生对象添加至集合
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Bird_Times;
    }
}
