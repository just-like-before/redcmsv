<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.wabTag.com/tags" prefix="cms" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<cms:channelList parentId="1">
		<li><cms:channel name="name"/></li>
	</cms:channelList>
	<cms:channelInfo name="张" id="3"/>
</ul>
</body>
</html>