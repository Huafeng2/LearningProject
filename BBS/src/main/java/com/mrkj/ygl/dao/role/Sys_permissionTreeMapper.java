package com.mrkj.ygl.dao.role;

import java.util.List;

import com.mrkj.ygl.entity.role.Sys_permissionTree;

public interface Sys_permissionTreeMapper {
    
	List<Sys_permissionTree> selectAll();
	
	int deleteByPrimaryKey(Integer id);
	
}