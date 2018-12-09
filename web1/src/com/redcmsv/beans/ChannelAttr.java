package com.redcmsv.beans;

public class ChannelAttr {

	/*`channel_id` bigint(20) unsigned NOT NULL,
	  `field_name` varchar(45) NOT NULL,
	  `field_value` varchar(65) DEFAULT NULL*/
	
	private long channel_id;
	private String field_name;
	private String field_value;
	
	public ChannelAttr() {
		
	}

	public ChannelAttr(long channel_id, String field_name, String field_value) {
		super();
		this.channel_id = channel_id;
		this.field_name = field_name;
		this.field_value = field_value;
	}

	public long getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(long channel_id) {
		this.channel_id = channel_id;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public String getField_value() {
		return field_value;
	}

	public void setField_value(String field_value) {
		this.field_value = field_value;
	}

	@Override
	public String toString() {
		return "ChannelAttr [channel_id=" + channel_id + ", field_name=" + field_name + ", field_value=" + field_value
				+ "]";
	}
}
