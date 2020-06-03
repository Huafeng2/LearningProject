package com.mrkj.ygl.service.role.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mrkj.ygl.dao.role.Sys_role_permissionMapper;
import com.mrkj.ygl.entity.role.Sys_role_permission;
import com.mrkj.ygl.service.role.Sys_role_permissionService;
import com.mrkj.ygl.utils.StringUtils;

@Service
public class Sys_role_permissionServiceImpl implements Sys_role_permissionService {

	
	@Resource
	Sys_role_permissionMapper rolperService;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return rolperService.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Sys_role_permission record) {
		// TODO Auto-generated method stub
		return rolperService.insert(record);
	}

	@Override
	public int insertSelective(Sys_role_permission record) {
		// TODO Auto-generated method stub
		return rolperService.insertSelective(record);
	}

	@Override
	public Sys_role_permission selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return rolperService.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Sys_role_permission record) {
		// TODO Auto-generated method stub
		return rolperService.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Sys_role_permission record) {
		// TODO Auto-generated method stub
		return rolperService.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return rolperService.deleteByRoleName(roleName);
	}

	@Override
	public int updateRolPer(String roleName, Integer roleId, String[] splitParm) {
		// TODO Auto-generated method stub
		int i = this.deleteByRoleName(roleName);
		int resultInt = 0;
		for (String parm:splitParm){
			if(StringUtils.isNumeric(parm)){
				Integer permissionId = Integer.parseInt(parm);
				Sys_role_permission srp = new Sys_role_permission();
				srp.setPermissionId(permissionId);
				srp.setRoleId(roleId);
				srp.setRoleName(roleName);
				resultInt += this.insertSelective(srp);
			}
		}
		
		return resultInt;
	}

	@Override
	public List<Sys_role_permission> selectByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return rolperService.selectByRoleName(roleName);
	}

}
