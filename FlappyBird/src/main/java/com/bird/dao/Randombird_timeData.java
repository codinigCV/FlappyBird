package com.bird.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Randombird_timeData {
    public static void main(String[] args) {
        try (Connection conn = DataBaseConnection.getConnection()) {
            String sql="insert ignore into  n_t_r ( name ,time ) values (?,?)";//可使用idea的database面板快速生成sql语句
            PreparedStatement pstmt = conn.prepareStatement(sql);//实例化PreparedStatement对象
            for (int i = 0; i < 300; i++) {//生成300条数据
                pstmt.setString(1,RandomData.getChineseName());
                pstmt.setInt(2,RandomData.gettime());

                pstmt.addBatch();//加入批处理等待执行
            }
            pstmt.executeBatch();//批量执行sql语句
            System.out.println("数据批量生成完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
                