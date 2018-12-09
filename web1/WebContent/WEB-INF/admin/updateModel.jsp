<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>"/>
<head>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>模块管理</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
	
				<div class="col-sm-6 col-sm-offset-4">
						<h1 style="color: salmon;">用你的慧眼修改我们的不足</h1>
				</div>
				
				<div class="ibox-content forum-container">
					
					
					<form action="admin/model" method="get" class="form-horizontal">
						<input type="hidden" name="action" value="updateModel">
						<input type="hidden" name="id" value="${model.id }"> 
						<!--第一行 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">模型名</label>
							<div class="col-sm-4">
								<input type="text" name="name" value="${model.name }" class="form-control"/>
							</div>
							
							<label class="col-sm-2 control-label">路径</label>
							<div class="col-sm-4">
								<input type="text" name="path" value="${model.path }" class="form-control"/>
							</div>
						</div>
						
						<!--第二行 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">模板</label>
							<div class="col-sm-2">
								<select name="template" class="form-control">
									<option value="1">模板</option>
								</select>
							</div>
							
							<div>
								<div class="col-sm-2">
									<label>
										<c:if test="${model.has_content==1 }">
											<input type="checkbox" value="1" checked="checked" name="has_content"/>是否单页
										</c:if>
										<c:if test="${model.has_content==0 }">
											<input type="checkbox" value="1" name="has_content"/>是否单页
										</c:if>
									</label>
								</div>
							</div>
							
							<label class="col-sm-2 control-label">排序</label>
							<div class="col-sm-2">
								<select name="priority" class="form-control">
									<c:forEach begin="1" end="10" var="i">
										<c:if test="${model.priority==i }">
											<option value="${i }" selected="selected">${i }</option>
										</c:if>
										<option value="${i }">${i }</option>
									</c:forEach>
								</select>
							</div>
							
							<div>
								<div class="col-sm-2">
									<label>
										<c:if test="${model.is_def==1 }">
											<input type="checkbox" value="1" checked="checked" name="is_def"/>是否默认
										</c:if>
										<c:if test="${model.is_def==0 }">
											<input type="checkbox" value="1" name="is_def"/>是否默认
										</c:if>
									</label>
								</div>
							</div>
						</div>
						
						<!--第三行 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">标题图</label>
							<div class="col-sm-4">
								<input type="text" name="title_width" value="${model.title_width }" />
								x
								<input type="text" name="title_height" value="${model.title_height }" />
							</div>
							
							<label class="col-sm-2 control-label">内容图</label>
							<div class="col-sm-4">
								<input type="text" name="content_width" value="${model.content_width }" />
								x
								<input type="text" name="content_height" value="${model.content_height }" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-6 col-sm-offset-6">
								<input type="submit" value="修改模型" class="btn btn-lg btn-success"/>
							</div>
						</div>
					</form>
				</div>
	
			</div>
		</div>
	</div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <!-- Peity -->
    <script src="js/plugins/peity/jquery.peity.min.js"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>
</body>
</html>