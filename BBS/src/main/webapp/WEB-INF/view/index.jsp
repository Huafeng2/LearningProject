<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!--jsp自定义标签-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String socketPath = request.getServerName() + ":" + request.getServerPort() + path + "/";
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

        a, a:hover {
            text-decoration: none;
            color: #333
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img alt="First slide [2046x256]" class="img-responsive" src="<%=basePath %>image/banner_01.png">
                <div class="carousel-caption">
                    <p class="text-primary"></p>
                </div>
            </div>
            <div class="item">
                <img alt="First slide [2046x256]" class="img-responsive" src="<%=basePath %>image/banner_02.png">
                <div class="carousel-caption">
                    <p class="text-primary"></p>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <!-- <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a> -->
    </div>
</div>
<!-- 导航路径 -->
<div class="container-fluid">
    <nav class="navbar bg-success">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
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
                            <li><a href="javascript:void(0)"
                                   onclick="alert('会员')">会员:${sessionScope.loginEntity.wxname}</a></li>
                            <li><a href="<%=basePath%>/login/logout">退出</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="<%=basePath %>login.jsp">登录</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>

<div class="container-fluid">
    <div class="bm bmw  flg cl con01" style="background-color: #ffffff;">
        <div class="bm_h cl" style="position: relative;background-color: #ffffff;">
        <span class="o">
          <img id="category_8702_img" src="<%=basePath%>image/collapsed_no.gif" title="收起/展开" alt="收起/展开"
               onclick="toggle_collapse('category_8701');">
        </span>
            <h4>
                <i class="jg"></i>
                <a href="javascript:void(0)">编程语言 专区</a>
            </h4>
        </div>


        <div id="category_8701" class="bm_c">
            <table class="fl_tb">
                <tbody class="js-hover">
                <c:choose>
                    <c:when test="${not empty java }">
                        <c:forEach items="${java }" var="forum" varStatus="vs">
                            <c:set var="endTr" value="3"></c:set>
                            <c:if test="${vs.index*10%3 eq 0 }">
                                <tr class="fl_row">
                            </c:if>
                            <td class="fl_g" width="32.9%">
                                <div class="fl_icn_g" style="width: 120px;">
                                    <a href="<%=basePath%>mainContent?mainType=${forum.dictKey }">
                                        <c:if test="${vs.index eq 0 }">
                                            <img src="<%=basePath%>image/language_java.png" alt="Java" align="left">
                                        </c:if>
                                        <c:if test="${vs.index eq 1 }">
                                            <img src="<%=basePath%>image/language_php.png" alt="PHP" align="left">
                                        </c:if>
                                        <c:if test="${vs.index eq 2 }">
                                            <img src="<%=basePath%>image/language_net.png" alt=".NET" align="left">
                                        </c:if>
                                        <c:if test="${vs.index eq 3 }">
                                            <img src="<%=basePath%>image/language_jsp.png" alt="JSP" align="left">
                                        </c:if>
                                    </a>
                                </div>
                                <dl style="margin-left: 120px;">
                                    <dt>
                                        <a href="<%=basePath%>mainContent?mainType=${forum.dictKey }"
                                           class="game-title">${forum.dictValue }</a>
                                        <em class="game-todayposts" title="今日"> </em>
                                    </dt>
                                    <dd class="game-desc">
                                        <c:choose>
                                            <c:when test="${not empty top5s }">
                                                <c:forEach items="${top5s }" var="top5" varStatus="vsa">
                                                    <c:if test="${not empty top5[forum.dictKey] }">
                                                        <c:forEach items="${top5[forum.dictKey] }" var="itm"
                                                                   varStatus="vsb">
                                                            <a href="<%=basePath%>secondContent?mainId=${itm.mainId}"
                                                               target="_blank" class="text-nowrap">${itm.mainTitle}</a>|
                                                        </c:forEach>
                                                    </c:if>
                                                </c:forEach>
                                            </c:when>
                                        </c:choose>
                                    </dd>
                                </dl>
                            </td>
                            <c:if test="${vs.last or endTr eq (vs.index+1) }">
                                <c:set var="endTr" value="${endTr+3}"></c:set>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </c:when>
                </c:choose>
                </tbody>
            </table>
        </div>
    </div>


    <div class="bm bmw  flg cl con02" style="background-color: #ffffff;">
        <div class="bm_h cl" style="position: relative;background-color: #ffffff;">
        <span class="o">
          <img id="category_8702_img" src="<%=basePath%>image/collapsed_no.gif" title="收起/展开" alt="收起/展开"
               onclick="toggle_collapse('category_8702');">
        </span>
            <h4>
                <i class="jg"></i>
                <a style="" href="#">DataBase 专区</a>
            </h4>
        </div>
        <div id="category_8702" class="bm_c" style="">
            <table class="fl_tb">
                <tbody class="js-hover">
                <tr class="fl_row">
                    <td class="fl_g" width="32.9%">
                        <div class="fl_icn_g" style="width: 120px;">
                            <a href="javascript:void(0)"><img src="<%=basePath%>image/language_mysql.png" alt="MySQL"
                                                              align="left"></a>
                        </div>
                        <dl style="margin-left: 120px;">
                            <dt>
                                <a href="javascript:void(0)" class="game-title">MySQL 数据库</a>
                                <em class="game-todayposts" title="今日"></em>
                            </dt>
                            <dd class="game-desc">
                                <a href="javascript:void(0)" class="text-nowrap">MySQL引擎之前的区别</a>|
                                <a href="javascript:void(0)" class="text-nowrap">初识MySQL跟我来</a>|
                                <a href="javascript:void(0)" class="text-nowrap">MySQL注意事项</a>|
                                <a href="javascript:void(0)" class="text-nowrap">各数据库SQL语句区别</a>|
                                <a href="javascript:void(0)" class="text-nowrap">数据库优化</a>
                            </dd>
                        </dl>
                    </td>
                    <td class="fl_g" width="32.9%">
                        <div class="fl_icn_g" style="width: 120px;">
                            <a href="javascript:void(0)"><img src="<%=basePath%>image/language_oracle.png" alt="Oracle"
                                                              align="left"></a>
                        </div>
                        <dl style="margin-left: 120px;">
                            <dt>
                                <a href="javascript:void(0)" class="game-title">Oracle 数据库</a>
                                <em class="game-todayposts" title="今日"></em>
                            </dt>
                            <dd class="game-desc">
                                <a href="javascript:void(0)" class="text-nowrap">Oracle引擎之前的区别</a>|
                                <a href="javascript:void(0)" class="text-nowrap">初识Oracle跟我来</a>|
                                <a href="javascript:void(0)" class="text-nowrap">Oracle注意事项</a>|
                                <a href="javascript:void(0)" class="text-nowrap">各数据库SQL语句区别</a>|
                                <a href="javascript:void(0)" class="text-nowrap">数据库优化</a>
                            </dd>
                        </dl>
                    </td>
                    <td class="fl_g" width="32.9%">
                        <div class="fl_icn_g" style="width: 120px;">
                            <a href="javascript:void(0)"><img src="<%=basePath%>image/language_sqlsever.png"
                                                              alt="SQLSever" align="left"></a>
                        </div>
                        <dl style="margin-left: 120px;">
                            <dt>
                                <a href="javascript:void(0)" class="game-title">SqlSever 数据库</a>
                                <em class="game-todayposts" title="今日"></em>
                            </dt>
                            <dd class="game-desc">
                                <a href="javascript:void(0)" class="text-nowrap">SQLSever引擎之前的区别</a>|
                                <a href="javascript:void(0)" class="text-nowrap">初识SQLSever跟我来</a>|
                                <a href="javascript:void(0)" class="text-nowrap">SQLSever注意事项</a>|
                                <a href="javascript:void(0)" class="text-nowrap">各数据库SQL语句区别</a>|
                                <a href="javascript:void(0)" class="text-nowrap">数据库优化</a>
                            </dd>
                        </dl>
                    </td>
                </tr>
                <tr class="fl_row">
                    <td class="fl_g" width="32.9%">
                        <div class="fl_icn_g" style="width: 120px;">
                            <a href="javascript:void(0)"><img src="<%=basePath%>image/language_other2.png" alt="Java"
                                                              align="left"></a>
                        </div>
                        <dl style="margin-left: 120px;">
                            <dt>
                                <a href="javascript:void(0)" class="game-title">其他数据库</a>
                                <em class="game-todayposts" title="今日"></em>
                            </dt>
                            <dd class="game-desc">
                                <a href="javascript:void(0)">其他数据库</a>
                            </dd>
                        </dl>
                    </td>
                    <td class="fl_g" width="32.9%">
                        <div class="fl_icn_g" style="width: 120px;">
                            <a href="javascript:void(0)"><img src="<%=basePath%>image/language_other2.png" alt="Java"
                                                              align="left"></a>
                        </div>
                        <dl style="margin-left: 120px;">
                            <dt>
                                <a href="javascript:void(0)" class="game-title">其他数据库</a>
                                <em class="game-todayposts" title="今日"></em>
                            </dt>
                            <dd class="game-desc">
                                <a href="javascript:void(0)">其他数据库</a>
                            </dd>
                        </dl>
                    </td>
                    <td class="fl_g" width="32.9%">
                        <div class="fl_icn_g" style="width: 120px;">
                            <a href="javascript:void(0)"><img src="<%=basePath%>image/language_other2.png" alt="Java"
                                                              align="left"></a>
                        </div>
                        <dl style="margin-left: 120px;">
                            <dt>
                                <a href="javascript:void(0)" class="game-title">其他数据库</a>
                                <em class="game-todayposts" title="今日"></em>
                            </dt>
                            <dd class="game-desc">
                                <a href="javascript:void(0)">其他数据库</a>
                            </dd>
                        </dl>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<footer class="footer bg-info">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <span><a href="http://www.mingrisoft.com/">明日科技</a></span> |
                <span>Copyright &copy; <a href="http://www.mingrisoft.com/">吉林省明日科技有限公司</a></span> |
                <span>吉ICP备16003039号-1</span>
                <span>站长QQ:80303857</span>
            </div>
            <br/>
            <br/>
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