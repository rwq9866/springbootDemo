package com.muyou.springbootDemo.domian;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@Entity
@ExcelTarget("user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	private String id;
	@Excel(name = "姓名", isImportField = "name")
	private String name;
	@Excel(name = "年龄", isImportField = "age")
	private int age;
	@Excel(name = "性别", isImportField = "gender")
	private char gender;
	@Excel(name = "薪资", isImportField = "salary")
	private double salary;
	@Excel(name = "家庭住址",width = 30, isImportField = "address")
	private String address;
	@Excel(name = "创建时间",width = 20,isImportField = "createtime")
	private String createtime;
	
	public User(String id, String name, int age, char gender, double salary, String address, String createtime) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.address = address;
		this.createtime = createtime;
	}

	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", salary=" + salary
				+ ", address=" + address + ", createtime=" + createtime + "]";
	}

}
