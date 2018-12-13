package com.redcmsv.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.redcmsv.beans.Channel;
import com.redcmsv.service.DataService;
import com.redcmsv.servlet.core.Action;

@WebServlet("/admin/data")
public class DataServlet extends Action{

	private static final long serialVersionUID = 1L;

	@Override
	public void index() throws ServletException, IOException {
		//查询所有的channel 栏目
		List<Channel> channelList = DataService.selectAllChannel();
		//
	}

}
