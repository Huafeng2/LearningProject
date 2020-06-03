package com.mrkj.ygl.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="forumComponent")
public class ForumComponent {

	@Value("#{setting['forumList']}")
	private String forumList;

	public String getForumList() {
		return forumList;
	}

	public void setForumList(String forumList) {
		this.forumList = forumList;
	}
	
}
