package com.mrkj.ygl.service.role.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mrkj.ygl.dao.role.Sys_permissionTreeMapper;
import com.mrkj.ygl.entity.role.Sys_permissionTree;
import com.mrkj.ygl.entity.role.Sys_role_permission;
import com.mrkj.ygl.service.role.Sys_permissionTreeService;
import com.mrkj.ygl.service.role.Sys_role_permissionService;

@Service
public class Sys_permissionTreeServiceImpl implements Sys_permissionTreeService {

	@Resource
	Sys_permissionTreeMapper perTreeService;
	
	@Resource
	Sys_role_permissionService rolPerService;
	
	@Override
	public List<Sys_permissionTree> selectAll() {
		// TODO Auto-generated method stub
		return perTreeService.selectAll();
	}

	@Override
	public List<Sys_permissionTree> checked(List<Sys_permissionTree> listParm,String roleName) {
		// TODO Auto-generated method stub
		List<Sys_role_permission> listRP = rolPerService.selectByRoleName(roleName);
		if (listParm != null)
		for (Sys_permissionTree spt : listParm){
			Integer sptId = spt.getId();
			for (Sys_role_permission srp:listRP){
				Integer srpId = srp.getPermissionId();
				if (sptId.equals(srpId)){
					spt.setChecked(true);
					continue;
				}
			}
		}
		
		return listParm;
	}

	/* (non-Javadoc)
	 * @see com.mrkj.ygl.dao.role.Sys_permissionTreeMapper#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return perTreeService.deleteByPrimaryKey(id);
	}

}
