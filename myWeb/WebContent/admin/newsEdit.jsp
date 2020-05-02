<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="com.mingrisoft.*" %>
<%@ page import="com.mingrisoft.service.News" %>
<%@ include file="Session.jsp" %>
<%
    request.setCharacterEncoding("UTF-8");
    News news = new News();
    Function function = new Function();
    String action = request.getParameter("Action");
    String newsID = request.getParameter("NewsID");
    if (null != action && action.equals("Edit")) {
        String adminName = (String) session.getAttribute("AdminName");
        String ip = request.getRemoteAddr();
        String[] s = new String[2];
        s[0] = request.getParameter("upd_NewsTitle");
        s[1] = request.getParameter("upd_NewsContent");
        String sNews = news.EditNews(s, newsID, adminName, ip);
        if ("Yes".equalsIgnoreCase(sNews)) {
            out.println("<script>alert('修改新闻成功!');location.href='news.jsp';</script>");
            return;
        } else {
            out.println("<script>alert('修改新闻失败!');location.href='news.jsp';</script>");
            return;
        }
    }
%>
