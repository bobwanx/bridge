package com.bridge.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bridge.dao.DBCon;
import com.bridge.employee.Md5;
import com.opensymphony.xwork2.ActionSupport;

public class RegAction extends ActionSupport {
	private String msg = null;// 用户储存返回客户端的信息

	private String username;

	private String sex;//性别
	
	private String password;//密码
	
	private String duty;//职务
	
	private String sector;//部门
	
	
	private String age;//年齡
	
	private String tel;
	

	/**
     * 
     */
	public String execute() throws Exception {
		Connection con = null;
		try {
			con = DBCon.getInstance();// 从DBCon类中获得数据库连接对象
			String sql="insert into tb_employee (username,password,sex,age,tel,duty,sector) values('"+username+"','"+Md5.getMD5(password)+"','"+sex+"','"+age+"','"+tel+"','"+duty+"','"+sector+"')";
			PreparedStatement pstmt = con.prepareStatement(sql);// 创建PreparedStatement对象
			pstmt.execute(); // 执行并返回结果集		
			setMsg("<script>" + "alert('注册成功！');" + "</script>");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close(); // 关闭数据库连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}



}
