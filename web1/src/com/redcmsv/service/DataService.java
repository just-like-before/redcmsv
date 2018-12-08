package com.redcmsv.service;

import java.sql.SQLException;
import java.util.List;

import com.redcmsv.beans.DataField;
import com.redcmsv.daoImp.DataFieldDaoImp;

public class DataService {
	
	private static DataFieldDaoImp dfd = new DataFieldDaoImp();

	public static List<DataField> selectAll() {
		List<DataField> dataFieldList = null;
		try {
			dataFieldList = dfd.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataFieldList;
	}

}
