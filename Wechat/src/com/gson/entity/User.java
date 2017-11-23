package com.gson.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类
 * 
 * @author song
 * 
 */
// 标示这个类为映射实体类
@Entity
// 改变数据库中映射表的名称，不加默认表名称为类名即User
@Table(name = "user")
public class User {
	// 用户Id
	private int Id;
	// 用户名
	private String openId;

	public User() {
	}

	// 有参构造
	public User(String openId) {
		this.openId = openId;

	}

	// 标识此字段为数据库中的主键
	@Id
	// 标识此字段为数据库中成序列增长的列，不同的数据库，Hibernate会自动匹配
	@GeneratedValue
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}


}
