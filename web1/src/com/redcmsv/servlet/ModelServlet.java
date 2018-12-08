package com.redcmsv.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.redcmsv.beans.Model;
import com.redcmsv.beans.ModelItem;
import com.redcmsv.service.ModelService;
import com.redcmsv.servlet.core.Action;

@WebServlet("/admin/model")
public class ModelServlet extends Action{

	private static final long serialVersionUID = 1L;

	@Override
	public void index() throws ServletException, IOException {
		List<Model> modelList = ModelService.selectAllModel();
		this.setAttribute("modelList", modelList);
		this.foward("/WEB-INF/admin/modelManager.jsp");
	}
	
	public void addModelField() {
		ModelItem modelItem = new ModelItem();
		try {
			this.getBean(modelItem);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean b = ModelService.addModelItem(modelItem);
		System.out.println("addModelField"+b);
		fieldManagerTofoward();
		
	}
	
	public void updateModelTofoward() {
		long modelId = this.getInt("modelId");
		Model model = ModelService.select(modelId);
		this.setAttribute("model", model);
		try {
			this.foward("/WEB-INF/admin/updateModel.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateModel() {
		Model model = new Model();
		try {
			this.getBean(model);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean b = ModelService.updateModel(model);
		System.out.println("updateModel"+b);
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
	
	public void fieldManagerTofoward() {
		//获得参数
		long modelId = this.getInt("model_id");
		byte is_channel = (byte)this.getInt("is_channel");
		
		//得到field页面到使用的数据
		List<ModelItem> modelItemList = ModelService.selectModelItemByMI(modelId,is_channel);
		Model model = ModelService.select(modelId);
		
		//将这些数据放在传入域中
		this.setAttribute("is_channel", is_channel);
		this.setAttribute("model", model);
		this.setAttribute("modelItemList", modelItemList);
		try {
			this.foward("/WEB-INF/admin/fieldManager.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//修改model的字段
	public void updateFiedlOfModel() {
		ModelItem modelItem = new ModelItem();
		try {
			this.getBean(modelItem);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean b = ModelService.updateFieldOfModelByMI(modelItem);
		System.out.println("updateFiedlOfModel"+b);
		fieldManagerTofoward();
	}
	
	public void deleteModel() {
		long modelId = this.getInt("modelId");
		boolean b = ModelService.deleteModel(modelId);
		System.out.println("deleteModel"+b);
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
	
	public void addModelToFoward() {
		try {
			this.foward("/WEB-INF/admin/addModel.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addModel() {
		//封装一个model
		Model model = new Model();
		try {
			this.getBean(model);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean b = ModelService.addModel(model);
		System.out.println("addModel"+b);
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
