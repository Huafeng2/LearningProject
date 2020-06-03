<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String socketPath = request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BBS </title>
    <!-- css -->
    <link href="<%=basePath %>css/autocomplete.css" rel="stylesheet">
    <link href="<%=basePath %>css/forum.css" rel="stylesheet">
    <link href="<%=basePath %>css/mod-dz-1.css" rel="stylesheet">
    <link href="<%=basePath %>css/style_6_common.css" rel="stylesheet">
    <link href="<%=basePath %>css/style_6_forum_index.css" rel="stylesheet">
    <link href="<%=basePath %>css/style_6_widthauto.css" rel="stylesheet">
    <link href="<%=basePath %>css/prestoge.css" rel="stylesheet">
    <link href="<%=basePath %>css/bdsstyle.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="<%=basePath %>bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath %>css/ityks.css" rel="stylesheet">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    	.page{
    		display:inline-block;
    		border: 1px solid ;
    		font-size: 20px;
    		width: 30px;
    		height: 30px;
    		background-color: #1faeff;
    		text-align: center;
    	}
    	a,a:hover{ text-decoration:none; color:#333}
    	
		.tbl {
		    background: #e5edf2 none repeat scroll 0 0;
		    border-right: 1px solid #c2d5e3;
		    overflow: hidden;
		    width: 160px;
		}
		
		.tbr {
		    hyphens: auto;
		    word-break: break-all;
		}
		
		.list-paddingleft-2 {
			padding-left: 36px;
		}
    </style>
  </head>
<body >

<div class="container-fluid">
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	  
	</div>
</div>
	<!-- 导航路径 -->
<div class="container-fluid" >
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">BBS</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li><a href="<%=basePath%>">首页 </a></li>
	        <li><a href="<%=basePath%>JinghuaContent">精华帖子</a></li>
	      </ul>
	      <form action="<%=basePath%>findMainByTitle" class="navbar-form navbar-left" role="search">
	        <div class="form-group">
	          <input type="text" name="mainTitle" class="form-control" placeholder="查找">
	          
	          <button type="submit" class="btn btn-default ">搜索</button>
	        </div>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
	      	<c:choose>
	      		<c:when test="${sessionScope.loginFlag}">
	      			<li><a href="javascript:void(0)" onclick="alert('会员')">会员:${sessionScope.loginEntity.wxname}</a></li>
	      			<li><a href="<%=basePath%>/login/logout" >退出</a></li>
	      		</c:when>
	      		<c:otherwise>
	      			<li><a href="<%=basePath %>login.jsp">登录</a></li>
	      		</c:otherwise>
	      	</c:choose>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	<ol class="breadcrumb">
		  <li><a href="<%=basePath %>">首页</a></li>
		  <li><a href="${path2 }">${sName }</a></li>
		  <li class="active">${main.main_title }</li>
	</ol>
</div>

<div class="container-fluid" >
	
	<div class="row">
		<div class="col-xs-7">
			<span style="padding-left: 10px;">
			<button type="button" class="btn btn-primary">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>发帖</button>
			<a class="btn btn-primary" href="#ueditor_">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>回复</a></span>
		</div>
		<div class="col-xs-5 text-nowrap" >
			
		</div>
	</div>
	
	<table class="table table-bordered">
		<tr>
			<td class="tbl">
				<div style="text-align: center;">
					<p>楼主</p>
					<a><img alt="" src="<%=basePath %>image/ico_000.gif" /></a>
				</div>	
				<table class="table" style="background-color:#e5edf2; ">
						<tr>
							<td>昵称:</td>
							<td>${main.base_name }</td>
						</tr>
						<tr>
							<td>性别:</td>
							<td>${main.base_sex }</td>
						</tr>
						<tr>
							<td>年龄:</td>
							<td>${main.base_age }</td>
						</tr>
						<tr>
							<td>发帖数:</td>
							<td>${main.base_fatieshu }</td>
						</tr>
						<tr>
							<td>回帖数:</td>
							<td>${main.base_huitieshu }</td>
						</tr>
				</table>
			</td>
			
			<td class="tbr">
				<div style="height: 65px;padding-left: 20px;padding-top: 1px;">
					<h3><small><a style="color: #ifaeff" >[${main.main_flag }]</a></small> <a style="color: #ifaeff">${main.main_title }</a></h3>
				</div>
				<div style="width:98%;height:1px;margin-bottom:10px;padding:0px;background-color:#D5D5D5;overflow:hidden;"></div>
					<p class="text-right" style="padding-right: 90px;">
					<span style="padding-right: 30px;">
					<a style="color: #78BA00;">发表于:${main.main_creatime }</a>
					 | 
					<a style="color: #78BA00;">只看作者</a>
					 | 
					<a style="color: #78BA00;">倒序查看</a>
					 | 
					<a style="color: #78BA00;">共${count }层</a>
					</span>
					<span><input type="text" style="width: 32px;"><a href="javascript:void(0)" style="color: #78BA00;" onclick="alert('跳楼')"><span class="glyphicon glyphicon-screenshot" aria-hidden="true"></span>快速跳楼</a></span>
					</p>
				<div style="width:98%;height:1px;margin-bottom:10px;padding:0px;background-color:#D5D5D5;overflow:hidden;"></div>
				<div style="padding-top: 12px;min-height: 380px;">
					${main.main_content }
				
				</div>
				
				<div style="width:98%;height:1px;margin-bottom:10px;padding:0px;background-color:#D5D5D5;overflow:hidden;"></div>
				
				<div style="padding-right: 90px;">
					<p class="text-right" style="color: yellow;"><a href="javascript:void(0)" onclick="alert('举报')" style="color: #f4b300;"><span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>举报</a></p>
				</div>
				
			</td>
		</tr>
	
		<c:choose>
			<c:when test="${not empty second }">
				<c:forEach	items="${second}" var="item" varStatus="vs">
					<tr>
						<td class="tbl">
							<div style="text-align: center;">
							<p>第${item.sec_sequence+1 }楼</p>
							<a><img alt="" src="<%=basePath %>image/ico_000.gif" /></a>
							</div>
							<table class="table" style="background-color:#e5edf2; ">
								<tr>
									<td>昵称:</td>
									<td>${item.base_name }</td>
								</tr>
								<tr>
									<td>性别:</td>
									<td>${item.base_sex }</td>
								</tr>
								<tr>
									<td>年龄:</td>
									<td>${item.base_age }</td>
								</tr>
								<tr>
									<td>发帖数:</td>
									<td>${item.base_fatieshu }</td>
								</tr>
								<tr>
									<td>回帖数:</td>
									<td>${item.base_huitieshu }</td>
								</tr>
							</table>
						</td>
						
						<td class="tbr">
								<span style="padding-right: 30px;">
								<a style="color: #78BA00;">回复于:${item.sec_creatime } </a>
								</span>
							<div style="width:98%;height:1px;margin-bottom:10px;padding:0px;background-color:#D5D5D5;overflow:hidden;"></div>
							<div style="padding-top: 12px;min-height: 380px;">
								${item.sec_content }
							</div>
							<div style="width:98%;height:1px;margin-bottom:10px;padding:0px;background-color:#D5D5D5;overflow:hidden;"></div>
				
							<div style="padding-right: 90px;">
								<p class="text-right" style="color: yellow;">
								<a href="javascript:void(0)" onclick="alert('回复${item.sec_id },${item.sec_sequence }')" style="color: #f4b300;"><span class="glyphicon glyphicon-fire" aria-hidden="true"></span>回复此楼</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="javascript:void(0)" onclick="alert('举报${item.sec_id },${item.sec_sequence }')" style="color: #f4b300;"><span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>举报</a></p>
							</div>
						</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	
	<div class="row">
		<div class="col-xs-7">
			<span style="padding-left: 10px;"><button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>发帖</button></span>
		</div>
		<div class="col-xs-5 text-nowrap" >
			${pageHtml }
			<script type="text/javascript">
				function goPage (parm){
					var page = $("#pageNum").val();
					var reg = new RegExp("^[0-9]*$");
					if (page!=''&&reg.test(page)){
						window.location.href="?page="+page+parm;
					}else{
						alert ("请输入数字");
					}
				}
			</script>
		</div>
	</div>
	
	
	<div style="width:98%;height:3px;margin-bottom:10px;padding:0px;background-color:#D5D5D5;overflow:hidden;"></div>
	
	<!-- 富文本 -->
	<a name="ueditor_" id="ueditor_"></a>
	<form action="<%=basePath %>saveSencondContent" method="post" id="saveTiezi">
		<input name="mainId" type="hidden" value="${main.main_id }">
		<p class="text-right" style="padding-right: 90px;">
		<c:choose>
			<c:when test="${sessionScope.loginFlag}">
				<button type="button" class="btn btn-primary btn-xs text-right" onclick="subForm()"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>回复帖子</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-primary btn-xs text-right" onclick="goLogin()"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>回复帖子</button>
			</c:otherwise>
		</c:choose>
		</p>
        <!-- 加载编辑器的容器 -->
        <script id="container" name="content" type="text/plain">
            
        </script>
        
    </form>
    <!-- 配置文件 -->
    <script type="text/javascript" src="<%=basePath %>uedit/js/ueditor.com.mrkj.ygl.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="<%=basePath %>uedit/js/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var editor = UE.getEditor('container');
        var success = ${sessionScope.loginFlag};
	   	 editor.addListener('ready',function (){
	   			if(success){
					console.log("OK");
					return;
				}else{
	   				editor.setDisabled('fullscreen');
	   				editor.setContent('<br/><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>login.jsp" target="_parent" onclick="goLogin()">请登录</a>');
				}
	     });
   	 	function goLogin(){
   		 if (confirm('发帖前请先登录,确定跳转登录页面')){
   		 window.location.href="<%=basePath%>login.jsp";
   	 	}
   	 }
   	 function subForm (){
     	var content = editor.getContent();
     	if (content === ''){
     		alert ("请输入内容");
     	}else{
     		$("#saveTiezi").submit();
     	}
     }
    </script>
    <!-- end富文本 -->
</div>
	<footer class="footer bg-info">
	    <div class="container" >
	    	<div class="row">
	                <div class="col-sm-12">
	                    <span><a href="http://www.mingrisoft.com/">明日科技</a></span> | 
	                    <span>Copyright &copy; <a href="http://www.mingrisoft.com/">吉林省明日科技有限公司</a></span> | 
	                    <span>吉ICP备16003039号-1</span>
	                    <span>站长QQ:80303857</span>
	                </div>
	                <br />
	                <br />
	         </div>
	    </div>
	</footer>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=basePath %>bootstrap-3.3.5-dist/js/jquery-1.11.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=basePath %>bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/index.js"></script>
</body>
</html>