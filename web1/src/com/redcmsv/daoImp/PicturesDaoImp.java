package com.redcmsv.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcmsv.beans.Pictures;
import com.redcmsv.dao.PicturesDao;

public class PicturesDaoImp implements PicturesDao{

	@Override
	public boolean insert(Pictures v) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long k) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Pictures v) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pictures select(Long k) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pictures> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updatePictures(Pictures pictures) throws SQLException {
		String updatePicturesSql = "update pictures set channel_id=?,picdis=?,priority=?,sequ=? where id=?";
		int i = Db.updateObject(updatePicturesSql, pictures, pictures.getId());
		return i>0?true:false;
	}

	public boolean deleteByChannelId(long channel_id) throws SQLException {
		String deleteByChannelIdSql = "delete from pictures where channel_id=?";
		int i = Db.update(deleteByChannelIdSql,channel_id);
		return i>0?true:false;
	}

	public List<Pictures> selectPicturesByCI(long channel_id,int i) throws SQLException {
		String selectPicturesSql = "select * from pictures where channel_id=? and sequ=?";
		List<Pictures> picturesList = Db.query(selectPicturesSql, new BeanListHandler<Pictures>(Pictures.class),channel_id,i);
		return picturesList;
	}

}
