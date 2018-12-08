package com.redcmsv.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.redcmsv.beans.Channel;
import com.redcmsv.beans.Model;
import com.redcmsv.beans.ModelItem;
import com.redcmsv.service.ChannelService;
import com.redcmsv.servlet.core.Action;

@WebServlet("/admin/channel")
public class ChannelServlet extends Action{

	private static final long serialVersionUID = 1L;

	@Override
	public void index() throws ServletException, IOException {
		List<Model> modelList = ChannelService.selectAllModel();
		
		this.setAttribute("modelList", modelList);
		this.foward("/WEB-INF/admin/channelManager.jsp");
	}
	
	public void addChannelToFoward() {
		String modelName = this.getString("name");
		long model_id = this.getInt("model_id");
		
		//MI model_id and is_channel
		List<ModelItem> modelItemList = ChannelService.selectModelItemByMI(model_id);
		List<Channel> channelList = ChannelService.selectChannelByParentId(0);
		
		this.setAttribute("modelName", modelName);
		this.setAttribute("modelItemList", modelItemList);
		this.setAttribute("channelList", channelList);
		try {
			this.foward("/WEB-INF/admin/addChannel.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addChannel() {
		Channel channel = new Channel();
		try {
			this.getBean(channel);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		channel.setCreate_time(new Date());
		//增加channel表
		boolean b = ChannelService.insertChannel(channel);
		
		//修改图集表 pictures
		
		//修改额外字段 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
