package com.dayang.user.mapper.db;

public class User {
	private String name;
	private Integer age;
	private Long id;
	
	public User() {
		
	}
	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public User(String name, Integer age, Long id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	
	
}
