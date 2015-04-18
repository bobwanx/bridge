package com.bridge.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.bridge.dao.EmployeeDao;
import com.bridge.employee.Employee;
import com.bridge.hibernate.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SelfAction extends ActionSupport {
    private Employee em;
    private String self;
    private Integer id;
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	Map<String, Object> sessionMap;
    Map<String, Object> request;
    
    
    public SelfAction() {
    	sessionMap=(Map<String, Object>)ActionContext.getContext().get("session");
    	request=(Map<String, Object>)ActionContext.getContext().get("request");
	}

	/**
     * 
     */
    public String execute() throws Exception {
        List emplist = new ArrayList();//实例化List信息集合
        Session session = null;// 实例化session对象
//        String username=(String) request.get("uname");
        try {
            session = HibernateUtil.getSession();// 获得session对象
            Employee user = (Employee)session.get(Employee.class, id);//根据id查询信息
            setEm(user);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();// 关闭session
        }
        sessionMap.put("self","123");
        
        return SUCCESS;
    }
    



	public Employee getEm() {
		return em;
	}

	public void setEm(Employee em) {
		this.em = em;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	
	
	

    
    
    
}
