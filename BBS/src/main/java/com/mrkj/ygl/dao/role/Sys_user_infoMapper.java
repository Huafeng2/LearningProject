package com.mrkj.ygl.dao.role;

import com.mrkj.ygl.entity.login.Sys_user_info;

public interface Sys_user_infoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sys_user_info record);

    int insertSelective(Sys_user_info record);

    Sys_user_info selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sys_user_info record);

    int updateByPrimaryKey(Sys_user_info record);
}