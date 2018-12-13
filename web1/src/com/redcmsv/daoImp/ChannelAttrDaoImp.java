package com.redcmsv.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcmsv.beans.ChannelAttr;
import com.redcmsv.dao.ChannelAttrDao;

public class ChannelAttrDaoImp implements ChannelAttrDao{

	@Override
	public boolean insert(ChannelAttr v) throws SQLException {
		String channelAttrSql = "insert into channel_attr(channel_id,field_name,"
				+ "field_value) values(?,?,?)";
		int i = Db.insertObject(channelAttrSql, v);
		return i>0?true:false;
	}

	@Override
	public boolean delete(Long k) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ChannelAttr v) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ChannelAttr select(Long k) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChannelAttr> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteByChannelId(long channel_id) throws SQLException {
		String deleteByChannelIdSql = "delete from channel_attr where channel_id=?";
		int i = Db.update(deleteByChannelIdSql,channel_id);
		return i>0?true:false;
	}

	public List<ChannelAttr> selectChannelAttrByCI(long channel_id) throws SQLException {
		String selectChannelAttrSql = "select * from channel_attr where channel_id=?";
		List<ChannelAttr> channelAttrList = Db.query(selectChannelAttrSql, new BeanListHandler<ChannelAttr>(ChannelAttr.class),channel_id);
		return channelAttrList;
	}

	

}
