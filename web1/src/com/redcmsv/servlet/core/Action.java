package com.redcmsv.servlet.core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

//这是所有servlet的基类 这个类中封装了很多的方法 简化了子类servlet的操作
public abstract class Action extends HttpServlet{
	
	protected HttpServletRequest req; 
	
	protected HttpServletResponse resp;

	private static final long serialVersionUID = 1L;

	public abstract void index() throws ServletException, IOException ;

	//tomcat容器首先调用这个方法 然后通过反射决定指定子类的那些方法
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action") != null?req.getParameter("action"):"index";
		
		Class cl = this.getClass();
		
		try {
			Method m = cl.getDeclaredMethod(action);
			if(m != null) {
				this.req = req;
				this.resp = resp;
				m.invoke(this);
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//通过指定的一个key获得请求的String类型value
	public String getString(String parameter) {
		String str = req.getParameter(parameter) != null?req.getParameter(parameter):"";
		return str;
	}
	
	//通过指定的一个key获得请求的int类型value
	public int getInt(String parameter) {
		int value = -1;
		String str = req.getParameter(parameter);
		if(str != null && str.matches("\\d+")) {
			value = Integer.parseInt(str);
		}
		return value;
	}
	
	//通过指定的一个key获得请求的String[]类型
	public String[] getStrings(String parameter) {
		String[] strs = {};
		strs = req.getParameterValues(parameter);
		return strs;
	}
	
	//传入一个对象 然后通过 post请求的内容进行封装
	public void getBean(Object bean) throws IllegalAccessException, InvocationTargetException {

		//当出现其他类型是 需要注册一个conver
		ConvertUtils.register(new Converter() {
			@SuppressWarnings("rawtypes")
			@Override
			public Object convert(Class arg0, Object arg1) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date d = null;
				try {
					d = sdf.parse(arg1.toString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return d;
			}
		}, Date.class);
		BeanUtils.populate(bean, req.getParameterMap());
	}
	
	//给request域这一个key value
	public void setAttribute(String str,Object obj) {
		req.setAttribute(str, obj);
	}
	
	//转发
	public void foward(String path) throws ServletException, IOException {
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	//重定向
	public void redrict(String location) throws IOException {
		resp.sendRedirect(location);
	}
	
	//给session域这一个key value
	public void setSession(String str,Object obj) {
		req.getSession().setAttribute(str, obj);
	}
}
