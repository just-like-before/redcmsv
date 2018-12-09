package com.redcmsv.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.redcmsv.servlet.core.Action;

@WebServlet("/admin")
public class IndexServlet extends Action{

	private static final long serialVersionUID = 1L;

	@Override
	public void index() throws ServletException, IOException {
		this.foward("/WEB-INF/admin/index.jsp");
		
	}

}
