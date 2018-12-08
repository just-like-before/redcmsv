<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.channelManager.com/tags" prefix="cl" %>
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
				<div class="ibox float-e-margins">

					<div class="ibox-title">
						<h5>栏目管理
                            <button type="button" data-placement="right" data-html="true" 
 	   						data-content="<c:forEach items='${modelList }' var='model'><a href='channel?action=addChannelToFoward&model_id=${model.id }&name=${model.name }' class='btn btn-xs btn-success'>${model.name }</a></br></c:forEach>" 
 	   						id="ashow" class="btn btn-success">＋增加栏目</button>
                        </h5>

						<div class="ibox-tools">
							<a class="collapse-link">
								<i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					
					<div class="ibox-content" style="font-size:12px;">
						<table class="table table-striped table-hover table-responsive">
							<tr>
								<th align='center'>序号</th>
								<th>栏目名称</th>
								<th>模型</th>
								<th>排序</th>
								<th>管理</th>
							</tr>
							<cl:channelList/>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script src="../js/jquery.min.js?v=2.1.4"></script>
	<script src="../js/bootstrap.min.js?v=3.3.6"></script>

	<script type="text/javascript">
		$(function() {
			var show = false;
			$("#ashow").click(function() {
				if(!show) {
					show = true;
					$("#ashow").popover('show');
				} else {
					show = false;
					$("#ashow").popover('hide');
				}

			});
		});
	</script>
</body>
</html>