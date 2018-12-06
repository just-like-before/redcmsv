package com.redcmsv.beans;

public class ChannelField {

	/*
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	  `field` varchar(45) NOT NULL COMMENT '字段名',
	  `field_dis` varchar(45) NOT NULL COMMENT '字段描述',
	  `priority` int(2) unsigned DEFAULT '10' COMMENT '排序',
	  `def_value` varchar(255) DEFAULT NULL COMMENT '默认值 ',
	  `opt_value` varchar(255) DEFAULT NULL COMMENT '可选 值 ',
	  `txt_size` varchar(20) DEFAULT NULL COMMENT '长度',
	  `help_info` varchar(65) DEFAULT NULL COMMENT '帮助信息',
	  `data_type` tinyint(1) unsigned DEFAULT '1' COMMENT '数据类型 ',
	  `is_single` tinyint(1) unsigned DEFAULT '1' COMMENT '单独行',
	  `is_channel` tinyint(1) unsigned DEFAULT '1' COMMENT '是否是栏目',
	  `is_custom` tinyint(1) unsigned DEFAULT '0' COMMENT '自定义',
	  `is_display` tinyint(1) unsigned DEFAULT '1' COMMENT '显示',
	  `is_required` tinyint(1) unsigned DEFAULT '0' COMMENT '必须',*/
	
	private long id;
	private String field;
	private String field_dis;
	private int priority;
	private String def_value;
	private String opt_value;
	private String txt_size;
	private String help_info;
	private byte data_type;
	private byte is_single;//单独行
	private byte is_channel;
	private byte is_custom;
	private byte is_display;//显示
	private byte is_required;
	
	public ChannelField() {
		
	}

	public ChannelField(long id, String field, String field_dis, int priority, String def_value, String opt_value,
			String txt_size, String help_info, byte data_type, byte is_single, byte is_channel, byte is_custom,
			byte is_display, byte is_required) {
		super();
		this.id = id;
		this.field = field;
		this.field_dis = field_dis;
		this.priority = priority;
		this.def_value = def_value;
		this.opt_value = opt_value;
		this.txt_size = txt_size;
		this.help_info = help_info;
		this.data_type = data_type;
		this.is_single = is_single;
		this.is_channel = is_channel;
		this.is_custom = is_custom;
		this.is_display = is_display;
		this.is_required = is_required;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getField_dis() {
		return field_dis;
	}

	public void setField_dis(String field_dis) {
		this.field_dis = field_dis;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDef_value() {
		return def_value;
	}

	public void setDef_value(String def_value) {
		this.def_value = def_value;
	}

	public String getOpt_value() {
		return opt_value;
	}

	public void setOpt_value(String opt_value) {
		this.opt_value = opt_value;
	}

	public String getTxt_size() {
		return txt_size;
	}

	public void setTxt_size(String txt_size) {
		this.txt_size = txt_size;
	}

	public String getHelp_info() {
		return help_info;
	}

	public void setHelp_info(String help_info) {
		this.help_info = help_info;
	}

	public byte getData_type() {
		return data_type;
	}

	public void setData_type(byte data_type) {
		this.data_type = data_type;
	}

	public byte getIs_single() {
		return is_single;
	}

	public void setIs_single(byte is_single) {
		this.is_single = is_single;
	}

	public byte getIs_channel() {
		return is_channel;
	}

	public void setIs_channel(byte is_channel) {
		this.is_channel = is_channel;
	}

	public byte getIs_custom() {
		return is_custom;
	}

	public void setIs_custom(byte is_custom) {
		this.is_custom = is_custom;
	}

	public byte getIs_display() {
		return is_display;
	}

	public void setIs_display(byte is_display) {
		this.is_display = is_display;
	}

	public byte getIs_required() {
		return is_required;
	}

	public void setIs_required(byte is_required) {
		this.is_required = is_required;
	}

	@Override
	public String toString() {
		return "ChannelField [id=" + id + ", field=" + field + ", field_dis=" + field_dis + ", priority=" + priority
				+ ", def_value=" + def_value + ", opt_value=" + opt_value + ", txt_size=" + txt_size + ", help_info="
				+ help_info + ", data_type=" + data_type + ", is_single=" + is_single + ", is_channel=" + is_channel
				+ ", is_custom=" + is_custom + ", is_display=" + is_display + ", is_required=" + is_required + "]";
	}
}
