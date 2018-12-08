package com.redcmsv.beans;

public class Model {

	/*
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
	  `name` varchar(45) NOT NULL COMMENT '名字',
	  `path` varchar(45) NOT NULL COMMENT '路径',
	  `title_width` int(10) unsigned NOT NULL DEFAULT '139' COMMENT '标题 图宽',
	  `title_height` int(10) unsigned NOT NULL DEFAULT '139',
	  `content_width` int(10) unsigned NOT NULL DEFAULT '310' COMMENT '内容图宽',
	  `content_height` int(10) unsigned NOT NULL DEFAULT '310',
	  `priority` int(10) unsigned NOT NULL DEFAULT '10' COMMENT '排序',
	  `has_content` tinyint(1) unsigned DEFAULT '1' COMMENT '是否有内容',
	  `is_def` tinyint(1) unsigned DEFAULT '0' COMMENT '是否默认',
	  `template` varchar(45) DEFAULT NULL COMMENT '模版',*/
	
	private long id;
	private String name;
	private String path;
	private int title_width;//标题图宽
	private int title_height; //标题图高
	private int content_width; //内容图宽
	private int content_height; //内容图高
	private int priority; //排序
	private byte has_content; //是否有内容
	private byte is_def; //是否默认
	private String template; //模板
	
	public Model() {
		
	}

	public Model(long id, String name, String path, int title_width, int title_height, int content_width,
			int content_height, int priority, byte has_content, byte is_def, String template) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.title_width = title_width;
		this.title_height = title_height;
		this.content_width = content_width;
		this.content_height = content_height;
		this.priority = priority;
		this.has_content = has_content;
		this.is_def = is_def;
		this.template = template;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getTitle_width() {
		return title_width;
	}

	public void setTitle_width(int title_width) {
		this.title_width = title_width;
	}

	public int getTitle_height() {
		return title_height;
	}

	public void setTitle_height(int title_height) {
		this.title_height = title_height;
	}

	public int getContent_width() {
		return content_width;
	}

	public void setContent_width(int content_width) {
		this.content_width = content_width;
	}

	public int getContent_height() {
		return content_height;
	}

	public void setContent_height(int content_height) {
		this.content_height = content_height;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public byte getHas_content() {
		return has_content;
	}

	public void setHas_content(byte has_content) {
		this.has_content = has_content;
	}

	public byte getIs_def() {
		return is_def;
	}

	public void setIs_def(byte is_def) {
		this.is_def = is_def;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", path=" + path + ", title_width=" + title_width
				+ ", title_height=" + title_height + ", content_width=" + content_width + ", content_height="
				+ content_height + ", priority=" + priority + ", has_content=" + has_content + ", is_def=" + is_def
				+ ", template=" + template + "]";
	}
}
