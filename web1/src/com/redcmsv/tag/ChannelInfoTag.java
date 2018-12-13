package com.redcmsv.tag;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcmsv.beans.Channel;
import com.redcmsv.beans.ChannelAttr;
import com.redcmsv.daoImp.Db;

public class ChannelInfoTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private Channel channel = null;
	
	@SuppressWarnings("rawtypes")
	@Override
	public int doEndTag() throws JspException {
		String result = null;
		try {
			result = channel.getChannelAttrMap().get(name);
			if(result == null) {
				Class clazz = channel.getClass();
				Field field = clazz.getDeclaredField(name);
				
				field.setAccessible(true);
				result = (String)field.get(channel).toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			pageContext.getOut().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return super.doEndTag();
	}

	//设置一个channel的缓存 以减小数据库的压力
	@Override
	public int doStartTag() throws JspException {
		Channel channelBuffer = (Channel)pageContext.getSession().getAttribute("channel"+id);
		if(channelBuffer == null) {
			String sql = "select * from channel where id=?";
			try {
				channel = Db.query(sql, new BeanHandler<Channel>(Channel.class),Long.parseLong(id));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fillField(channel);
			pageContext.getSession().setAttribute("channel"+id, channel);;
		}else {
			System.out.println("buffer");
			channel = channelBuffer;
		}
		return Tag.SKIP_BODY;
	}
	
	//填充栏目的字段
	public void fillField(Channel ch) {
		try {
			List<ChannelAttr> channelAttrList = Db.query("select * from channel_attr where channel_id=?", 
					new BeanListHandler<ChannelAttr>(ChannelAttr.class),id);
			if(channelAttrList != null && channelAttrList.size() > 0) {
				for(ChannelAttr ca : channelAttrList) {
					ch.getChannelAttrMap().put(ca.getField_name(), ca.getField_value());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
