package com.mrkj.ygl.dao.forum;

import com.mrkj.ygl.entity.forum.forumInfo;

public interface forumInfoMapper {
    int deleteByPrimaryKey(Integer infoId);

    int insert(forumInfo record);

    int insertSelective(forumInfo record);

    forumInfo selectByPrimaryKey(Integer infoId);

    int updateByPrimaryKeySelective(forumInfo record);

    int updateByPrimaryKey(forumInfo record);
}