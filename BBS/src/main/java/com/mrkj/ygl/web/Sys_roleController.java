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

import com.mrkj.ygl.entity.role.Sys_permissionTree;
import com.mrkj.ygl.entity.role.Sys_role;
import com.mrkj.ygl.entity.role.Sys_roleTree;
import com.mrkj.ygl.service.role.Sys_permissionService;
import com.mrkj.ygl.service.role.Sys_permissionTreeService;
import com.mrkj.ygl.service.role.Sys_roleService;
import com.mrkj.ygl.service.role.Sys_role_permissionService;

@Controller
@RequestMapping("role")
public class Sys_roleController {

	@Resource
	Sys_roleService roleService;
	
	@Resource
	Sys_role_permissionService sysRolPerService;
	
	@Resource
	Sys_permissionService perService;
	
	@Resource
	Sys_permissionTreeService perTreeService;
	
	@RequestMapping("getTree")
	@ResponseBody
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public List<Sys_roleTree> getTree(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
	
		List<Sys_roleTree> listRole = roleService.selectTreeAll();
		
		return listRole;
	}
	
	@RequestMapping("getTreeCheck")
	@ResponseBody
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public List<Sys_permissionTree> getTreeCheck(HttpServletRequest request,HttpServletResponse response,String roleName) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		List<Sys_permissionTree> listPer = null;
		
		listPer = perTreeService.selectAll();
		
		return perTreeService.checked(listPer, roleName);
	}
	
	@RequestMapping("mainView")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView getMainView (){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("sys/role");
		
		return mav;
	}
	
	@RequestMapping("editView")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView getEdit(HttpServletRequest request,HttpServletResponse response,Sys_role role) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/role_per");
		mav.addObject("entity", role);
		/*List<Sys_role_permission> checked = sysRolPerService.selectByRoleName(role.getRoleName());
		if (checked!=null){
			mav.addObject("checked", checked);
		}*/
		return mav;
	}
	
	@RequestMapping("editFieldView")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView getEditField(HttpServletRequest request,HttpServletResponse response,Sys_role role) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/roleedit");
		mav.addObject("entity", role);
		
		return mav;
	}
	
	@RequestMapping("addView")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView getAdd(HttpServletRequest request,HttpServletResponse response,Sys_roleTree role) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/roleadd");
		return mav;
	}
	
	@RequestMapping("addRolePer")
	@ResponseBody
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public Map<String,String> addRolePer(HttpServletRequest request,HttpServletResponse response,String roleName,Integer roleId,String perparm) {
		Map<String,String> mav = new HashMap<String, String>();
		String[] splitParm = perparm.split(",");
		int i = 4;
		if (i>0){
			sysRolPerService.updateRolPer(roleName, roleId, splitParm);
			mav.put("success", "OK");
			mav.put("msg", "保存成功");
		}else{
			mav.put("success", "NO");
			mav.put("msg", "保存失败");
		}
		return mav;
	}
	
	@RequestMapping("edit")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response,Sys_role role) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/roleedit");
		
		int i = roleService.updateByPrimaryKeySelective(role);
		if (i>0){
			mav.addObject("entity", role);
			mav.addObject("success", "OK");
			mav.addObject("msg", "保存成功");
		}else{
			mav.addObject("entity", role);
			mav.addObject("success", "NO");
			mav.addObject("msg", "保存失败");
		}
		return mav;
	}
	
	@RequestMapping("add")
//	@RequiresRoles(value = { "admin" },logical=Logical.OR)
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response,Sys_role role) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/roleadd");
		role.setRolePid(0);
		int i = roleService.insertSelective(role);
		if (i>0){
			mav.addObject("entity", role);
			mav.addObject("success", "OK");
			mav.addObject("msg", "保存成功");
		}else{
			mav.addObject("entity", role);
			mav.addObject("success", "NO");
			mav.addObject("msg", "保存失败");
		}
		return mav;
	}
	
	@RequestMapping(value="remove/{id}",method=RequestMethod.GET)
//	@ResponseBody
	public Map<String,Boolean> romove (@PathVariable Integer id){
		Map<String,Boolean> resultMap = new HashMap<String, Boolean>();
		
		if (roleService.deleteByPrimaryKey(id)==1){
			resultMap.put("success", true);
		}else{
			resultMap.put("success", false);
		}
		
		return resultMap;
	}
}
