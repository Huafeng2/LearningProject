<%@ page contentType="text/html; charset=UTF-8" language="java" buffer="32kb" %>
<%@ page import="com.mingrisoft.*" %>
<%@ page import="com.mingrisoft.service.News" %>
<%@ page import="com.mingrisoft.dbservice.Function" %>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
    request.setCharacterEncoding("UTF-8");
    News news = new News();
    Function function = new Function();
    String adminName = (String) session.getAttribute("AdminName");
    String newsID = request.getParameter("NewsID");
    String ip = request.getRemoteAddr();
    if (news.DelNews(newsID, adminName, ip)) {
        out.println("<script>alert('删除新闻成功!');location.href='news.jsp';</script>");
    } else {
        out.println("<script>alert('删除新闻失败!');location.href='news.jsp';</script>");
    }
%>
