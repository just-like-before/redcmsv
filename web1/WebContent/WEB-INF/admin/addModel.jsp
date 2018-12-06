<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>模块管理</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="../favicon.ico"> 
    <link href="../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
	
				<div class="col-sm-6 col-sm-offset-4">
						<h1 style="color: salmon;">智利打造更好的模型</h1>
				</div>
				
				<div class="ibox-content forum-container">
					
					
					<form action="model" method="post" class="form-horizontal">
						<input type="hidden" name="action" value="addModel">
						<!--第一行 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">模型名</label>
							<div class="col-sm-4">
								<input type="text" name="name" placeholder="请输入模型名" class="form-control"/>
							</div>
							
							<label class="col-sm-2 control-label">路径</label>
							<div class="col-sm-4">
								<input type="text" name="path" placeholder="请输入路径" class="form-control"/>
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
										<input type="checkbox" value="1" name="has_content"/>是否单页
									</label>
								</div>
							</div>
							
							<label class="col-sm-2 control-label">排序</label>
							<div class="col-sm-2">
								<select name="priority" class="form-control">
									<c:forEach begin="1" end="10" var="i">
										<option value="${i }">${i }</option>
									</c:forEach>
								</select>
							</div>
							
							<div>
								<div class="col-sm-2">
									<label>
										<input type="checkbox" value="1" name="is_def"/>是否默认
									</label>
								</div>
							</div>
						</div>
						
						<!--第三行 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">标题图</label>
							<div class="col-sm-4">
								<input type="text" name="title_width" value="130" />
								x
								<input type="text" name="title_height" value="130" />
							</div>
							
							<label class="col-sm-2 control-label">内容图</label>
							<div class="col-sm-4">
								<input type="text" name="content_width" value="310" />
								x
								<input type="text" name="content_height" value="310" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-6 col-sm-offset-6">
								<input type="submit" value="增加模型" class="btn btn-lg btn-success"/>
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