<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <%@include file="/WEB-INF/views/taglib.jsp"%>
    <title>Title</title>
    <script type="text/javascript" src="${ctxStatic}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            buildPSelect();
            buildCSelect();
        });

        function buildCSelect(){
            $("#cities").change(function(){
                var cityCode = $(this).val();
                if(cityCode){
                    $.ajax({
                        url : "${ctx}/pca/getAreas.shtml",
                        method : "post",
                        dataType :"json",
                        data :{"cityCode":cityCode},
                        success : function(result){
                            var $sel = $("#areas");
                            $sel.empty();
                            $sel.append("<option value=''>请选择</option>");
                            result.forEach(function(item,index){
                                $sel.append("<option value='"+item.areaCode+"'>"+item.areaName+"</option>");
                            });
                        }
                    });
                }
            });
        }

        function buildPSelect(){
            $("#provinces").change(function(){
                var provCode = $(this).val();
                if(provCode){
                    $.ajax({
                        url : "${ctx}/pca/getCities.shtml",
                        method : "post",
                        dataType :"json",
                        data :{"provCode":provCode},
                        success : function(result){
                            var $sel = $("#cities");
                            $sel.empty();
                            $sel.append("<option value=''>请选择</option>");
                            result.forEach(function(item,index){
                                $sel.append("<option value='"+item.cityCode+"'>"+item.cityName+"</option>");
                            });
                        }
                    });
                }
            });
        }

        function savePCAInfo(){
            if(!$("#provinces").val() || !$("#cities").val() || !$("#areas").val()){
                alert("都必须选择!");
                return false;
            }
            var params = $("#submitForm").serializeArray();
            $.ajax({
                type : "POST",
                url : "${ctx}/pca/savePCA.shtml",
                data : params,
                success : function(result) {
                    alert(result);
                },
            });
            return false;
        }
    </script>
</head>
<body>
    <form id="submitForm" method="post" action="" onsubmit="javascript: return(savePCAInfo());">
        省:
        <select id="provinces" name="pCode">
            <option value="">请选择</option>
            <c:forEach var="pro" items="${provinceList}">
                <option value="${pro.provinceCode}">${pro.provinceName}</option>
            </c:forEach>
        </select>
        市:
        <select id="cities" name="cCode">
            <option value="">请选择</option>
        </select>
        县:
        <select id="areas" name="aCode">
            <option value="">请选择</option>
        </select>
        <button type="submit" >提交</button>
    </form>
</body>
</html>
