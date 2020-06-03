package com.mrkj.ygl.dao.role;

import java.util.List;

import com.mrkj.ygl.entity.role.Sys_role_permission;

public interface Sys_role_permissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sys_role_permission record);

    int insertSelective(Sys_role_permission record);

    Sys_role_permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sys_role_permission record);

    int updateByPrimaryKey(Sys_role_permission record);
    
    int deleteByRoleName (String roleName);
    
    List<Sys_role_permission> selectByRoleName(String roleName);
}