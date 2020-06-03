package com.mrkj.ygl.web.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mrkj.ygl.component.ForumComponent;
import com.mrkj.ygl.entity.forum.forumMain;
import com.mrkj.ygl.entity.sys.Dictionary;
import com.mrkj.ygl.service.forum.impl.ForumServiceImpl;
import com.mrkj.ygl.service.sys.DictionaryService;
import sun.rmi.runtime.Log;

@Controller
public class IndexController {
	private static final Logger logger = Logger.getLogger(IndexController.class);

	@Resource
	DictionaryService dictS;
	
	@Resource
	ForumServiceImpl forS;
	
	@Resource
	ForumComponent fc;
	
	@RequestMapping(value={"/index","/index.do","/index.html","index.action"})
	public ModelAndView initIndex (){
		logger.info("IndexController enter.");
		ModelAndView mav = new ModelAndView("index");
		
		String forumList = fc.getForumList();
		
		String[] forums = forumList.split(",");
		
		List<Map<String,List<forumMain>>> top5s = new ArrayList<>();
		
		for (String tempStr : forums ){
			List<Dictionary> forumTypes = dictS.selectByGroup(tempStr);
			mav.addObject(tempStr, forumTypes);
			for (Dictionary tempEntity : forumTypes){
				String typeKey = tempEntity.getDictKey();
				List<forumMain> top5  = forS.getRecommendTop5(typeKey);
					
				if (top5!=null&&top5.size()>0){
					Map<String,List<forumMain>> top5Map = new HashMap<>();
					top5Map.put(typeKey, top5);
					top5s.add(top5Map);
				}
			}
		}

		mav.addObject("top5s", top5s);
		logger.info("IndexController end.");
		return mav;
	}
	
}
