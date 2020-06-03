package com.mrkj.ygl.service.forum.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mrkj.ygl.dao.forum.forumMainMapper;
import com.mrkj.ygl.entity.forum.forumMain;

@Service
public class ForumServiceImpl{

	@Resource
	forumMainMapper fmm;
	
	@Resource
	JdbcTemplate jdbcTemplate;
	
	@Resource
	SimpleDateFormat simpleDateFormat;
	
	
	/*
	 * 
	 * 第二阶段
	 * 
	 * 完成细节,表单提交保存.
	 * 更新数据.
	 * 
	 * 
	 * */
	
	public int insertMain (String main_id,String main_title,String main_flag,String main_type,String main_content,
			String main_creatuser,Integer main_recommend,String main_delete,String main_nickname,Integer main_zan){
		String insertMain = "INSERT INTO forum_main (main_id,main_title,main_flag,main_type,main_content,main_creatime,main_creatuser,main_recommend,main_delete,main_nickname,main_zan) values (?,?,?,?,?,NOW(),?,?,?,?,?)";
		int updateFlag = 0;
		
		updateFlag = jdbcTemplate.update(insertMain,main_id,main_title,main_flag,main_type,main_content,main_creatuser,main_recommend,main_delete,main_nickname,main_zan);
		
		String insertInfo = "INSERT INTO forum_info (info_reply,info_see,info_lastuser,info_lastime,main_id) VALUES (0,0,?,NOW(),?)";
		
		updateFlag += jdbcTemplate.update(insertInfo,main_nickname,main_id);
		
		String updateMinfo = "UPDATE forum_minfo as minfo SET minfo.minfo_count = "
				+ "minfo.minfo_count+1 "
				+ "where minfo.main_type = (select main.main_type FROM forum_main as main "
				+ "WHERE main.main_id = ?)";
		
		updateFlag += jdbcTemplate.update(updateMinfo,main_id);
		
		return updateFlag;
	}
	
	public int editJinghua (Integer recommend,String mainId){
		int result = 0;
		
		String updateMainRecommend = "UPDATE forum_main SET main_recommend = ? WHERE main_id = ?";
		
		result = jdbcTemplate.update(updateMainRecommend,recommend,mainId);
		
		return result;
	}
	
	/**
	 * 
	 * INSERT INTO forum_second 
	 *	(sec_id,
	 *	main_id,
	 *	sec_sequence,
	 *	sec_content,
	 *	sec_creatuser,
	 *	sec_creatime,
	 *	sec_nickname,
	 *	sec_resequence,
	 *	sec_delete,
	 *	sec_reid,
	 *	username
	 *	) 
	 *	VALUES ('3','tes0t',3,'ddd','admin1',NOW(),'于国良',0,'n','0','admin1')
	 * 
	 * @param mainId
	 * @param content
	 * @param resequence
	 * @param reId
	 * @param username
	 * @param nickname
	 * @return
	 */
	public int insertSecond(String mainId,String content,Integer sequence,Integer resequence,String reId,String username,String nickname){
		int updateFlag = 0;
		String insertSecond = "INSERT INTO forum_second "
				+ "(sec_id,main_id,sec_sequence,sec_content,sec_creatuser,sec_creatime,sec_nickname,sec_resequence,sec_delete,sec_reid,username) "
				+ "VALUES (?,?,?,?,?,NOW(),?,?,'n',?,?)";
		String secId = UUID.randomUUID().toString();
		
		updateFlag = jdbcTemplate.update(insertSecond,secId,mainId,sequence,content,username,nickname,resequence,reId,username);
		
		String updateInfo = "UPDATE forum_info SET info_reply = info_reply+1,info_lastuser = ?,info_lastime = NOW() WHERE main_id = ?";
		
		updateFlag += jdbcTemplate.update(updateInfo,nickname,mainId);
		
		String updateBaseUserinfo = "UPDATE base_userinfo SET base_huitieshu = base_huitieshu+1 WHERE username = ?";
		
		updateFlag += jdbcTemplate.update(updateBaseUserinfo,username);
		
		String updateMinfo = "UPDATE forum_minfo as minfo SET minfo.minfo_reply = minfo.minfo_reply+1 where minfo.main_type = (select main.main_type FROM forum_main as main WHERE main.main_id = ?)";
		
		updateFlag += jdbcTemplate.update(updateMinfo,mainId);
		
		
		return updateFlag;
	}
	
	public int getSequence(String mainId){
		int result = 0;
		
		String selectInfo = "select info_reply FROM forum_info where main_id = ?";
		result = (int)jdbcTemplate.queryForMap(selectInfo, mainId).get("info_reply");
		
		return result;
	}
	
