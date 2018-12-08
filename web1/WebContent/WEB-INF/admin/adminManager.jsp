<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>首页</title>

    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <link rel="shortcut icon" href="../favicon.ico"> 
    <link href="../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
	
				<div class="ibox-content m-b-sm border-bottom">
					<div class="p-xs">
						<div class="pull-left m-r-md">
							<i class="fa fa-globe text-navy mid-icon"></i>
						</div>
						<h2>Redcmsv后台用户管理</h2>
						<span>修改要谨慎，密码要牢记</span>
					</div>
				</div>
	
				<div class="ibox-content" style="font-size:12px;">
					<form class="form-inline" method="post" action="admin">
						<input type="hidden" name="action" value="insertAdmin">
						<div class="form-group">
							<input class="form-control" type="email" name="uname" />
						</div>
						
						<div class="form-group">
							<input class="form-control" type="password" name="upwd" />
						</div>
						
						<div class="form-group">
							<select class="form-control" name="upur">
								<option value="100000">管理员</option>
								<option value="010000">普通管理员</option>
								<option value="001000">一般</option>
							</select>
						</div>
						
						<button type="submit" class="btn btn-info">增加</button>
					</form>
					
					<table class="table table-striped">
						<tr>
							<th></th>
							<th>#</th>
							<th>用户名</th>
							<th>密码</th>
							<th>级别</th>
							<th>管理</th>
						</tr>
						
						<c:forEach items="${adminList }" var="admin">
						<form action="admin" method="post">
							<input type="hidden" name="action" value="updateAdmin">
							<input type="hidden" name="id" value="${admin.id }">
							<tr>
								<td>${admin.id }</td>
								<td>
									<input name="uname" type="email" class="form-control" value="${admin.uname }"/>	
								</td>
								
								<td>
									<input name="upwd" type="text" class="form-control" placeholder="请输入新密码"/>
								</td>
								
								<td>
									<select name="upur" class="form-control">
										<option value="100000" ${admin.upur.startsWith("100")?"selected='selected'":"" }>管理员</option>
										<option value="010000" ${admin.upur.startsWith("010")?"selected='selected'":"" }>普通管理员</option>
										<option value="001000" ${admin.upur.startsWith("001")?"selected='selected'":"" }>一般</option>
									</select>
								</td>
								
								<td>
									<input type="submit" value="修改" class="btn btn-danger"/>
									<a class="btn btn-info" href="admin?action=deleteAdmin&adminId=${admin.id }">删除</a>
								</td>
							</tr>
						</form>
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