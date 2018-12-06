package com.redcmsv.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcmsv.beans.ModelItem;
import com.redcmsv.dao.ModelItemDao;

public class ModelItemDaoImp implements ModelItemDao{

	@Override
	public boolean insert(ModelItem v) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long k) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ModelItem v) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ModelItem select(Long k) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModelItem> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertObject(long modelId,Object obj) throws SQLException {
		String insertObjectSql = "insert into model_item(model_id,field,field_dis,"
				+ "priority,def_value,opt_value,txt_size,help_info,data_type,is_single,"
				+ "is_channel,is_custom,is_display,is_required) values("
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = Db.insertObject(insertObjectSql, modelId, obj);
		return i > 0?true:false;
	}

	public boolean deleteByModelId(long modelId) throws SQLException {
		String deleteModleItemByModelIdSql = "delete from model_item where model_id=?";
		int i = Db.update(deleteModleItemByModelIdSql,modelId);
		return i>0?true:false;
	}

	public List<ModelItem> selectModelItemByMI(long modelId, byte is_channel) throws SQLException {
		String selectModelItemByMISql = "select * from model_item where model_id=? and is_channel=?";
		List<ModelItem> modelItemList = Db.query(selectModelItemByMISql, 
				new BeanListHandler<ModelItem>(ModelItem.class),modelId,is_channel);
		return modelItemList;
	}

	public boolean updateFieldOfModelByMI(long modelId, byte is_channel) throws SQLException {
		String updateFieldOfModelSql = "update model_item set model_id=?,field=?,field_dis=?,"
				+ "priority=?,def_value=?,opt_value=?,txt_size=?,help_info=?,data_type=?,"
				+ "is_single=?,is_channel=?,is_custom=?,is_display=?,is_required=? "
				+ "where id=?";
		int i = Db.update(updateFieldOfModelSql, modelId,is_channel);
		return i>0?true:false;
	}

	public boolean addModelItem(ModelItem modelItem) throws SQLException {
		String addModelItemSql = "insert into model_item(model_id,field,field_dis,priority,"
				+ "def_value,opt_value,txt_size,help_info,data_type,is_single,"
				+ "is_channel,is_custom,is_display,is_required) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = Db.insertObject(addModelItemSql, modelItem);
		return i>0?true:false;
	}

	
}
