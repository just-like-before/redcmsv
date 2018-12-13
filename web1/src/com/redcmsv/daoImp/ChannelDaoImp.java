package com.redcmsv.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcmsv.beans.Channel;
import com.redcmsv.dao.ChannelDao;

public class ChannelDaoImp implements ChannelDao{

	@Override
	public boolean insert(Channel v) throws SQLException {
		String insertChannelSql = "insert into channel(model_id,name,title,keywords,description,"
				+ "parent_id,pic01,pic02,priority,links,t_name,index_tem,list_tem,content_tem,"
				+ "create_time,txt,txt1,txt2,num01,num02,date1,date2) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = Db.insertObject(insertChannelSql,v);
		return i>0?true:false;
	}

	@Override
	public boolean delete(Long k) throws SQLException {
		String deleteByChannelIdSql = "delete from channel where id=?";
		int i = Db.update(deleteByChannelIdSql,k);
		return i>0?true:false;
	}

	@Override
	public boolean update(Channel v) throws SQLException {
		return false;
	}

	@Override
	public Channel select(Long k) throws SQLException {
		String selectChannelSql = "select * from channel where id=?";
		Channel channel = Db.query(selectChannelSql, new BeanHandler<Channel>(Channel.class),k);
		return channel;
	}

	@Override
	public List<Channel> selectAll() throws SQLException {
		String selectAllChannelSql = "select * from channel";
		List<Channel> channelList = Db.query(selectAllChannelSql, new BeanListHandler<Channel>(Channel.class));
		return channelList;
	}

	public List<Channel> selectChannelByParentId(long parentId) throws SQLException {
		String byParentIdChannelSql = "select * from channel where parent_id=?";
		List<Channel> channelList = Db.query(byParentIdChannelSql, new BeanListHandler<Channel>(Channel.class),parentId);
		return channelList;
	}

	public Channel selectLater() throws SQLException {
		String selectLaterSql = "select * from channel order by id desc limit 1";
		Channel channel = Db.query(selectLaterSql,new BeanHandler<Channel>(Channel.class));
		return channel;
	}

}