	/**
	 * 该方法是一个隐藏方法,用户可以使使用<re></re>标签给用户发送信息
	 * map key 
	 * 1 content
	 * 2 sequence
	 * 3 user
	 * @param content
	 * @return
	 */
	public Map<String,Object> convert (String content){
		Map<String,Object> resultMap = new HashMap<>();
		List<String> listSequence = new ArrayList<>();
		List<String> listNickname = new ArrayList<>();
		while (content.indexOf("^re^")>-1&&content.indexOf("^/re^")>-1){
			String temp = content.substring(content.indexOf("^re^"), content.indexOf("^/re^")+5);
			content = content.replace(temp, "");
			temp = temp.replace("^re^", "").replace("^/re^", "").replace("，", ",");
			if ("".equals(temp.trim().indexOf(","))){
				String [] temps = temp.split(",");
				for (String item : temps){
					item = item.trim();
					if (item.indexOf("@")>-1&&item.length()>1){
						item = item.replace("@", "");
						if (!"".equals(item.trim())){
							listSequence.add(item);
						}
					}else if (item.indexOf("#")>-1){
						item = item.replace("#", "");
						if (!"".equals(item.trim())){
							listNickname.add(item);
						}
					}
				}
			}
		}
		
		resultMap.put("content", content);
		
		if (listSequence.size()>0){
			resultMap.put("sequence", listSequence);
		}
		if (listNickname.size()>0){
			resultMap.put("user", listNickname);
		}
		
		return resultMap;
	}
	
	/*
	 * 
	 * 第二阶段 END
	 * 
	 *
	 * 
	 * 
	 * 
	 * */
	
	/***
	 * 
	 * @param mainType
	 * @return
	 */
	public List<forumMain> getRecommendTop5 (String mainType){
		
		Map<String,Object> map = new HashMap<>();
		map.put("mainType", mainType);
		map.put("mainRecommend", 1);
		map.put("start", 0);
		map.put("offset", 3);
		//parm 共有4个参数 mainType 论点内容 varchar 不是必须 mainRecommend 精华 integer 不是必须 start 分页开始位置 integer *必须参数 offset 偏移量,查询多少条数据 *必须参数

		List<forumMain> fm = fmm.selectByType(map);
		
		return fm;
	}


	/**
	 * 
	 * 
	 * 
	 *  SQL 原型
	 *  SELECT * FROM mrbbs.forum_main as main left join forum_info as info on main.main_id = info.main_id 
	 *	where main.main_type = 'javase'
	 *	order by main.main_recommend,main.main_creatime
	 *	limit 0,3
	 */
	public List<Map<String, Object>> getMainPage(String mainType,Integer start,Integer offset) {
		String selectMainSql ="";
		List<Map<String, Object>> resultListMapForMainLeftInfo =null;
		if (mainType!=null){
			//按类别查看帖子
			selectMainSql = "SELECT main.*,info.info_id,info.info_reply,info.info_see,info.info_lastuser,info.info_lastime FROM mrbbs.forum_main as main left join forum_info as info on main.main_id = info.main_id where main.main_type = ? order by main.main_recommend,main.main_creatime desc limit ?,?";
			
			resultListMapForMainLeftInfo = jdbcTemplate.queryForList(selectMainSql,mainType,start,offset);
		
			String updateInfoSql = "update forum_minfo set minfo_see = (minfo_see+1) where main_type = ?";
		
			jdbcTemplate.update(updateInfoSql, mainType);
		}
		else{
			//查看精华帖子
			selectMainSql = "SELECT main.*,info.info_id,info.info_reply,info.info_see,info.info_lastuser,info.info_lastime FROM mrbbs.forum_main as main left join forum_info as info on main.main_id = info.main_id where main.main_recommend = 1 order by main.main_recommend,main.main_creatime desc limit ?,?";
			
			resultListMapForMainLeftInfo = jdbcTemplate.queryForList(selectMainSql,start,offset);
		}
		
		return resultListMapForMainLeftInfo;
	}
	
