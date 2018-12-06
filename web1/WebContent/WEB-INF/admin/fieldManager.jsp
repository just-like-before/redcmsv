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
<body style="font-size: 12px;">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
	
				<div class="ibox float-e-margins">
					<h4>模型${is_channel==0?"内容":"栏目" }字段管理-${model.name }</h4>
					
					<div class="ibox-content" style="font-size: 12px;">
						<form class="form-inline" method="post">
							<input type="hidden" name="action" value="addModelField">
							<input type="hidden" name="is_channel" value="${is_channel }">
							<input type="hidden" name="modelId" value="${model.id }">
							<div class="form-group">
								<input class="form-control" type="text" name="field" placeholder="字段名"/>
							</div>
							
							<div class="form-group">
								<input class="form-control" type="text" name="field_dis" placeholder="描述"/>
							</div>
							
							<div class="form-group">
								<select class="form-control" name="data_type">
									<option value="1">字符串</option>
									<option value="2">数字</option>
									<option value="3">文本</option>
									<option value="4">日期</option>
									<option value="5">图片</option>
									<option value="6">图集</option>
								</select>
							</div>
							
							<div class="form-group">
								<input class="form-control" type="checkbox" name="is_display" value="1"/>显示
							</div>
							
							<div class="form-group">
								<select class="form-control" name="priority">
									<c:forEach begin="1" end="10" var="i">
										<option value="${i }">${i }</option>
									</c:forEach>
								</select>
							</div>
							
							<div class="form-group">
								<input class="form-control" type="checkbox" name="is_required" value="1"/>必须
							</div>
							
							<div class="form-group">
								<input class="form-control" type="checkbox" name="is_single" value="1"/>独行
							</div>
							
							<div class="form-group">
								<input class="form-control" type="text" name="def_value" placeholder="默认值"/>
							</div>
							
							<button type="submit" class="btn btn-info">增加</button>
						</form>
						
						<table class="table table-striped table-hover table-responsive">
							<tr>
								<th >序号</th>
	                            <th>字段名</th>
	                            <th>描述</th>
	                            <th>类型</th>
	                            <th>启用</th>
	                            <th>顺序</th>
	                            <th>必须</th>
	                            <th>独行</th>
	                            <th>长度</th>
	                            <th>默认值</th>
	                            <th>操作</th>
							</tr>
							
							<c:forEach items="${modelItemList }" var="modelItem">
							<form action="#" method="post">
								<input type="hidden" name="action" value="updateFiedlOfModel">
								<input type="hidden" name="is_channel" value="${is_channel }">
								<input type="hidden" name="modelId" value="${model.id }">
								<tr>
									<td>
										<input type="checkbox" value="${modelItem.is_display }" name="is_display"/>
									</td>
									
									<td>${modelItem.field }</td>
									
									<td>
										<input type="text" class="form-control" value="${modelItem.field_dis }" name="field_dis"/>	
									</td>
									
									<td>
										<div class="form-group">
											<select class="form-control" name="data_type">
												<option value="1" ${modelItem.data_type==1?"selected='selected'":"" }>字符串</option>
												<option value="2" ${modelItem.data_type==2?"selected='selected'":"" }>数字</option>
												<option value="3" ${modelItem.data_type==3?"selected='selected'":"" }>文本</option>
												<option value="4" ${modelItem.data_type==4?"selected='selected'":"" }>日期</option>
												<option value="5" ${modelItem.data_type==5?"selected='selected'":"" }>图片</option>
												<option value="6" ${modelItem.data_type==6?"selected='selected'":"" }>图集</option>
											</select>
										</div>
									</td>
							
									<td>
										<c:if test="${modelItem.is_display==1 }">
											<input type="checkbox" value="1" name="is_display" checked="checked"/>
										</c:if>
										<c:if test="${modelItem.is_display==0 }">
											<input type="checkbox" value="1" name="is_display"/>
										</c:if>
									</td>
									
									<td>
										<div class="form-group">
											<select class="form-control" name="priority">
												<c:forEach begin="1" end="10" var="i">
													<c:if test="${modelItem.priority==i }">
														<option value="${i }" selected="selected">${i }</option>
													</c:if>
													<c:if test="${modelItem.priority!=i }">
														<option value="${i }">${i }</option>
													</c:if>
												</c:forEach>
											</select>
										</div>
									</td>
									
									<td>
										<div class="form-group">
											<c:if test="${modelItem.is_required==1 }">
												<input type="checkbox" value="1" name="is_required" checked="checked"/>
											</c:if>
											<c:if test="${modelItem.is_required==0 }">
												<input type="checkbox" value="1" name="is_required"/>
											</c:if>
										</div>
									</td>
									
									<td>
										<div class="form-group">
											<c:if test="${modelItem.is_single==1 }">
												<input type="checkbox" value="1" name="is_single" checked="checked"/>
											</c:if>
											<c:if test="${modelItem.is_single==0 }">
												<input type="checkbox" value="1" name="is_single"/>
											</c:if>
										</div>
									</td>
									
									<td>
										<div class="form-group">
											<input class="form-control" type="text" name="txt_size"/>
										</div>
									</td>
									
									<td>
										<div class="form-group">
											<input class="form-control" type="text" name="def_value"/>
										</div>
									</td>
				
									<td>
										<input type="submit" value="更新" class="btn btn-danger"/>
									</td>
								</tr>
							</form>
							</c:forEach>
						</table>
					</div>
					
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