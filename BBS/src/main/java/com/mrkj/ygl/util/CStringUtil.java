/**
 * 明日科技
 * 于国良 2016-06-29
 * QQ:80303857
 */
package com.mrkj.ygl.util;


public class CStringUtil {
	/**
	 * 格式化字符串
	 * 
	 * 例：formateString("xxx{0}bbb",1) = xxx1bbb
	 * 
	 * @param str 格式化的字符串
	 * @param params 字符串参数
	 * @return 格式化之后的字符串
	 */
	public final static String formateString(String str, String... params) {
		for (int i = 0; i < params.length; i++) {
			str = str.replace("{" + i + "}", params[i] == null ? "" : params[i]);
		}
		return str;
	}
	
	/**
	 * 首字母转大写其他不变
	 * @param str 字符串
	 * @return 首字母转大写后的字符串
	 * @version 1.0   
	 * @see 存储过程
	 */
	public final static String firstToBig(String str){
		String firstStr = String.valueOf(str.charAt(0)).toUpperCase();
		return firstStr + str.substring(1);
	}
	
	/**
	 * 循环拼接字符串
	 * @param str 字符串
	 * @param times 拼接的次数
	 * @return 拼接后的字符串
	 * @version 1.0   
	 */
	public final static String getLoopSpellOn(String str, int times){
		StringBuffer sb = new StringBuffer();
		if(times <= 0){
			return "";
		} else {
			for (int i=0; i < times; i++) {
				sb.append(str);
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			return sb.toString();
		}
	}
	
	/**
	 * 获取插入sql语句
	 * 返回 占位符方式的语句 
	 * ?占位  
	 * @param 
	 * @return 
	 * @version 1.0   
	 */
	public final static String getInsertSql(String tableName,String tableFields){
		return "insert into " + tableName + " (" + tableFields + ") values (" + CStringUtil.getLoopSpellOn("?", tableFields.split(",").length) + ")";
	}
	
	/**
	 * 获取更新sql语句
	 * 返回 占位符方式的语句 
	 * ?占位  
	 * @param 
	 * @return 
	 * @version 1.0   
	 */
	public final static String getUpdateSql(String tableName,String tableFields,String where){
		return "update " + tableName + " set " + getLoopSplit(tableFields.split(","), "=?") +" " + where;
	}
	
	/**
	 * 字符串组装
	 * @param 
	 * @return 
	 * @version 1.0   
	 */
	public final static String getLoopSplit(String[] split, String mark){
		if(split == null || split.length <= 0) {
			return "";
		}
		if (split.length == 1) {
			return split[0];
		}
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<split.length; i++) {
			sb.append(split[i] + mark);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "xxx{0}{1}bb{2}b";
		System.out.println(CStringUtil.formateString(str, "2", "r", "u"));
		System.out.println(firstToBig("abc"));
		System.out.println(getLoopSpellOn("?",5));
		System.out.println(getLoopSplit("a,b,c,d".split(","),"=?"));
		System.out.println(getInsertSql("XXX.SCHOOL_TMP_TEA", "a,b,c"));
		System.out.println(getUpdateSql("XXX.SCHOOL_TMP_TEA", "a,b,c",""));
	}

}

