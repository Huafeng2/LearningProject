package com.mrkj.ygl.dao.forum;

import java.util.List;
import java.util.Map;

import com.mrkj.ygl.entity.forum.forumMain;

public interface forumMainMapper {
    int deleteByPrimaryKey(String mainId);

    int insert(forumMain record);

    int insertSelective(forumMain record);

    forumMain selectByPrimaryKey(String mainId);

    int updateByPrimaryKeySelective(forumMain record);

    int updateByPrimaryKeyWithBLOBs(forumMain record);

    int updateByPrimaryKey(forumMain record);
    /**
     * 
     * @param parm  共有4个参数 
     * 						mainType 论点内容 varchar 不是必须
     * 					    mainRecommend 精华  integer 不是必须
     * 						start 分页开始位置 integer *必须参数
     * 						offset 偏移量,查询多少条数据 integer *必须参数
     * @return
     */
    List<forumMain> selectByType(Map<String,Object> parm);
}