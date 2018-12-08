package com.redcmsv.service;

import java.sql.SQLException;
import java.util.List;

import com.redcmsv.beans.ChannelField;
import com.redcmsv.beans.DataField;
import com.redcmsv.beans.Model;
import com.redcmsv.beans.ModelItem;
import com.redcmsv.daoImp.ChannelFieldDaoImp;
import com.redcmsv.daoImp.DataFieldDaoImp;
import com.redcmsv.daoImp.Db;
import com.redcmsv.daoImp.ModelDaoImp;
import com.redcmsv.daoImp.ModelItemDaoImp;

public class ModelService {
	
	private static ModelDaoImp mdi = new ModelDaoImp();
	private static ChannelFieldDaoImp cfi = new ChannelFieldDaoImp();
	private static DataFieldDaoImp dfi = new DataFieldDaoImp();
	private static ModelItemDaoImp midi = new ModelItemDaoImp();

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

	public static boolean updateModel(Model model) {
		boolean b = false;
		try {
			b = mdi.update(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;	
	}

	public static boolean addModel(Model model) {
		boolean bool = false;
		try {
			//查询channelField栏目字段
			List<ChannelField> channelFieldList = cfi.selectAll();
			//查询dataFild文章字段
			List<DataField> dataFieldList = dfi.selectAll();
			
			//开启事务
			Db.beginTransaction();
			//将表单提交的model数据写入model表中
			mdi.insert(model);
			//得到最后写入model的id
			long modelId = mdi.selectOfLastModel().getId();
			//将channel栏目  data文章字段写入modelItem表
			for(ChannelField f : channelFieldList) {
				midi.insertObject(modelId, f);
			}
			for(DataField d : dataFieldList) {
				midi.insertObject(modelId, d);
			}
			Db.commitTransaction();
			bool = true;
		} catch (SQLException e) {
			Db.rollbackTransaction();
			bool = false;
			e.printStackTrace();
		}
		return bool;
	}

	public static boolean deleteModel(long modelId) {
		boolean bool = false;
		try {
			Db.beginTransaction();
			//根据modelId删除model表
			mdi.delete(modelId);
			//根据modelId删除modelItem中的相关字段 channel栏目字段和 data文章字段
			midi.deleteByModelId(modelId);
			Db.commitTransaction();
			bool = true;
		} catch (SQLException e) {
			Db.rollbackTransaction();
			bool = false;
			e.printStackTrace();
		}
		return bool;
	}

	public static List<ModelItem> selectModelItemByMI(long modelId, byte is_channel) {
		List<ModelItem> modelItemList = null;
		try {
			modelItemList = midi.selectModelItemByMI(modelId,is_channel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelItemList;
	}

	public static Model select(long modelId) {
		Model model = null;
		try {
			model = mdi.select(modelId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

	public static boolean updateFieldOfModelByMI(ModelItem modelItem) {
		boolean bool = false;
		try {
			bool = midi.updateFieldOfModelByMI(modelItem);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	public static boolean addModelItem(ModelItem modelItem) {
		boolean bool = false;
		try {
			bool = midi.addModelItem(modelItem);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}
}
