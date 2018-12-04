package com.redcmsv.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.redcmsv.beans.Model;
import com.redcmsv.service.ModelService;
import com.redcmsv.servlet.core.Action;

@WebServlet("/admin/model")
public class ModelServlet extends Action{

	private static final long serialVersionUID = 1L;

	@Override
	public void index() throws ServletException, IOException {
		ModelService ms = new ModelService();
		List<Model> modelList = ms.selectAllModel();
		
		this.setAttribute("modelList", modelList);
	}
	
	public void updateModel() {
		
	}
	
	public void deleteModel() {
		long modelId = this.getInt("modelId");
		ModelService ms = new ModelService();
		boolean b = ms.updateModel(modelId);
	}

}
