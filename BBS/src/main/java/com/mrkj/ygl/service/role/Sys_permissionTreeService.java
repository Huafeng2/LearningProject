package com.mrkj.ygl.service.role;

import java.util.List;

import com.mrkj.ygl.dao.role.Sys_permissionTreeMapper;
import com.mrkj.ygl.entity.role.Sys_permissionTree;

public interface Sys_permissionTreeService extends Sys_permissionTreeMapper {

	
	public List<Sys_permissionTree> checked (List<Sys_permissionTree> listParm,String roleName);
	
}
