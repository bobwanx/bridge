package com.bridge.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.bridge.hibernate.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryAction extends ActionSupport {
    private List userlist;
    private String query;
    Map<String, Object> sessionMap;
    
    
    public QueryAction() {
    	sessionMap=(Map<String, Object>)ActionContext.getContext().get("session");
	}

	/**
     * 
     */
    public String execute() throws Exception {
        List emplist = new ArrayList();//实例化List信息集合
        Session session = null;// 实例化session对象
        try {
            session = HibernateUtil.getSession();// 获得session对象
            String hql = "from Employee em";// 查询HQL语句
            Query q = session.createQuery(hql);// 执行查询操作
            emplist = q.list();//将返回的对象转化为List集合
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();// 关闭session
        }
        setUserlist(emplist);
        sessionMap.put("query","123");
        
        return SUCCESS;
    }
    



	public List getUserlist() {
		return userlist;
	}

	public void setUserlist(List userlist) {
		this.userlist = userlist;
	}


	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	

    
    
    
}
