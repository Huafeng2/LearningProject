/**
 * 明日科技
 * 于国良 2016-06-29
 * QQ:80303857
 */
package com.mrkj.ygl.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mrkj.ygl.entity.role.Sys_permission;
import com.mrkj.ygl.entity.role.Sys_permissionTree;
import com.mrkj.ygl.service.role.Sys_permissionService;
import com.mrkj.ygl.service.role.Sys_permissionTreeService;

@Controller
@RequestMapping("per")
public class Sys_permissionController {

	@Resource
	Sys_permissionService perService;
	
	@Resource
	Sys_permissionTreeService perTreeService;
	
	@RequestMapping("getTree")
	@ResponseBody
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public List<Sys_permissionTree> getTree(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		List<Sys_permissionTree> listPer = perTreeService.selectAll();
		return listPer;
	}
	
	@RequestMapping("mainView")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView getMainView (){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("sys/per");
		
		return mav;
	}
	
	@RequestMapping("addView")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView getAdd(HttpServletRequest request,HttpServletResponse response,Sys_permission per) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/peradd");
		mav.addObject("entity", per);
		return mav;
	}
	
	@RequestMapping("add")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView Add(HttpServletRequest request,HttpServletResponse response,Sys_permission per) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/peradd");
		int i = perService.insertSelective(per);
		if (i>0){
			mav.addObject("entity", per);
			mav.addObject("success", "OK");
			mav.addObject("msg", "保存成功");
			request.getServletContext().setAttribute("per", perTreeService.selectAll());
		}else{
			mav.addObject("entity", per);
			mav.addObject("success", "NO");
			mav.addObject("msg", "保存失败");
		}
		mav.addObject("entity", per);
		return mav;
	}
	
	@RequestMapping("editView")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView getEdit(HttpServletRequest request,HttpServletResponse response,Sys_permission per) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/peredit");
		mav.addObject("entity", per);
		return mav;
	}
	
	@RequestMapping("edit")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response,Sys_permission per) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/peredit");
		
		int i = perService.updateByPrimaryKey(per);
		if (i>0){
			mav.addObject("entity", per);
			mav.addObject("success", "OK");
			mav.addObject("msg", "保存成功");
			request.getServletContext().setAttribute("per", perTreeService.selectAll());
		}else{
			mav.addObject("entity", per);
			mav.addObject("success", "NO");
			mav.addObject("msg", "保存失败");
		}
		return mav;
	}
	
	@RequestMapping(value="remove/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Boolean> romove (@PathVariable Integer id){
		Map<String,Boolean> resultMap = new HashMap<String, Boolean>();
		
		if (perTreeService.deleteByPrimaryKey(id)==1){
			resultMap.put("success", true);
		}else{
			resultMap.put("success", false);
		}
		
		return resultMap;
	}
}
