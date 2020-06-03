package com.mrkj.ygl.controller.ue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/ue")
public class UEditorController {

	
	@RequestMapping(value="/sub",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> ueFileUpload(HttpServletRequest request){
		Map<String, String> resultMap = new HashMap<>();
		String referer = request.getHeader("Referer");
		System.out.println("referer:"+referer);
		
		Map<String, String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>>  entrySet = map.entrySet();
		for (Entry<String, String[]> entry : entrySet){
			System.out.println(entry.getKey());
			String[] values = entry.getValue();
			if (values.length>1){
				for (String value:values)
				System.out.println(value);
			}else{
				System.out.println(values[0]);
			}
		}
		
		return resultMap;
	}
	
	
	
}
