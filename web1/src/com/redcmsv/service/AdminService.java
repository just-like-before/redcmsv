package com.redcmsv.service;

import java.sql.SQLException;
import java.util.List;

import com.redcmsv.beans.Admin;
import com.redcmsv.daoImp.AdminDaoImp;
import com.redcmsv.utils.Md5Encrypt;

public class AdminService {
	
	private static AdminDaoImp adi = new AdminDaoImp();

	public static List<Admin> selectAll() {
		List<Admin> adminList = null;
		try {
			adminList = adi.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminList;
	}

	public static boolean insertAdmin(Admin admin) {
		boolean bool = false;
		try {
			bool = adi.insert(admin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	public static boolean deleteAdmin(Integer adminId) {
		boolean bool = false;
		try {
			bool = adi.delete(adminId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	public static boolean updateAdmin(Admin admin) {
		boolean bool = false;
		try {
			String upwd = adi.select(admin.getId()).getUpwd();
			String p = admin.getUpwd();
			if(p == null || p.equals("") || p.equals(upwd)) {
				p = upwd;
			}
			
			admin.setUpwd(Md5Encrypt.md5(p));
			bool = adi.update(admin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	

}
