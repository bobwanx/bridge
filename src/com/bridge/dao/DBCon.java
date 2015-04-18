package com.bridge.dao;
import java.sql.*;

/**
 * 连接数据库的类，获得数据库连接
 * @author Administrator
 *
 */
public class DBCon {
	private static java.sql.Connection instance=null;
	public static Connection getInstance(){
		try{	
			Class.forName("com.mysql.jdbc.Driver");//加载数据库连接驱动
			String user="root";//用户名
			String pwd="19930327";//密码
			String url="jdbc:mysql://localhost:3306/bridge";//设置连接URL
			instance=DriverManager.getConnection(url, user, pwd);//获取连接实例
		} catch (Exception e) {
				e.printStackTrace();
		}
		return instance;
	}	
}
