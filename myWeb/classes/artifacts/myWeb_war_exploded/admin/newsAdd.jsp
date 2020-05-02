<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.mingrisoft.*" %>
<%@ page import="com.mingrisoft.service.News" %>
<%@ page import="com.mingrisoft.dbservice.Function" %>

<%
    request.setCharacterEncoding("UTF-8");
    News news = new News();
    Function function = new Function();
    String adminName = (String) session.getAttribute("AdminName");
    String action = request.getParameter("Action");
    if (null != action && action.equals("Add")) {
        String ip = request.getRemoteAddr();
        String[] s = new String[2];
        s[0] = request.getParameter("NewsTitle");
        s[1] = request.getParameter("NewsContent");
        String sNews = news.AddNews(s, adminName, ip);
        if("Yes".equalsIgnoreCase(sNews)){
            out.println("<script>alert('添加新闻成功!');location.href='news.jsp';</script>");
            return;
        }else {
            out.println("<script>alert('添加新闻失败!');location.href='news.jsp';</script>");
            return;
        }
    }

%>