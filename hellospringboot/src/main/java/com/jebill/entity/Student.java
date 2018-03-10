package com.jebill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="T_STUDENT")
public class Student {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull(message="姓名不能为空！")
	@Column(length=10)
	private String name;
	
	@NotNull
	@Min(value = 0, message="年龄必须大于18岁！")
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	

}
