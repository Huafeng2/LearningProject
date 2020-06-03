package com.mrkj.ygl.service.role;

import com.mrkj.ygl.dao.role.Sys_role_permissionMapper;

public interface Sys_role_permissionService extends Sys_role_permissionMapper{

	public int updateRolPer(String roleName,Integer roleId,String[] splitParm);
	
}
