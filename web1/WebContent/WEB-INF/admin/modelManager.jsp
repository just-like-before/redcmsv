<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>"/>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>模块</title>
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
	
				<div class="ibox-content m-b-sm border-bottom">
					<div class="p-xs">
						<h2>Redcmsv后台模型管理</h2>
						<span>尽情发挥你的想象吧。</span>
					</div>
				</div>
	
				<div class="ibox-content forum-container">
					<a href="admin/model?action=addModelToFoward" class="btn btn-success">增加模型</a>
					
					<table class="table table-striped">
						<tr>
							<th>#</th>
							<th>模型名</th>
							<th>路径</th>
							<th>是否默认</th>
							<th>操作</th>
						</tr>
						
						<c:forEach items="${modelList }" var="model">
						<tr>
							<td>${model.id }</td>
							<td>${model.name }</td>
							<td>${model.path }</td>
							<td>${model.is_def }</td>
							<td>
								<a href="admin/model?action=updateModelTofoward&modelId=${model.id }" class="btn btn-info">修改</a>
								<a href="admin/model?action=deleteModel&modelId=${model.id }" class="btn btn-danger">删除</a>
								<a href="admin/model?action=fieldManagerTofoward&model_id=${model.id }&is_channel=0" class="btn btn-primary">内容字段管理</a>
								<a href="admin/model?action=fieldManagerTofoward&model_id=${model.id }&is_channel=1" class="btn btn-warning">栏目字段管理</a>
							</td>
						</tr>
						</c:forEach>
						
					</table>
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