	public List<Map<String,Object>> getMainByTitle(String mainTitle){
		String selectMainSql = "SELECT main.*,info.info_id,info.info_reply,info.info_see,info.info_lastuser,info.info_lastime FROM mrbbs.forum_main as main left join forum_info as info on main.main_id = info.main_id where main.main_title like ? order by main.main_recommend,main.main_creatime desc";
		List<Map<String,Object>> resultList = jdbcTemplate.queryForList(selectMainSql, "%"+mainTitle+"%");
		return resultList;
	}
	/**
	 * 这个是获取版主的信息
	 * 
	 */
	public List<Map<String, Object>> getBanzhu(String mainType) {
		String selectBanzhuByMainTypeSql = "SELECT * FROM mrbbs.forum_banzhu where main_type = ?";
		
		List<Map<String, Object>> resultListMapForBanzhu = jdbcTemplate.queryForList(selectBanzhuByMainTypeSql,mainType);
		
		return resultListMapForBanzhu;
	}

	
	/**
	 * 
	 * 获取版块信息
	 * 
	 */
	public Map<String, Object> getMinfo(String mainType) {
		
		String selectMinfoByMainType = "select * from forum_minfo where main_type = ?";
		
		Map<String,Object> resultMapForMinfo = jdbcTemplate.queryForMap(selectMinfoByMainType,mainType);
		
		return resultMapForMinfo;
	}
	
	
	/**
	 * 获取版主姓名
	 */
	public List<Map<String,Object>> getBanzhuAndSyslogin (String mainType){
		
		String selectBanzhuByMainType = "SELECT `banzhu`.`main_type`,`banzhu`.`username`,`login`.`wxname` FROM forum_banzhu banzhu LEFT JOIN sys_login login on banzhu.username = login.username where main_type = ?";
		
		List<Map<String, Object>> resultListMapBanzhu = jdbcTemplate.queryForList(selectBanzhuByMainType,mainType);
		
		return resultListMapBanzhu;
	}	
	/**
	 * 返回总数
	 * @param mainType
	 * @return
	 */
	public Long getMainCount (String mainType){
		
		Map<String,Object> result = null;
		String selectMainCount = "";
		if (mainType!=null&&!"null".equals(mainType)){
			//按类型获取总数
			selectMainCount = "select count(main_id) as count from forum_main  where main_type = ?";
			result = jdbcTemplate.queryForMap(selectMainCount,mainType);
		}else{
			//按精华获取总数
			selectMainCount = "select count(main_id) as count from forum_main  where main_recommend = ?";
			result = jdbcTemplate.queryForMap(selectMainCount,1);
		}
		
		return (Long)result.get("count");
	}

	
	/**
	 * 获取详细的帖子主贴
	 * @param mainId
	 * @return
	 */
	public Map<String,Object> getSecondMain (String mainId){
		String selectMainBymainId = "SELECT main.*,uinfo.base_name,uinfo.base_age,uinfo.base_sex,uinfo.base_fatieshu,uinfo.base_huitieshu FROM forum_main main LEFT JOIN base_userinfo uinfo on main.main_creatuser=uinfo.username WHERE main_id = ?";
		
		return jdbcTemplate.queryForMap(selectMainBymainId,mainId);
	}
	
