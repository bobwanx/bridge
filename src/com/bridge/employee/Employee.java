package com.bridge.employee;

public class Employee {
	
	private Integer id;//idֵ
	
	private String username;//Ա������
	
	private String sex;//�Ա�
	
	private String password;//����
	
	private String duty;//ְ��
	
	private String sector;//����
	
	
	private String age;//���g
	
	private String tel;

	
	public Employee(){}
	/**
	 * �����Ĺ��췽��
	 * @param name
	 * @param pwd
	 * @param sex
	 * @param age
	 * @param loginTime
	 */
	public Employee(String username,String password,String sex,String age,String tel,String duty,String sector){
		this.username=username;
		this.password=password;
		this.sex=sex;
		this.age=age;
		this.tel=tel;
		this.duty=duty;
		this.sector=sector;
		
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
