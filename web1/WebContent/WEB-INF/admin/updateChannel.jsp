<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.redcmsv.beans.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>"/>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    
    <link rel="stylesheet" href="css/plugins/webuploader/webuploader.css" />
	<script charset="utf-8" src="kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh-CN.js"></script>
    <script src="js/jquery.min.js?v=2.1.4"></script>
	<script type="text/javascript" src="js/plugins/webuploader/webuploader.min.js" ></script>
</head>
<body class="gray-bg" style="font-family:微软雅黑;">
	<%
		Channel ch = (Channel)request.getAttribute("channel");
		Class chClass = ch.getClass();	
	%>
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>修改栏目</h5>
					</div>

					<div class="ibox-content">
						<form class="form-horizontal" action="admin/channel" method="post">
							<input type="hidden" name="action" value="addChannel">
							<input type="hidden" name="model_id" value="${model.id }">
							<div class="form-group col-sm-4">
							    <label  class="col-sm-5 col-md-4 control-label">模型名</label>
							    <div class="col-sm-7 col-md-8">
							      	<a class="btn form-control disabled">${model.name }</a>
							    </div>
					      	</div>
					      	
					      	<div class="form-group col-sm-4">
							    <label  class="col-sm-5 col-md-4 control-label">父栏目</label>
							    <div class="col-sm-7 col-md-8">
							      	<select name="parent_id" class="form-control">
							      		<c:forEach items="${channelList }" var="cl">
							      			<option value="0">顶层栏目</option>
							      			<c:if test="${channel.parent_id==cl.id }">
							      				<option value="${cl.id }" selected="selected">${channel.name }</option>
							      			</c:if>
							      			<c:if test="${channel.parent_id!=cl.id }">
							      				<option value="${cl.id }">${cl.name }</option>
							      			</c:if>
							      		</c:forEach>
							      	</select>
							    </div>
					      	</div>
					      		
					      	<c:forEach items="${modelItemList }" var="modelItem">
					      	<c:set value="${modelItem.field }" var="mf" scope="request"></c:set>
					      	<%
					      		String field = (String) request.getAttribute("mf");
					      		Object result = "";
					      		try{
					      			java.lang.reflect.Field f = chClass.getDeclaredField(field);
						      		if(f != null){
						      			f.setAccessible(true);
						      			result = f.get(ch);
						      			request.setAttribute("result", result);
						      		}
					      		}catch(Exception e){
					      			
					      		}
					      		
					      		
					      	%>
					      	<c:if test="${modelItem.is_single==0 }"><!-- 1不是单独的一行 -->
					      			<div class="form-group col-sm-4">
									    <label  class="col-sm-5 col-md-4 control-label">${modelItem.field_dis }</label>
										<div class="col-sm-7 col-md-8">
					      		</c:if>
					      		
					      		<c:if test="${modelItem.is_single==1 }"><!-- 2单独的一行 -->
					      			<div class="form-group col-sm-12">
							      		<label class="col-sm-2 col-md-1 text-right">${modelItem.field_dis }</label>
							      		<div class="col-sm-10 col-md-11">
					      		</c:if>
					      		
					      		<c:choose>
					      		
					      			<c:when test="${modelItem.data_type==1 }"><!--4类型一 -->
					      				<c:choose>
					      					<c:when test="${modelItem.field.equals('tName') }"><!--5分表选择-->
					      						<select name="t_name" class="form-control">
										      		<option value="data1" ${result=="data1"?"selected='selected'":"" }>date1</option>
										      		<option value="data2" ${result=="data2"?"selected='selected'":"" }>date2</option>
										      		<option value="data3" ${result=="data3"?"selected='selected'":"" }>date3</option>
										      		<option value="data4" ${result=="data4"?"selected='selected'":"" }>date4</option>
										      	</select>
					      					</c:when>
					      					
					      					<c:when test="${modelItem.field.equals('priority') }"><!-- 6排序选择 -->
					      						<select name="priority" class="form-control">
										      		<c:forEach begin="1" end="10" var="i">
										      			<c:if test="${channel.priority==i }">
										      				<option value="${i }" selected="selected">${i }</option>
										      			</c:if>
										      			<c:if test="${channel.priority!=i }">
										      				<option value="${i }">${i }</option>
										      			</c:if>
										      		</c:forEach>
										      	</select>
					      					</c:when>
					      					
					      					<c:otherwise>
					      						<input type="text" name="${modelItem.field }" class="form-control" value="${result }">
					      					</c:otherwise>
					      				</c:choose>
					      			</c:when>
					      			
					      			<c:when test="${modelItem.data_type==2 }"><!-- 7数字 -->
					      				<c:if test="${modelItem.field.equals('priority') }">
					      					<select name="priority" class="form-control">
									      		<c:forEach begin="1" end="10" var="i">
									      			<c:if test="${channel.priority==i }">
										      			<option value="${i }" selected="selected">${i }</option>
									      			</c:if>
									      			<c:if test="${channel.priority!=i }">
									      				<option value="${i }">${i }</option>
									      			</c:if>
									      		</c:forEach>
									      	</select>
					      				</c:if>
					      				
					      				<c:if test="${!modelItem.field.equals('priority') }">
					      					<input type="number" name="${modelItem.field }" class="form-control" value="${result }">
					      				</c:if>
					      			</c:when>
					      			
					      			<c:when test="${modelItem.data_type==3 }"><!-- 8kindedtor -->
					      				<textarea name="${modelItem.field }" id="id${modelItem.id }"  style="width: 100%;height: 30px;">${result }</textarea>
								      	<script type="text/javascript">
								      		KindEditor.ready(function(K){
								      			window.editor = K.create('#id${modelItem.id}',{
								      				uploadJson : 'admin/upload',
							    					allowFileManager : false,
													fileManagerJson : '../jsp/file_manager_json.jsp'
								      			});
								      		});
								      	</script>
					      			</c:when>
					      			
					      			<c:when test="${modelItem.data_type==4 }"><!-- 9日期 -->
					      				<input  class="form-control layer-date" name="${modelItem.field}" 
					      				value="${result }" placeholder="YYYY-MM-DD hh:mm:ss" 
					      				onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
					      			</c:when>
					      			
					      			<c:when test="${modelItem.data_type==5 }">
					      				<img src="../img/upload.jpg" width="68" height="57" style="cursor: pointer;" id="${modelItem.field}_id" />
					      				
					      				<script type="text/javascript">
									        KindEditor.ready(function(K) {
									        	
												var editor = K.editor({
													uploadJson : 'admin/uploadpic',
													allowFileManager : false
												});
												
												K('#${modelItem.field}_id').click(function() {
													editor.loadPlugin('image', function() {
														editor.plugin.imageDialog({
															imageUrl : K('#${modelItem.field}_field').val(),
															clickFn : function(url, title, width, height, border, align) {
																K('#${modelItem.field}_field').val(url);
																K('#${modelItem.field}_id').attr("src",url);
																editor.hideDialog();
															}
														});
													});
												});
											});
										</script>
					      			</c:when>
					      			
					      			<c:when test="${modelItem.data_type==6 }">
					      				<div id="pics_${modelItem.field }">${modelItem.field_dis}</div>
											<ul id="shows_${modelItem.field }">
												<c:if test="${modelItem.field=='pics1'}">
										           <c:forEach items="${picture1 }" var="pics">
										              <li>
										              <img src="${pics.path}" width="30" height="30"/>
										              <input type='hidden' name='pics1_ids' value='${pics.id}'/>
										              <select name='pics1_priority'>
										              <%
										                for(int i=10;i>0;i--)
										                {
										                	  request.setAttribute("temii", i);
											        	  %>
											        	  <option value="<%=i%>"  ${pics.priority==temii?"selected=\"selected\"":""}><%=i%></option>
											        	  <%
										                }
										              %>
										              </select>
										              <input type='text' name='pics1_dis' placeholder='图片描述'  value="${pics.picdis}"/>
										              
										              </li>
										            </c:forEach>
									           </c:if>
									                 <c:if test="${modelItem.field=='pics2'}">
										           <c:forEach items="${picture2}" var="pics">
										               <li>
										              <img src="${pics.path}" width="30" height="30"/>
										              <input type='hidden' name='pics2_ids' value='${pics.id}'/>
										              <select name='pics2_priority'>
										              <%
										                for(int i=10;i>0;i--)
										                {
										                	  request.setAttribute("temii", i);
											        	  %>
											        	  <option value="<%=i%>"  ${pics.priority==temii?"selected=\"selected\"":""}><%=i%></option>
											        	  <%
										                }
										              %>
										              </select>
										              <input type='text' name='pics2_dis' placeholder='图片描述'  value="${pics.picdis}"/>
										              
										              </li>
										            </c:forEach>
									           </c:if>
											</ul>
											<script type="text/javascript">
												$(function() {
													
												  	// 初始化Web Uploader
													var uploader${modelItem.field } = WebUploader.create({
												    	// 选完文件后，是否自动上传。
													    auto: true,
													    // swf文件路径
													    swf: 'js/plugins/webuploader/Uploader.swf',
													    // 文件接收服务端。
													    server: 'admin/uploadpic',
													    // 选择文件的按钮。可选。
													    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
													    pick:  '#pics_${modelItem.field }',
													    // 只允许选择图片文件。
													    accept: {
													        title: 'Images',
													        extensions: 'gif,jpg,jpeg,bmp,png',
													        mimeTypes: 'image/*'
													    }
													});
													
													uploader${modelItem.field}.on( 'uploadSuccess', function( file,response ) {
														$("#shows_${modelItem.field}").append("<li><img src='"+response.url+"' width='30' height='30'/><input type='hidden' name='${modelItem.field}_ids' value='"+response.upid+"'/><select name='${modelItem.field}_priority'><c:forEach begin='1' end='10' var='proid'><option value='${proid}'>${proid}</option></c:forEach></select><input type='text' name='${modelItem.field}_dis' placeholder='图片描述' /></li>");
													});

													uploader${modelItem.field}.on( 'uploadError', function( file ) {
														$("#shows_${modelItem.field}").appendt('上传出错');
													});
												});
										</script> 
					      			</c:when>
					      			
					      			<c:otherwise>
			      						
			      					</c:otherwise>
					      		</c:choose>
					      	
						      		</div>
						      	</div>
					      	</c:forEach>
					      	
					      	
					      	<div class="form-group">
								<div class="col-sm-6">
									<input type="submit" value="修改栏目" class="btn btn-success"/>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/layer/laydate/laydate.js"></script>
</body>
</html>