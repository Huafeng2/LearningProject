package com.mrkj.ygl.dao.role;

import com.mrkj.ygl.entity.role.Sys_permission;

public interface Sys_permissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Sys_permission record);

    int insertSelective(Sys_permission record);

    Sys_permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Sys_permission record);

    int updateByPrimaryKey(Sys_permission record);
}