package com.redcmsv.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutoCreateSql {

	@SuppressWarnings("unused")
	public static void main(String[] args)throws Exception
	{
		String tablename="admin";
		//ssString dataBasename="redcmsv6";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/redcmsv6","root","123456");
		
		Statement stat=con.createStatement();
		ResultSet rs=stat.executeQuery("select * from "+tablename);
		ResultSetMetaData rmd=rs.getMetaData();
		
		int count=rmd.getColumnCount();
		
		List<String> flist=new ArrayList<String>();
	
		
		StringBuilder insert=new StringBuilder();
		
		for(int i=0;i<count;i++)
		{
			if("id".equals(rmd.getColumnName(i+1)))continue;
			flist.add(rmd.getColumnName(i+1));
		}
		
		StringBuilder field=new StringBuilder();
		StringBuilder query=new StringBuilder();
		
		StringBuilder update=new StringBuilder();
		for(int i=0;i<flist.size();i++)
		{
			if(i<flist.size()-1)
			{
			field.append(flist.get(i)+",");
			query.append("?,");
			update.append(flist.get(i)+"=?,");
			}
			else
			{
				field.append(flist.get(i));	
				query.append("?");
				update.append(flist.get(i)+"=?");
			}
		}
		
		String s1="insert into "+tablename+"("+field.toString()+") values("+query.toString()+")";
		System.out.println(s1);
     
		
		String s2="update "+tablename+" set "+update.toString()+" where id=?";
		System.out.println(s2);
		
		System.out.println("delete from "+tablename+" where id=?");
		
	}
	
	
	@SuppressWarnings("unused")
	public static void run() {
		Date d = new Date();
		String tablename="t";
		String dataBasename="redcmsv6";
		System.out.println("dd");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/yi","root","123456");
			Statement stat=con.createStatement();
			stat.executeUpdate("insert into "+tablename +"(d,de) values (1,2)");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
