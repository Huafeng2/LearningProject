package com.mrkj.ygl.service.login;

import java.util.List;
import java.util.Map;

import com.mrkj.ygl.dao.role.Sys_loginMapper;

public interface Sys_loginService extends Sys_loginMapper {

	List<Map<String, Object>> selectLoginRole (Map<String,Object> parm);
	
}
