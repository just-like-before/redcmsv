package com.redcmsv.beans;

import java.util.Date;

public class Channel {
	
	/*
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	  `model_id` bigint(20) unsigned DEFAULT NULL COMMENT '''模型id''',
	  `name` varchar(45) NOT NULL COMMENT '''栏目名字''',
	  `title` varchar(65) DEFAULT NULL COMMENT '''meta标题''',
	  `keywords` varchar(65) DEFAULT NULL COMMENT '''meta关键词''',
	  `description` varchar(100) DEFAULT NULL COMMENT '''meta描述''',
	  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '''父id''',
	  `pic01` varchar(65) DEFAULT NULL COMMENT '图1',
	  `pic02` varchar(45) DEFAULT NULL COMMENT '图2',
	  `priority` int(2) unsigned DEFAULT '10' COMMENT '排序',
	  `links` varchar(100) DEFAULT NULL COMMENT '外链',
	  `t_name` varchar(45) DEFAULT NULL COMMENT '分表名',
	  `index_tem` varchar(45) DEFAULT NULL COMMENT 'pc首页模版',
	  `list_tem` varchar(65) DEFAULT NULL COMMENT 'pc列表页模版',
	  `content_tem` varchar(65) DEFAULT NULL COMMENT 'pc内容页',
	  `create_time` datetime DEFAULT NULL COMMENT '增加时间',
	  `txt` text COMMENT '内容',
	  `txt1` text COMMENT '扩展',
	  `txt2` text COMMENT '扩展',
	  `num01` int(10) unsigned DEFAULT NULL COMMENT '扩展01',
	  `num02` int(10) unsigned DEFAULT NULL COMMENT '扩展01',
	  `date1` varchar(45) DEFAULT NULL COMMENT '扩展01',
	  `date2` varchar(45) DEFAULT NULL COMMENT '扩展01',*/
	
	private long id;
	private long model_id;
	private String name;
	private String title;
	private String keywords;//栏目关键字
	private String description;//栏目描述
	private long parent_id;//父栏目id
	private String pic01;
	private String pic02;
	private int priority;//排序
	private String links;//外链
	private String t_name;//分表明
	private String index_tem;//pc首页模板
	private String list_tem;//pc列表页模板
	private String content_tem;//pc内容页
	private Date create_time;//创建时间
	private String txt;//内容
	private String txt1;//扩展
	private String txt2;//扩展
	private int num01;//扩展01
	private int num02;//扩展02
	private String date1;//扩展01
	private String date2;//扩展02
	
	public Channel() {
		
	}

	public Channel(long id, long model_id, String name, String title, String keywords, String description,
			long parent_id, String pic01, String pic02, int priority, String links, String t_name, String index_tem,
			String list_tem, String content_tem, Date create_time, String txt, String txt1, String txt2, int num01,
			int num02, String date1, String date2) {
		super();
		this.id = id;
		this.model_id = model_id;
		this.name = name;
		this.title = title;
		this.keywords = keywords;
		this.description = description;
		this.parent_id = parent_id;
		this.pic01 = pic01;
		this.pic02 = pic02;
		this.priority = priority;
		this.links = links;
		this.t_name = t_name;
		this.index_tem = index_tem;
		this.list_tem = list_tem;
		this.content_tem = content_tem;
		this.create_time = create_time;
		this.txt = txt;
		this.txt1 = txt1;
		this.txt2 = txt2;
		this.num01 = num01;
		this.num02 = num02;
		this.date1 = date1;
		this.date2 = date2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getModel_id() {
		return model_id;
	}

	public void setModel_id(long model_id) {
		this.model_id = model_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getParent_id() {
		return parent_id;
	}

	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}

	public String getPic01() {
		return pic01;
	}

	public void setPic01(String pic01) {
		this.pic01 = pic01;
	}

	public String getPic02() {
		return pic02;
	}

	public void setPic02(String pic02) {
		this.pic02 = pic02;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getIndex_tem() {
		return index_tem;
	}

	public void setIndex_tem(String index_tem) {
		this.index_tem = index_tem;
	}

	public String getList_tem() {
		return list_tem;
	}

	public void setList_tem(String list_tem) {
		this.list_tem = list_tem;
	}

	public String getContent_tem() {
		return content_tem;
	}

	public void setContent_tem(String content_tem) {
		this.content_tem = content_tem;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public String getTxt2() {
		return txt2;
	}

	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}

	public int getNum01() {
		return num01;
	}

	public void setNum01(int num01) {
		this.num01 = num01;
	}

	public int getNum02() {
		return num02;
	}

	public void setNum02(int num02) {
		this.num02 = num02;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", model_id=" + model_id + ", name=" + name + ", title=" + title + ", keywords="
				+ keywords + ", description=" + description + ", parent_id=" + parent_id + ", pic01=" + pic01
				+ ", pic02=" + pic02 + ", priority=" + priority + ", links=" + links + ", t_name=" + t_name
				+ ", index_tem=" + index_tem + ", list_tem=" + list_tem + ", content_tem=" + content_tem
				+ ", create_time=" + create_time + ", txt=" + txt + ", txt1=" + txt1 + ", txt2=" + txt2 + ", num01="
				+ num01 + ", num02=" + num02 + ", date1=" + date1 + ", date2=" + date2 + "]";
	}
}
