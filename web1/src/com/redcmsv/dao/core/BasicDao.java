package com.redcmsv.dao.core;

import java.sql.SQLException;
import java.util.List;

//dao层使用工厂模式 这是dao的顶层接口
public interface BasicDao<K,V> {
	
	//增
	boolean insert(V v) throws SQLException;
	
	//删
	boolean delete(K k) throws SQLException;
	
	//改
	boolean update(V v) throws SQLException;
	
	//查一个
	V select(K k) throws SQLException;
	
	//查所有
	List<V> selectAll() throws SQLException;
}
