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
    private String username;//Ա������
	
	private String sex;//�Ա�
	
	private String password;//����
	
	private String duty;//ְ��
	
	private String sector;//����
	
	
	private String age;//���g
	
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
			session.beginTransaction();//��������
			Employee employee = (Employee)session.load(Employee.class, id);//�޸Ĳ���
			employee.setUsername(username);//�޸�Ա���ĸ�������
			employee.setPassword(Md5.getMD5(password));
			employee.setSex(sex);
			employee.setDuty(duty);
			employee.setSector(sector);
			employee.setAge(age);
			employee.setTel(tel);
			session.getTransaction().commit();//�ύ����
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();//����ع�
		}finally{
			HibernateUtil.closeSession();//�ر�session
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
