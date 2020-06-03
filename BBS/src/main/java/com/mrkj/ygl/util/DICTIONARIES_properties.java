/**
 * 明日科技
 * 于国良 2016-06-29
 * QQ:80303857
 */
package com.mrkj.ygl.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DICTIONARIES_properties {

	
	public static String getIdByName(Class glass,String name){
		Properties prop = new Properties();
		InputStream in = glass.getResourceAsStream("/DICTIONARIES.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dic_pid = prop.getProperty("DICTIONARIES_FILE_PARENTID");
		
		return dic_pid;
	}
	
	public static String getproperties(Class glass,String name){
		Properties prop = new Properties();
		InputStream in = glass.getResourceAsStream("/DICTIONARIES.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(name);
	}
	
}
