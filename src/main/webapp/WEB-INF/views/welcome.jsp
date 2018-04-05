<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="pageName" value="welcome.jsp"/>
    ${pageName.substring(0,pageName.length()).toUpperCase()} <%=new Date().toLocaleString()%>
    <shiro:hasPermission name="user:manager">
        <a href="http://www.baidu.com">点击进入管理界面</a>
    </shiro:hasPermission>
    <shiro:lacksPermission name="user:manage">
        没有管理权限
    </shiro:lacksPermission>
</body>
</html>
