package com.mrkj.ygl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mrkj.ygl.entity.login.Sys_login;

@WebFilter(urlPatterns={"/saveMainContent","/saveSencondContent"},asyncSupported=false)
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Sys_login loginEntity = (Sys_login)session.getAttribute("loginEntity");
		String referer = req.getHeader("Referer");
		if (loginEntity !=null && referer !=null){
			chain.doFilter(request, response);
		}else{
			HttpServletResponse resq = (HttpServletResponse)response;
			resq.sendRedirect("login.jsp");
			if (referer != null){
				session.setAttribute("Referer", referer);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
