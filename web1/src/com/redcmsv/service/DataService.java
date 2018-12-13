package com.redcmsv.service;

import java.sql.SQLException;
import java.util.List;

import com.redcmsv.beans.Channel;
import com.redcmsv.beans.DataField;
import com.redcmsv.daoImp.ChannelDaoImp;
import com.redcmsv.daoImp.DataFieldDaoImp;

public class DataService {
	
	private static DataFieldDaoImp dfd = new DataFieldDaoImp();
	private static ChannelDaoImp cdi = new ChannelDaoImp();

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

	public static List<Channel> selectAllChannel() {
		List<Channel> channelList = null;
		try {
			channelList = cdi.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return channelList;
	}

}
