package com.redcmsv.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcmsv.beans.DataField;
import com.redcmsv.dao.DataFieldDao;

public class DataFieldDaoImp implements DataFieldDao{

	@Override
	public boolean insert(DataField v) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long k) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DataField v) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DataField select(Long k) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataField> selectAll() throws SQLException {
		String selectAllSql = "select * from data_field";
		List<DataField> dataFieldList = Db.query(selectAllSql, new BeanListHandler<DataField>(DataField.class));
		return dataFieldList;
	}

}
