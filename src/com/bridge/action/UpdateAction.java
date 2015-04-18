package com.bridge.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.bridge.employee.Employee;
import com.bridge.employee.Md5;
import com.bridge.hibernate.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateAction extends ActionSupport  {
    Map<String, Object> sessionMap;
    private Integer id;
    private String username;//员工姓名
	
	private String sex;//性别
	
	private String password;//密码
	
	private String duty;//职务
	
	private String sector;//部门
	
	
	private String age;//年齡
	
	private String tel;
    
    
    public UpdateAction() {
    	sessionMap=(Map<String, Object>)ActionContext.getContext().get("session");
	}

	/**
     * 
     */
    public String execute() throws Exception {
        Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();//开启事务
			Employee employee = (Employee)session.load(Employee.class, id);//修改操作
			employee.setUsername(username);//修改员工的各个属性
			employee.setPassword(Md5.getMD5(password));
			employee.setSex(sex);
			employee.setDuty(duty);
			employee.setSector(sector);
			employee.setAge(age);
			employee.setTel(tel);
			session.getTransaction().commit();//提交事务
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();//事务回滚
		}finally{
			HibernateUtil.closeSession();//关闭session
		}
        
        
        return SUCCESS;
    }

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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


    



	
	

    
    
    
}
