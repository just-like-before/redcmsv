package com.redcmsv.beans;

public class Pictures {

	/*`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
	  `channel_id` bigint(20) unsigned DEFAULT NULL COMMENT '栏目id',
	  `data_id` bigint(20) unsigned DEFAULT NULL COMMENT '数据id',
	  `path` varchar(100) NOT NULL COMMENT '路径',
	  `picdis` varchar(100) DEFAULT NULL COMMENT '描述',
	  `priority` int(10) unsigned NOT NULL DEFAULT '10' COMMENT '排序',
	  `sequ` int(10) unsigned DEFAULT NULL COMMENT '第几个图集',*/
	
	private long id;
	private long channel_id;
	private long data_id;
	private String path;
	private String picdis;
	private int priority;
	private int sequ;
	
	public Pictures() {
		
	}

	public Pictures(long id, long channel_id, long data_id, String path, String picdis, int priority, int sequ) {
		super();
		this.id = id;
		this.channel_id = channel_id;
		this.data_id = data_id;
		this.path = path;
		this.picdis = picdis;
		this.priority = priority;
		this.sequ = sequ;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(long channel_id) {
		this.channel_id = channel_id;
	}

	public long getData_id() {
		return data_id;
	}

	public void setData_id(long data_id) {
		this.data_id = data_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPicdis() {
		return picdis;
	}

	public void setPicdis(String picdis) {
		this.picdis = picdis;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getSequ() {
		return sequ;
	}

	public void setSequ(int sequ) {
		this.sequ = sequ;
	}

	@Override
	public String toString() {
		return "Pictures [id=" + id + ", channel_id=" + channel_id + ", data_id=" + data_id + ", path=" + path
				+ ", picdis=" + picdis + ", priority=" + priority + ", sequ=" + sequ + "]";
	}
}
