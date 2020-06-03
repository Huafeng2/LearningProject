package com.mrkj.ygl.service.role.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mrkj.ygl.dao.role.Sys_roleMapper;
import com.mrkj.ygl.entity.role.Sys_role;
import com.mrkj.ygl.entity.role.Sys_roleTree;
import com.mrkj.ygl.service.role.Sys_roleService;


@Service
public class Sys_roleServiceImpl implements Sys_roleService {

	@Resource
	Sys_roleMapper roleDao;
	
	@Override
	public int deleteByPrimaryKey(Integer roleId) {
		// TODO Auto-generated method stub
		return roleDao.deleteByPrimaryKey(roleId);
	}

	@Override
	public int insert(Sys_role record) {
		// TODO Auto-generated method stub
		return roleDao.insert(record);
	}

	@Override
	public int insertSelective(Sys_role record) {
		// TODO Auto-generated method stub
		return roleDao.insertSelective(record);
	}

	@Override
	public Sys_role selectByPrimaryKey(Integer roleId) {
		// TODO Auto-generated method stub
		return roleDao.selectByPrimaryKey(roleId);
	}

	@Override
	public int updateByPrimaryKeySelective(Sys_role record) {
		// TODO Auto-generated method stub
		return roleDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Sys_role record) {
		// TODO Auto-generated method stub
		return roleDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Sys_roleTree> selectTreeAll() {
		// TODO Auto-generated method stub
		return roleDao.selectTreeAll();
	}

}
