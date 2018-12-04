package com.redcmsv.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.redcmsv.beans.Admin;
import com.redcmsv.service.AdminService;
import com.redcmsv.servlet.core.Action;

@WebServlet("/admin/admin")
public class AdminManagerServlet extends Action{

	private static final long serialVersionUID = 1L;

	//当执行这个方法是 要讲所有的账号信息查询出进行显示
	@Override
	public void index() throws ServletException, IOException {
		
		List<Admin> adminList = AdminService.selectAll();
		
		this.setAttribute("adminList", adminList);
		this.foward("/WEB-INF/admin/adminManager.jsp");
	}

	public void insertAdmin() {
		Admin admin = new Admin();
		try {
			this.getBean(admin);
			System.out.println(admin.getUpur());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean b = AdminService.insertAdmin(admin);
		System.out.println(b);
		try {
			index();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAdmin() {
		int adminId = this.getInt("adminId");
		boolean b = AdminService.deleteAdmin(adminId);
		System.out.println(b);
		try {
			index();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateAdmin() {
		Admin admin = new Admin();
		try {
			this.getBean(admin);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean b = AdminService.updateAdmin(admin);
		System.out.println(b);
		try {
			index();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
