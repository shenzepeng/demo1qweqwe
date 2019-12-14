package com.eq1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;
/**
 * @Auther: szp
 * @Date: 2019/12/14 22:09
 * @Description: 沈泽鹏写点注释吧
 */
public class OpMysql {
    //用哪类去操作mysql
    private static final String DRIVER="com.mysql.jdbc.Driver";
    //连接的数据库，结构是 协议+ip地址+端口号+数据库名
    private static final String URL="jdbc:mysql://101.132.33.149:3306/shenzepeng";
    //数据库的用户名
    private static final String USERNAME="root";
    //密码
    private static final String PASSWORD="123456";

    /**
     * 添加
     */
    public static void insert(){
        String sql="INSERT INTO t_file(username,filename) VALUES ('username','filename')";
        Connection connection=null;
        Statement statement=null;

        try {
            //加载驱动   将连接的类实例化
            Class.forName(DRIVER);
            //获取连接的对象
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //获取执行的对象
            statement=connection.createStatement();
            int executeUpdate = statement.executeUpdate(sql);
            System.out.println("修改完毕几条:  "+executeUpdate);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                statement.close();
                connection.close();
            }catch (Exception e){
                System.out.println(e);
            }

        }

    }

    public static void update(){
        String sql="UPDATE t_file SET filename ='asd' WHERE username='username'";
        Connection connection=null;
        Statement statement=null;

        try {
            //加载驱动   将连接的类实例化
            Class.forName(DRIVER);
            //获取连接的对象
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //获取执行的对象
            statement=connection.createStatement();
            int executeUpdate = statement.executeUpdate(sql);
            System.out.println("修改完毕几条:  "+executeUpdate);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                statement.close();
                connection.close();
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }

    public static void delete(){
        String sql="DELETE from t_file where id=10";
        Connection connection=null;
        Statement statement=null;

        try {
            //加载驱动   将连接的类实例化
            Class.forName(DRIVER);
            //获取连接的对象
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //获取执行的对象
            statement=connection.createStatement();
            int executeUpdate = statement.executeUpdate(sql);
            System.out.println("修改完毕几条:  "+executeUpdate);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                statement.close();
                connection.close();
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }

    public static void find(){
        String sql="SELECT * FROM t_file";
        Connection connection=null;
        Statement statement=null;

        try {
            //加载驱动   将连接的类实例化
            Class.forName(DRIVER);
            //获取连接的对象
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //获取执行的对象
            statement=connection.createStatement();
            //查询操作
            ResultSet resultSet = statement.executeQuery(sql);
            List<Tfile> list=new ArrayList<Tfile>();

            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String filename=resultSet.getString("filename");
                //每次添加一个新的对象
                Tfile tfile=new Tfile();
                tfile.setId(id);
                tfile.setUsername(username);
                tfile.setFilename(filename);
                list.add(tfile);
            }
            System.out.println(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                statement.close();
                connection.close();
            }catch (Exception e){
                System.out.println(e);
            }

        }

    }
    public static void main(String[] args) {
//        for (int i=0;i<10;i++){
//            OpMysql.insert();
//        }
        //OpMysql.update();
//        OpMysql.delete();
        OpMysql.find();
    }

}
