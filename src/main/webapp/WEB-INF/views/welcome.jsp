<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="pageName" value="welcome.jsp"/>
    ${pageName.substring(0,pageName.length()).toUpperCase()} <%=new Date().toLocaleString()%>
</body>
</html>