	/**
	 * 获取跟帖
	 * @param mainId
	 * @param order
	 * @param start
	 * @param offset
	 * @return
	 */
	public List<Map<String,Object>> getSecond (String mainId,String order,Integer start,Integer offset){
		String selectSecond = "SELECT sec.*,uinfo.base_name,uinfo.base_age,uinfo.base_sex,uinfo.base_fatieshu,uinfo.base_huitieshu FROM forum_second sec LEFT JOIN base_userinfo uinfo ON sec.username = uinfo.username  where sec.main_id = ?  ORDER BY sec.sec_sequence "+order+" LIMIT ?,?";
		List<Map<String, Object>> tempListMap = jdbcTemplate.queryForList(selectSecond,mainId,start,offset);
		
		for (Map<String, Object> entity : tempListMap){
			java.sql.Timestamp timestamp = (java.sql.Timestamp)entity.get("sec_creatime");
			long time = timestamp.getTime();											   //转换为Long
			simpleDateFormat.applyPattern("yyyy年MM月dd日    hh时mm分ss秒");					   //设置时间格式
			String creatime = simpleDateFormat.format(new Date(time));					   //时间转换
			entity.put("sec_creatime", creatime);										   //修改元素
		}
		
		return	tempListMap;
		
	}
	
	
	public long getSecondCount (String mainId){
		
		String selectSecondCount = "select count(sec_id) as count from forum_second  where main_id = ?";
		
		Map<String,Object> result = jdbcTemplate.queryForMap(selectSecondCount,mainId);
		
		return (Long)result.get("count");
		
	}
	
	
	/**
	 * 如果传递过来的mainType 证明这是一个2级菜单
	 * 如果传递过来的是mainId 证明这是一个3级菜单
	 * @param mainType
	 * @param mainId
	 * @return
	 */
	public Map<String,Object> getPath2 (String mainType,String mainId){
		
		if (mainId == null){
			String selectDictionaryByDictKey = "select dict_value FROM forum_dictionary where dict_key = ?";
		
			return jdbcTemplate.queryForMap(selectDictionaryByDictKey,mainType);
		}else{
			String selectMainLeftDictByMainId = "select main.main_title,dict.dict_key,dict_value from forum_main main LEFT JOIN forum_dictionary dict on main.main_type = dict.dict_key where main_id = ? ";
			
			return jdbcTemplate.queryForMap(selectMainLeftDictByMainId,mainId);
		}
	} 
	
	
	/**
	 * 获取模块分类
	 * @return
	 */
	public List<Map<String,Object>> getDictionaryByGroup (String group){
		String selectDictionary = "SELECT dict_value,dict_key FROM forum_dictionary where dict_group = ? ORDER BY dict_order";
		
		return jdbcTemplate.queryForList(selectDictionary,group);
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getPage (Long count,Integer currentPage,Integer offset,Map<String,String> parm){
		
		Long currentLong = Long.parseLong(currentPage+"");
		Long countPage = 0L;
		
		if(count%offset!=0){
			countPage = count/offset+1;
		}else{
			countPage = count/offset;
		}
		
		StringBuffer sbParm = new StringBuffer("");

		//设置额外附加参数
		if (parm!=null){
			Set<Entry<String, String>> entrySet = parm.entrySet();
				
			for (Entry<String, String> entry : entrySet){
				sbParm.append("&"+entry.getKey()+"="+entry.getValue());
			}
			
		}
		
		StringBuffer sb = new StringBuffer();
		if (currentPage>1){
			Set<Entry<String, String>> entrySet = parm.entrySet();
			sb.append("<span class=\"page\"><a href=\"?page="+(currentPage-1));
			sb.append(sbParm);
			sb.append("\">«</a></span>");
		}else{
			sb.append("<span class=\"page\"><a href=\"?page=1");
			sb.append(sbParm);
			sb.append("\">«</a></span>");
		}
		sb.append("<span class=\"page\" style=\"width: 50px !important;\">");
		
		sb.append("<a href=\"?page=1");
		sb.append(sbParm);
		sb.append("\">start</a>");
		
		sb.append("</span>");
		
		//中间页数导航
		if ((countPage-currentLong+1) >=5){
			for (Long i = currentLong ; i < currentPage+5;i++){
				sb.append("<span class=\"page\">");
				
				sb.append("<a href=\"?page="+i);
				sb.append(sbParm);
				sb.append("\">"+i+"</a>");
				
				sb.append("</span>");
			}
		}else if (countPage-4 > 0){
			for (long i = countPage-4 ; i <= countPage;i++){
				sb.append("<span class=\"page\">");
				
				sb.append("<a href=\"?page="+i);
				sb.append(sbParm);
				sb.append("\">"+i+"</a>");
				
				sb.append("</span>");
			}
		}else{
			for (long i = 1 ; i <= countPage;i++){
				sb.append("<span class=\"page\">");
				
				sb.append("<a href=\"?page="+i);
				sb.append(sbParm);
				sb.append("\">"+i+"</a>");
				
				sb.append("</span>");
			}
		}
		
		sb.append("<span class=\"page\" style=\"width: 40px !important;\">");
		
		sb.append("<a href=\"?page="+(countPage==0?1:countPage));
		sb.append(sbParm);
		sb.append("\">end</a>");
		
		sb.append("</span>");
		
		if (currentLong < countPage){
			sb.append("<span class=\"page\">");
			
			sb.append("<a href=\"?page="+currentLong+1);
			sb.append(sbParm);
			sb.append("\">»</a>");
			
			sb.append("</span>");
		}else{
			sb.append("<span class=\"page\">");
			
			sb.append("<a href=\"?page="+currentLong);
			sb.append(sbParm);
			sb.append("\">»</a>");
			
			sb.append("</span>");
		}
		
		sb.append("<span>");
//		sb.append("<input id=\"pageNum\" type=\"text\" placeholder=\"共"+countPage+"页\" style=\"width: 75px;height: 30px;\">");
		sb.append("</span>");
		
		sb.append("<span>");
//		sb.append("<button type=\"button\" class=\"btn btn-primary btn-xs\" style=\"padding-bottom: 1px;\" onclick=\"goPage('"+sbParm.toString()+"')\">跳转</button>");
		sb.append("</span>");
		
		
		
		return sb.toString();
	}
	
}