package com.redcmsv.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcmsv.beans.ChannelField;
import com.redcmsv.dao.ChannelFieldDao;

public class ChannelFieldDaoImp implements ChannelFieldDao{

	@Override
	public boolean insert(ChannelField v) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long k) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ChannelField v) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ChannelField select(Long k) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChannelField> selectAll() throws SQLException {
		String selectAllSql = "select * from channel_field";
		List<ChannelField> channelFieldList = Db.query(selectAllSql, new BeanListHandler<ChannelField>(ChannelField.class));
		return channelFieldList;
	}


}
