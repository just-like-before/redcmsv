package com.redcmsv.beans;

public class Admin {
	
	/*`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
	  `uname` varchar(45) NOT NULL COMMENT '用户名',
	  `upwd` varchar(45) NOT NULL COMMENT '密码',
	  `upur` varchar(45) DEFAULT '100000000' COMMENT '用户权限等级',
	  `active` tinyint(1) unsigned DEFAULT '1' COMMENT '活动',*/

	private int id;

	private String uname;
	
	private String upwd;
	
	private String upur;//用户的等级
	
	private int active;//用户活动
	
	public Admin() {
		
	}

	public Admin(int id, String uname, String upwd, String upur, int active) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.upur = upur;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUpur() {
		return upur;
	}

	public void setUpur(String upur) {
		this.upur = upur;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", uname=" + uname + ", upwd=" + upwd + ", upur=" + upur + ", active=" + active
				+ "]";
	}
}
