package com.redcmsv.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.redcmsv.beans.Channel;
import com.redcmsv.beans.ChannelAttr;
import com.redcmsv.beans.Model;
import com.redcmsv.beans.ModelItem;
import com.redcmsv.beans.Pictures;
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
		
		this.setAttribute("model_id", model_id);
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
		System.out.println(channel);
		channel.setCreate_time(new Date());
		//增加channel表
		ChannelService.insertChannel(channel);
		Channel ch = ChannelService.selectLater();
		for(int i = 1;i < 3;i++) {
			String[] ids = this.getStrings("pic"+i+"_ids");
			String[] prio = this.getStrings("pic"+i+"_priority");
			String[] diss = this.getStrings("pic"+i+"_dis");
			//修改图集表 pictures
			
			if(null!=ids&&null!=prio&&null!=diss&&ids.length==prio.length&&ids.length==diss.length) {
				for(int z = 0;z < ids.length;i++) {
					Pictures p = new Pictures();
					p.setChannel_id(ch.getId());
					p.setId(Long.parseLong(ids[i]));
					p.setPicdis(diss[i]);
					p.setPriority(Integer.parseInt(prio[i]));
					p.setSequ(z+1);
					ChannelService.updatePicture(p);
				}
			}
			
		}
		
		//修改额外字段 
		//查询出modleitem中的额外字段
		//将这一些字段写入channel_attr
		//selectFieldOfKZ 查询扩展的字段
		long modelId = this.getInt("model_id");
		List<ModelItem> modelItemList = ChannelService.selectFieldOfKZ(modelId);
		if(modelItemList != null && modelItemList.size() > 0) {
			for(ModelItem mi : modelItemList) {
				ChannelAttr ca = new ChannelAttr();
				String value=this.getString(mi.getField());
				ca.setChannel_id(ch.getId());
				ca.setField_name(mi.getField());
				ca.setField_value(value);
				
				ChannelService.insertChannelAttr(ca);
			}
		}
		
		System.out.println("addChannel------>true");
		try {
			index();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteChannel() {
		long channel_id = this.getInt("channel_id");
		boolean b = ChannelService.deleteChannel(channel_id);
		System.out.println("deleteChannel---->"+b);
		try {
			index();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateChannelToFoward() {
		long channel_id = this.getInt("channel_id");
		
	}
	
}
