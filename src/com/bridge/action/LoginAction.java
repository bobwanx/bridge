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
	private String msg = null;// �û����淵�ؿͻ��˵���Ϣ
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
			setMsg("<script>" + "alert('��¼�ɹ���');" + "</script>");
			session.put("loginname", loginname);
			return SUCCESS;
		}
		setMsg("<script>" + "alert('��¼ʧ�ܣ�');" + "</script>");
		return SUCCESS;
	}

	public Boolean checkEmLog(Employee em) {
		boolean res = false;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DBCon.getInstance();// ��DBCon���л�����ݿ����Ӷ���
			String sql = "select id from tb_employee where username=? and password=?";// select���
			PreparedStatement pstmt = con.prepareStatement(sql);// ����PreparedStatement����
			pstmt.setString(1, em.getUsername()); // �Բ����е��û�����ֵ
			pstmt.setString(2, em.getPassword()); // �Բ����е����븳ֵ
			rs = pstmt.executeQuery(); // ִ�в����ؽ����
			if (rs.next()) {
				setId(rs.getInt(1));
				res = true; // ��������������һ�����ݣ�������true
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close(); // �رս����
				con.close(); // �ر����ݿ�����
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
