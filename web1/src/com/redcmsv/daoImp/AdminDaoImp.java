package com.redcmsv.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcmsv.dao.AdminDao;
import com.redcmsv.utils.Md5Encrypt;
import com.redcmsv.beans.Admin;

@SuppressWarnings("hiding")
public class AdminDaoImp implements AdminDao{

	@Override
	public boolean insert(Admin v) throws SQLException {
		boolean bool = false;
		String insertAdminSql = "insert into admin (uname,upwd,upur,active) values (?,?,?,?)";
		int i = Db.update(insertAdminSql,v.getUname(),Md5Encrypt.md5(v.getUpwd()),v.getUpur(),v.getActive());
		if(i > 0) {
			bool = true;
		}
		return bool;
	}

	@Override
	public boolean delete(Integer k) throws SQLException {
		boolean bool = false;
		String deleteAdminSlq = "delete from admin where id=?";
		int i = Db.update(deleteAdminSlq,k);
		if(i > 0) {
			bool = true;
		}
		return bool;
	}

	@Override
	public boolean update(Admin v) throws SQLException {
		String updateAdminSql = "update admin set uname=?,upwd=?,upur=?,active=? where id=?";
		int i = Db.updateObject(updateAdminSql, v, v.getId());
		return i > 0?true:false;
	}

	@Override
	public Admin select(Integer k) throws SQLException  {
		String selectAdmin = "select * from admin where id=?";
		Admin admin = Db.query(selectAdmin, new BeanHandler<Admin>(Admin.class),k);
		return admin;
	}

	@Override
	public List<Admin> selectAll() throws SQLException {
		String selectAllAdminSlq = "select * from admin";
		List<Admin> adminList = Db.query(selectAllAdminSlq, new BeanListHandler<Admin>(Admin.class));
		return adminList;
	}

	
}
