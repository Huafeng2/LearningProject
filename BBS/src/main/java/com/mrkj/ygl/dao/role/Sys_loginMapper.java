package com.mrkj.ygl.dao.role;

import java.util.List;
import java.util.Map;

import com.mrkj.ygl.entity.login.Sys_login;

public interface Sys_loginMapper {
    int deleteByPrimaryKey(Integer loginId);

    int insert(Sys_login record);

    int insertSelective(Sys_login record);

    Sys_login selectByPrimaryKey(Integer loginId);
    
    Sys_login selectByUsername(String username);

    int updateByPrimaryKeySelective(Sys_login record);

    int updateByPrimaryKey(Sys_login record);
    
    Map<String,Long> selectByUsernameCount(String username);
    /**
     * key role_id,login_id,username
     * @param parm
     * @return
     */
    int insertSys_login_roleSelective(Map<String,Object> parm);
    /**
     * key roleId,roleId,username
     * 
     * @param parm
     * @return
     */
    int updateSys_login_roleSelective(Map<String,Object> parm);
    
    List<Sys_login> selectPage(Map<String, Object> parm);
    
    Map<String,Long> selectCount();
}