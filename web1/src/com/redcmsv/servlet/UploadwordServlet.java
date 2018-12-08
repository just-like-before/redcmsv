package com.redcmsv.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSONObject;
import com.redcmsv.daoImp.Db;

@WebServlet("/admin/uploadWord")
public class UploadwordServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		String pathSave = req.getServletContext().getRealPath("/")+"ups/";
		
		String saveUrl = req.getServletContext()+"/ups/";
		
		//定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		
		//最大文件大小
		long maxSize = 1000000;
		
		if(!ServletFileUpload.isMultipartContent(req)) {
			pw.println(getError("请选择文件"));
			return;
		}
		
		File uploadDir = new File(pathSave);
		if(!uploadDir.isDirectory()) {
			pw.println(getError("上传路径不存在"));
			return;
		}
		
		if(!uploadDir.canWrite()) {
			pw.println(getError("上传路径没有权限"));
			return;
		}
		
		String dirName = req.getParameter("dir");
		if(dirName == null) {
			dirName = "image";
		}
		
		if(!extMap.containsKey(dirName)) {
			pw.println(getError("目录名不正确"));
			return;
		}
		
		pathSave += dirName + "/";
		saveUrl +=dirName + "/";
		File saveDirFile = new File(pathSave);
		if(!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		pathSave += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(pathSave);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		try {
			List<FileItem> items = upload.parseRequest(req);
			Iterator<FileItem> iter = items.iterator();
			while(iter.hasNext()) {
				FileItem item = (FileItem)iter.next();
				String fileName = item.getName();
				//long fileSize = item.getSize();
				if(!item.isFormField()) {
					if(item.getSize() > maxSize) {
						pw.println(getError("上传文件大小超过限制"));
						return;
					}
					
					String fileExt = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
					if(!Arrays.asList(extMap.get(dirName).split(",")).contains(fileExt)) {
						pw.println(getError("上传文件是不允许的扩展名.只允许"+extMap.get(dirName)+"格式"));
						return;
					}
					
					SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
					String newFileName = sd.format(new Date())+"_"+new Random().nextInt(1000)+"."+fileExt;
					
					File uploadFile = new File(pathSave,newFileName);
					item.write(uploadFile);
					Db.update("insert into attachs(path,mimetype,orgname) values(?,?,?)",
							saveUrl+"/"+newFileName,item.getContentType(),item.getName());
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toJSONString();
	}

}
