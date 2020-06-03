package com.mrkj.ygl.service.login.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mrkj.ygl.dao.role.Sys_loginMapper;
import com.mrkj.ygl.entity.login.Sys_login;
import com.mrkj.ygl.service.login.Sys_loginService;

@Service
public class Sys_loginServiceImpl implements Sys_loginService {

	@Resource
	Sys_loginMapper loginDao;
	
	@Override
	public int deleteByPrimaryKey(Integer loginId) {
		// TODO Auto-generated method stub
		return loginDao.deleteByPrimaryKey(loginId);
	}

	@Override
	public int insert(Sys_login record) {
		// TODO Auto-generated method stub
		return loginDao.insert(record);
	}

	@Override
	public int insertSelective(Sys_login record) {
		// TODO Auto-generated method stub
		int result = 0;
		if (loginDao.insertSelective(record)==1){
			result++;
			record = selectByUsername(record.getUsername());
			Map<String,Object> parm = new HashMap<String,Object>();
			parm.put("login_id", record.getLoginId());
			parm.put("role_id", 3);
			parm.put("username", record.getUsername());
			result += insertSys_login_roleSelective(parm);
		}
		return result;
	}

	@Override
	public Sys_login selectByPrimaryKey(Integer loginId) {
		// TODO Auto-generated method stub
		return loginDao.selectByPrimaryKey(loginId);
	}

	@Override
	public int updateByPrimaryKeySelective(Sys_login record) {
		// TODO Auto-generated method stub
		return loginDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Sys_login record) {
		// TODO Auto-generated method stub
		return loginDao.updateByPrimaryKey(record);
	}

	@Override
	public Sys_login selectByUsername(String username) {
		// TODO Auto-generated method stub
		return loginDao.selectByUsername(username);
	}

	@Override
	public Map<String, Long> selectByUsernameCount(String username) {
		// TODO Auto-generated method stub
		return loginDao.selectByUsernameCount(username);
	}

	/**
	 * 这是用户名与方法绑定的方法。
	 */
	@Override
	public int insertSys_login_roleSelective(Map<String, Object> parm) {
		// TODO Auto-generated method stub
		return loginDao.insertSys_login_roleSelective(parm);
	}

	@Override
	public List<Sys_login> selectPage(Map<String, Object> parm) {
		// TODO Auto-generated method stub
		return loginDao.selectPage(parm);
	}

	@Override
	public Map<String, Long> selectCount() {
		// TODO Auto-generated method stub
		return loginDao.selectCount();
	}
	
	/**
	 * key roleId,roleId,username
	 * @author Administrator
	 * @param parm
	 */
	@Override
	public int updateSys_login_roleSelective(Map<String, Object> parm) {
		// TODO Auto-generated method stub
		return loginDao.updateSys_login_roleSelective(parm);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> selectLoginRole(Map<String,Object> parm) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> resultMap = new ArrayList<>();
		String SQL = "select * from sys_login sl left join sys_login_role slr on (sl.login_id = slr.login_id) left join sys_role sr on (slr.role_id = sr.role_id) ORDER BY sl.login_id desc LIMIT ?,?";
		resultMap = jdbcTemplate.queryForList(SQL,parm.get("page"),parm.get("row"));
		
		return resultMap;
	}

}
