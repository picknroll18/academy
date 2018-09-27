<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=1">
<link href="/academy/resources/partners/sist/css/style.css" type="text/css" rel="stylesheet">
<title>아카데미 관리자 페이지</title>
</head>
<body>
	<!-- header -->
	<tiles:insertAttribute name="header" />
	<!-- body -->
	<div id="body">
		<!-- aside -->
	 	<tiles:insertAttribute name="aside" />
	 	<!-- main -->
	 	<tiles:insertAttribute name="main" />
 	</div>
 	<!-- footer -->
	<tiles:insertAttribute name="footer" />
</body>
</html>