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
		
		channel.setCreate_time(new Date());
		//增加channel表
		ChannelService.insertChannel(channel);
		
		Channel ch = ChannelService.selectLater();
		for(int i = 1;i < 3;i++) {
			String[] ids = this.getStrings("pics"+i+"_ids");
			String[] prio = this.getStrings("pics"+i+"_priority");
			String[] diss = this.getStrings("pics"+i+"_dis");
			//修改图集表 pictures
			if(null!=ids&&null!=prio&&null!=diss&&ids.length==prio.length&&ids.length==diss.length) {
				for(int z = 0;z < ids.length;z++) {
					Pictures p = new Pictures();
					
					p.setChannel_id(ch.getId());
					p.setId(Long.parseLong(ids[z]));
					p.setPicdis(diss[z]);
					p.setPriority(Integer.parseInt(prio[z]));
					p.setSequ(i);
					
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
		ChannelService.deleteChannel(channel_id);
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
		
		//获得channel
		Channel channel = ChannelService.selectChannelById(channel_id);
		//通过获得model 通过channel
		Model model = ChannelService.selectModelByMI(channel.getModel_id());
		//获得model_item 通过model_id
		List<ModelItem> modelItemList = ChannelService.selectModelItemByMI(model.getId());
		//获得 channe_attr 通过channel_id
		List<ChannelAttr> channelAttrList = ChannelService.selectChannelAttrByCI(channel_id);
		//获得pictures 通过channel_id
		List<Pictures> picturesList1 = ChannelService.selectPicturesByCI(channel_id,1);
		List<Pictures> picturesList2 = ChannelService.selectPicturesByCI(channel_id,2);
		//获得一个channelList 这是每一个parent=1 是一个栏目 顶级栏目
		List<Channel> channelList = ChannelService.selectChannelByParentId(0);
		
		//将这些要使用的数据放入域中
		this.setAttribute("channel", channel);
		this.setAttribute("model", model);
		this.setAttribute("modelItemList", modelItemList);
		this.setAttribute("channelList", channelList);
		//额外字段 和图集pictures 不一定有所以 要判空
		if(channelAttrList != null && channelAttrList.size() > 0) {
			this.setAttribute("channelAttrList", channelAttrList);
		}
		
		if(picturesList1 != null && picturesList1.size() > 0) {
			this.setAttribute("picture1", picturesList1);
		}
		
		if(picturesList2 != null && picturesList2.size() > 0) {
			this.setAttribute("picture2", picturesList2);
		}
		
		//最后foward到修改页面
		try {
			this.foward("/WEB-INF/admin/updateChannel.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateChannel() {
		
	}	
}
