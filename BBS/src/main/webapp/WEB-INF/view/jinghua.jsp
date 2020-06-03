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
    </style>
  </head>
<body >

<div class="container-fluid">
	
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
		  <li class="active">精华帖子</li>
	</ol>
</div>

<div class="container-fluid" >
	<div class="row">
		<div class="col-xs-2 text-right">
			<img alt="" src="<%=basePath %>image/ziye.png">
		</div>
		<div class="col-xs-10 text-left">
			  <h3>帖子</h3>
			  
			  <footer>精华：<cite title="Source Title">
			  
			  	感谢大家对论坛的支持.
			  	
			  </footer>
		</div>
	</div>
	<!-- 横线 -->
	<div style="width:98%;height:3px;margin-bottom:10px;padding:0px;background-color:#D5D5D5;overflow:hidden;"></div>
	
	<div class="row">
		
	</div>
	
	<table class="table table-striped">
  		<tr>
  			<th width="70%"><strong>标题：</strong></th>
  			<th width="10%"><strong>作者</strong></th>
  			<th width="10%"><strong>回复/查看</strong></th>
  			<th width="10%"><strong>最后发表</strong></th>
  		</tr>
  		
  		<c:choose>
  			<c:when test="${not empty main }">
  				<c:forEach items="${main }" var="item" varStatus="vs">
  					<tr>
  						<td>
  							<c:if test="${item.main_recommend eq 1 }">
  								<a href="<%=basePath%>secondContent?mainId=${item.main_id}" ><img src="<%=basePath %>image/pin_1.gif" id="${item.main_id}img" />[日月精华]&nbsp;&nbsp; ${item.main_title }</a>
  								<c:if test="${sessionScope.loginFlag}">
  									<a style="color: green" href="javascript:void(0)" onclick="setjinghua('${item.main_id}','qx')">[取消精华]</a>
  								</c:if>
  								
  							</c:if>
  							<c:if test="${item.main_recommend ne 1 }">
  								<a href="<%=basePath%>secondContent?mainId=${item.main_id}" ><img src="<%=basePath %>image/folder_new.gif" />[最新帖子]&nbsp;&nbsp; ${item.main_title }</a>
  								<c:if test="${sessionScope.loginFlag}">
  								<a style="color: red" href="javascript:void(0)" onclick="setjinghua('${item.main_id}','sz')">[设置精华]</a>
  								</c:if>
  							</c:if>
  							<script type="text/javascript">
  								function setjinghua(mainId,flag){
  									$.ajax({
											url:"<%=basePath%>jinghua?mainId="+mainId+"&flag="+flag,
											type:'GET',
											success:function (data){
												if (data.success){
													window.location.reload();
												}
											}
										});
  								}
  							</script>
  						</td>
  						<td>${item.main_creatuser }</td>
			  			<td>${item.info_reply }/${item.info_see }</td>
			  			<td>${item.info_lastuser }</td>
  					</tr>
  				</c:forEach>
  			</c:when>
  		</c:choose>

	</table>
	
	<div class="row">
		<div class="col-xs-7">
			
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
	

    <!-- 配置文件 -->
    <script type="text/javascript" src="<%=basePath %>uedit/js/ueditor.com.mrkj.ygl.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="<%=basePath %>uedit/js/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->

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