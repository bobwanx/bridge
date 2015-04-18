package com.bridge.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.bridge.dao.DBCon;
import com.bridge.employee.Employee;
import com.bridge.employee.Md5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String msg = null;// 用户储存返回客户端的信息
	private String loginname;
	private String loginpwd;
	private Integer id;
	Map<String, Object> session;

	public LoginAction() {
		session = (Map<String, Object>) ActionContext.getContext().get(
				"session");
	}

	/**
     * 
     */
	public String execute() throws Exception {
		Employee em = new Employee();
		em.setUsername(loginname);
		em.setPassword(Md5.getMD5(loginpwd));
		boolean res = checkEmLog(em);
		if (res) {
			setMsg("<script>" + "alert('登录成功！');" + "</script>");
			session.put("loginname", loginname);
			return SUCCESS;
		}
		setMsg("<script>" + "alert('登录失败！');" + "</script>");
		return SUCCESS;
	}

	public Boolean checkEmLog(Employee em) {
		boolean res = false;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DBCon.getInstance();// 从DBCon类中获得数据库连接对象
			String sql = "select id from tb_employee where username=? and password=?";// select语句
			PreparedStatement pstmt = con.prepareStatement(sql);// 创建PreparedStatement对象
			pstmt.setString(1, em.getUsername()); // 对参数中的用户名赋值
			pstmt.setString(2, em.getPassword()); // 对参数中的密码赋值
			rs = pstmt.executeQuery(); // 执行并返回结果集
			if (rs.next()) {
				setId(rs.getInt(1));
				res = true; // 如果结果集中有下一行数据，将返回true
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close(); // 关闭结果集
				con.close(); // 关闭数据库连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
