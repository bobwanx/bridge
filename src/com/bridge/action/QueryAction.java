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
        List emplist = new ArrayList();//ʵ����List��Ϣ����
        Session session = null;// ʵ����session����
        try {
            session = HibernateUtil.getSession();// ���session����
            String hql = "from Employee em";// ��ѯHQL���
            Query q = session.createQuery(hql);// ִ�в�ѯ����
            emplist = q.list();//�����صĶ���ת��ΪList����
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();// �ر�session
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
