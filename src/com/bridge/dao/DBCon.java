package com.bridge.dao;
import java.sql.*;

/**
 * �������ݿ���࣬������ݿ�����
 * @author Administrator
 *
 */
public class DBCon {
	private static java.sql.Connection instance=null;
	public static Connection getInstance(){
		try{	
			Class.forName("com.mysql.jdbc.Driver");//�������ݿ���������
			String user="root";//�û���
			String pwd="19930327";//����
			String url="jdbc:mysql://localhost:3306/bridge";//��������URL
			instance=DriverManager.getConnection(url, user, pwd);//��ȡ����ʵ��
		} catch (Exception e) {
				e.printStackTrace();
		}
		return instance;
	}	
}
