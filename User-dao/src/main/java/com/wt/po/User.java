package com.wt.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private Integer uid;
	private String uname;
	private Date birthday;
	private Double money;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", birthday=" + birthday + ", money=" + money + "]";
	}
	public User(Integer uid, String uname, Date birthday, Double money) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.birthday = birthday;
		this.money = money;
	}
	public User() {
		super();
	}
	
	
	
	
}
