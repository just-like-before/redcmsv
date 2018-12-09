<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <link rel="shortcut icon" href="../favicon.ico"> 
    <link href="../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css?v=4.1.0" rel="stylesheet">
    
    <link rel="stylesheet" href="../css/plugins/webuploader/webuploader.css" />
	<script charset="utf-8" src="../kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="../kindeditor/lang/zh-CN.js"></script>
    <script src="../js/jquery.min.js?v=2.1.4"></script>
	<script type="text/javascript" src="../js/plugins/webuploader/webuploader.min.js" ></script>
</head>
<body>

<form action="demo">
     	<div id="pics1">1</div>
        <ul id="shows1"></ul>
        <script type="text/javascript">
			$(function() {
			  // 初始化Web Uploader
			var uploader1 = WebUploader.create({
			    // 选完文件后，是否自动上传。
			    auto: true,
			    // swf文件路径
			    swf: 'js/plugins/webuploader/Uploader.swf',
			    // 文件接收服务端。
			    server: 'admin/uploadpic',
			    // 选择文件的按钮。可选。
			    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
			    pick:  '#pics1',
			    // 只允许选择图片文件。
			    accept: {
			        title: 'Images',
			        extensions: 'gif,jpg,jpeg,bmp,png',
			        mimeTypes: 'image/*'
			    }
			});
			
			
				});
			</script> 
        
        <br>
     	<input type="submit" value="提交">
	</form>
	<script src="../js/bootstrap.min.js?v=3.3.6"></script>
	<script src="../js/plugins/layer/laydate/laydate.js"></script>
</body>
</html>