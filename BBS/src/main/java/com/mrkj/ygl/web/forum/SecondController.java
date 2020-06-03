package com.mrkj.ygl.web.forum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mrkj.ygl.entity.login.Sys_login;
import com.mrkj.ygl.service.forum.impl.ForumServiceImpl;

@Controller
public class SecondController {

	@Resource
	ForumServiceImpl fS;
	
	@Resource
	SimpleDateFormat simpleDateFormat;
	
	@RequestMapping(value="/secondContent")
	public ModelAndView viewContro (HttpServletRequest request,String mainId,@RequestParam(name="order",defaultValue="ASC") String order,@RequestParam(name="page",defaultValue="1") Integer page,@RequestParam(name="row",defaultValue="15")Integer row){
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> path2 = fS.getPath2(null, mainId);

		String mainType = (String)path2.get("dict_key");
		String sName = (String)path2.get("dict_value");
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		StringBuffer sb = new StringBuffer(basePath);
		sb.append("mainContent?mainType=").append(mainType);
		mav.addObject("path2", sb.toString());
		mav.addObject("sName", sName);
		
		Map<String, Object> main = fS.getSecondMain(mainId);
		
		if (main != null){
			java.sql.Timestamp timestamp = (java.sql.Timestamp)main.get("main_creatime");  //数据库时间印章
			long time = timestamp.getTime();											   //转换为Long
			simpleDateFormat.applyPattern("yyyy年MM月dd日    hh时mm分ss秒");					   //设置时间格式
			String creatime = simpleDateFormat.format(new Date(time));					   //时间转换
			main.put("main_creatime", creatime);										   //修改元素
			mav.setViewName("secondContent");
			mav.addObject("main", main);
			List<Map<String, Object>> second = fS.getSecond(mainId, order, (page-1)*row, row);
			mav.addObject("second", second);
			long count = fS.getSecondCount(mainId);
			mav.addObject("count", count);													//总共跟帖数
			Map<String,String> parm = new HashMap<String, String>();
			parm.put("mainId", mainId);
			parm.put("order", order);
			
			String pageHtml = fS.getPage(count, page, row, parm);
			mav.addObject("pageHtml", pageHtml);
			
		}else{
			mav.setViewName("404");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/saveSencondContent")
	public ModelAndView saveSecond (HttpServletRequest request,String content,String mainId,String reId,@RequestParam(name="resequence",defaultValue="0")Integer resequence){
		
		ModelAndView mav = new ModelAndView("redirect:/secondContent?mainId="+mainId);
		
		if (reId==null||"".equals(reId)){
			reId = mainId	;
		}
		
		Map<String, Object> conMap = fS.convert(content);
		
		String convertContent = (String)conMap.get("content");
		//隐藏功能,如果用户使用特殊标签,可以给用户发送一条消息,该接口预留,该版本并未实现
		List<String> sequences = (List<String>)conMap.get("sequence");
		List<String> users = (List<String>)conMap.get("user");
		
		HttpSession session = request.getSession();
		Sys_login loginEntity = (Sys_login) session.getAttribute("loginEntity");
		int sequence = fS.getSequence(mainId);
		fS.insertSecond(mainId, convertContent,sequence, resequence, reId, loginEntity.getUsername(), loginEntity.getWxname());
		return mav;
	}
}
