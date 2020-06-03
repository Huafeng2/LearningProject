package com.mrkj.ygl.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

@WebListener
public class SessionListenerBySeachLogin implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		se.getSession().setAttribute("loginFlag", "false");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		}
	}

}
