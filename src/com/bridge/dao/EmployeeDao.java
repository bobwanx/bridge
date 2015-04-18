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
			con=DBCon.getInstance();//��DBCon���л�����ݿ����Ӷ���
			String sql = "select id from tb_employee where username=? and password=?";//select���
			PreparedStatement pstmt = con.prepareStatement(sql);//����PreparedStatement����
			pstmt.setString(1, em.getUsername()); //�Բ����е��û�����ֵ
			pstmt.setString(2, em.getPassword());  //�Բ����е����븳ֵ
			rs=pstmt.executeQuery();            //ִ�в����ؽ����
			if(rs.next()) res=true;             //��������������һ�����ݣ�������true
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				rs.close();  //�رս����
				con.close(); //�ر����ݿ�����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}	
}
