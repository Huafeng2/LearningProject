package com.mrkj.ygl.service.login.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mrkj.ygl.dao.role.UserloginMapper;
import com.mrkj.ygl.entity.login.Userlogin;
import com.mrkj.ygl.entity.login.UserloginKey;
import com.mrkj.ygl.service.login.UserloginService;

@Service
public class UserloginServiceImpl implements UserloginService{

	@Resource
	UserloginMapper userloginDao;
	
	@Override
	public int deleteByPrimaryKey(UserloginKey key) {
		// TODO Auto-generated method stub
		return userloginDao.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Userlogin record) {
		// TODO Auto-generated method stub
		return userloginDao.insert(record);
	}

	@Override
	public int insertSelective(Userlogin record) {
		// TODO Auto-generated method stub
		return userloginDao.insertSelective(record);
	}

	@Override
	public Userlogin selectByPrimaryKey(UserloginKey key) {
		// TODO Auto-generated method stub
		return userloginDao.selectByPrimaryKey(key);
	}

	@Override
	public int updateByPrimaryKeySelective(Userlogin record) {
		// TODO Auto-generated method stub
		return userloginDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Userlogin record) {
		// TODO Auto-generated method stub
		return userloginDao.updateByPrimaryKey(record);
	}

	@Override
	public Userlogin selectByUsername(String username) {
		// TODO Auto-generated method stub
		return userloginDao.selectByUsername(username);
	}

	/**
	 * 参数     
        username 用户名  role 身份  infoname 姓名  age 年龄 sex 性别 tell 电话 sfzh 身份证  address 地址 creat_date 创建时间
        update_date 更新时间
	 */
	@Override
	public List<Userlogin> selectPage(Map<String, Object> parm) {
		// TODO Auto-generated method stub
		return userloginDao.selectPage(parm);
	}

	@Override
	public Userlogin selectByPrimaryKeyUsername(UserloginKey key) {
		// TODO Auto-generated method stub
		return userloginDao.selectByPrimaryKeyUsername(key);
	}

	@Override
	public Map<String, Long> selectCount(Map<String, Object> parmMap) {
		// TODO Auto-generated method stub
		return userloginDao.selectCount(parmMap);
	}

}
