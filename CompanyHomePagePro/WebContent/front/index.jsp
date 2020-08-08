<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的首页</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" media="all">
</head>

<body>
<%@ include file="common_header.jsp" %>
<!-- 轮播 -->
<div id="fwslider" style="height:500px;">
    <div class="slider_container">
        <div class="slide" style="opacity:1;z-index:0;display:none;">
            <img id="img1" src="img/img1.jpg"></div>
        <div class="slide" style="opacity:1;z-index:1;display:block;">
            <img id="img2" src="img/img2.jpg"></div>
        <div class="slide" style="opacity:1;z-index:1;display:block">
            <img id="img3" src="img/img3.jpg"></div>
        <div class="slide" style="opacity:1;z-index:0;display:none;">
            <img id="img4" src="img/img4.jpg"></div>
        <div class="slide" style="opacity:1;z-index:0;display:none;">
            <img id="img5" src="img/img5.jpg"></div>
    </div>
    <div class="timers" style="width:180px;"></div>
    <div class="slidePrev" style="left:0px;top:252px;">
        <span></span>
    </div>
    <div class="slideNext" style="right:0px;top:252px;opacity:0.5">
        <span></span>
    </div>
</div>
<%@ include file="common_button.jsp" %>
<!-- 版权声明 -->
<%@include file="common_footer.jsp" %>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/fwslider.js"></script>
</html>