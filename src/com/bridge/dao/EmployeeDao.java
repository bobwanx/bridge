package com.bridge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridge.employee.Employee;

public class EmployeeDao {
	private static EmployeeDao instance =null;
	public static EmployeeDao getInstance() {
		if(instance==null) instance=new EmployeeDao();
			return instance;
	}
	
	public EmployeeDao() {}
	
	public Boolean checkEmLog(Employee em) {
		boolean res=false;
		Connection con=null;
		ResultSet rs=null;
		try {
			con=DBCon.getInstance();//从DBCon类中获得数据库连接对象
			String sql = "select id from tb_employee where username=? and password=?";//select语句
			PreparedStatement pstmt = con.prepareStatement(sql);//创建PreparedStatement对象
			pstmt.setString(1, em.getUsername()); //对参数中的用户名赋值
			pstmt.setString(2, em.getPassword());  //对参数中的密码赋值
			rs=pstmt.executeQuery();            //执行并返回结果集
			if(rs.next()) res=true;             //如果结果集中有下一行数据，将返回true
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				rs.close();  //关闭结果集
				con.close(); //关闭数据库连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}	
}
