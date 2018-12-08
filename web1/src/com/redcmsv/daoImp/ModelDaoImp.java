package com.redcmsv.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcmsv.beans.Model;
import com.redcmsv.dao.ModelDao;

public class ModelDaoImp implements ModelDao{

	@Override
	public boolean insert(Model v) throws SQLException {
		String insertModelSql = "insert into model(name,path,title_width,title_height,"
				+ "content_width,content_height,priority,has_content,is_def,template) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		int i = Db.insertObject(insertModelSql, v);
		return i>0?true:false;
	}

	@Override
	public boolean delete(Long k) throws SQLException {
		String deleteModelSql = "delete from model where id=?";
		int i = Db.update(deleteModelSql,k);
		return i>0?true:false;
	}

	@Override
	public boolean update(Model v) throws SQLException {
		String updateModelSql = "update model set name=?,path=?,title_width=?,"
				+ "title_height=?,content_width=?,content_height=?,priority=?,"
				+ "has_content=?,is_def=?,template=? where id=?";
		int i = Db.updateObject(updateModelSql, v, v.getId());
		return i>0?true:false;
	}

	@Override
	public Model select(Long k) throws SQLException {
		String selectModelSql = "select * from model where id=?";
		Model model = Db.query(selectModelSql, new BeanHandler<Model>(Model.class),k);
		return model;
	}

	@Override
	public List<Model> selectAll() throws SQLException {
		String selectAllModelSql = "select * from model";
		List<Model> modelList = Db.query(selectAllModelSql, new BeanListHandler<Model>(Model.class));
		return modelList;
	}

	public Model selectOfLastModel() throws SQLException {
		String selectOfLastModelSql = "select * from model order by id desc limit 1";
		Model model = Db.query(selectOfLastModelSql, new BeanHandler<Model>(Model.class));
		return model;
	}

	
}
