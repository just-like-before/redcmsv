package com.redcmsv.service;

import java.sql.SQLException;
import java.util.List;

import com.redcmsv.beans.Channel;
import com.redcmsv.beans.ChannelAttr;
import com.redcmsv.beans.Model;
import com.redcmsv.beans.ModelItem;
import com.redcmsv.beans.Pictures;
import com.redcmsv.daoImp.ChannelAttrDaoImp;
import com.redcmsv.daoImp.ChannelDaoImp;
import com.redcmsv.daoImp.Db;
import com.redcmsv.daoImp.ModelDaoImp;
import com.redcmsv.daoImp.ModelItemDaoImp;
import com.redcmsv.daoImp.PicturesDaoImp;

public class ChannelService {
	
	private static ChannelDaoImp cdi = new ChannelDaoImp();
	private static ModelDaoImp mdi = new ModelDaoImp();
	private static ModelItemDaoImp midi = new ModelItemDaoImp();
	private static PicturesDaoImp pdi = new PicturesDaoImp();
	private static ChannelAttrDaoImp cadi = new ChannelAttrDaoImp();

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

	public static Channel selectLater() {
		Channel channel = null;
		try {
			channel = cdi.selectLater();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return channel;
	}

	public static boolean updatePicture(Pictures pictures) {
		boolean bool = false;
		try {
			bool = pdi.updatePictures(pictures);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	public static List<ModelItem> selectFieldOfKZ(long modelId) {
		List<ModelItem> modelItemList = null;
		try {
			modelItemList = midi.selectFieldOfKZ(modelId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelItemList;
	}

	public static boolean insertChannelAttr(ChannelAttr ca) {
		boolean bool = false;
		try {
			bool = cadi.insert(ca);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	public static boolean deleteChannel(long channel_id) {
		boolean bool = false;
		try {
			Db.beginTransaction();
			//在删除channel_attr 扩展字段
			bool = cadi.deleteByChannelId(channel_id);
			//删除prctures
			bool = pdi.deleteByChannelId(channel_id);
			//删除 channel
			bool = cdi.delete(channel_id);
			Db.commitTransaction();
		} catch (SQLException e) {
			Db.rollbackTransaction();
			e.printStackTrace();
		}
		return bool;
	}

}
