package com.redcmsv.tag;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcmsv.beans.Channel;
import com.redcmsv.beans.ChannelAttr;
import com.redcmsv.daoImp.Db;

public class WebAllChannelTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private int parentId;
	private int top;
	private Channel currentChannel;
	private int index = 0;
	private List<Channel> channelList = null;

	@Override
	public int doAfterBody() throws JspException {
		if(channelList != null && channelList.size() > 0) {
			if(index < channelList.size()) {
				currentChannel = channelList.get(index++);
				fillField(currentChannel);
				return IterationTag.EVAL_BODY_AGAIN;
			}else {
				return Tag.SKIP_BODY;
			}
		}else {
			return Tag.SKIP_BODY;
		}
	}
	
	@Override
	public int doEndTag() throws JspException {
		index = 0;
		currentChannel = null;
		channelList = null;
		return Tag.EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			if(top == 0) {
				channelList = Db.query("select * from channel where parent_id=?", 
						new BeanListHandler<Channel>(Channel.class),parentId);
			}else {
				channelList = Db.query("select * from channel where parent_id limit ?",
						new BeanListHandler<Channel>(Channel.class),top);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(channelList != null & channelList.size() > 0) {
			currentChannel = channelList.get(index++);
			fillField(currentChannel);
		}
		
		return Tag.EVAL_BODY_INCLUDE;
	}
	
	//填充栏目的字段
	public void fillField(Channel currentChannel) {
		try {
			List<ChannelAttr> channelAttrList = Db.query("select * from channel_attr where channel_id=?", 
					new BeanListHandler<ChannelAttr>(ChannelAttr.class),currentChannel.getId());
			if(channelAttrList != null && channelAttrList.size() > 0) {
				for(ChannelAttr ca : channelAttrList) {
					currentChannel.getChannelAttrMap().put(ca.getField_name(), ca.getField_value());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public Channel getCurrentChannel() {
		return currentChannel;
	}
	public void setCurrentChannel(Channel currentChannel) {
		this.currentChannel = currentChannel;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
