package com.redcmsv.service;

import java.sql.SQLException;
import java.util.List;

import com.redcmsv.beans.Channel;
import com.redcmsv.beans.Model;
import com.redcmsv.beans.ModelItem;
import com.redcmsv.daoImp.ChannelDaoImp;
import com.redcmsv.daoImp.ModelDaoImp;
import com.redcmsv.daoImp.ModelItemDaoImp;

public class ChannelService {
	
	private static ChannelDaoImp cdi = new ChannelDaoImp();
	private static ModelDaoImp mdi = new ModelDaoImp();
	private static ModelItemDaoImp midi = new ModelItemDaoImp();

	public static List<Channel> selectAll() {
		List<Channel> channelList = null;
		try {
			channelList = cdi.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return channelList;
	}

	public static List<Channel> selectChannelByParentId(long parentId) {
		List<Channel> channelList = null;
		try {
			channelList = cdi.selectChannelByParentId(parentId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return channelList;
	}

	public static List<Model> selectAllModel() {
		List<Model> modelList = null;
		try {
			modelList = mdi.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelList;
	}

	public static List<ModelItem> selectModelItemByMI(long model_id) {
		List<ModelItem> modelItemList = null;
		byte is_channel = 1;
		try {
			modelItemList = midi.selectModelItemByMI(model_id, is_channel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelItemList;
	}

	public static boolean insertChannel(Channel channel) {
		boolean bool = false;
		try {
			bool = cdi.insert(channel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

}
