/**
 * 明日科技
 * 于国良 2016-06-29
 * QQ:80303857
 */
package com.mrkj.ygl.util;

import java.io.File;
import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

public class CCommon {
	/**
	 * 打印异常信息
	 * @param method 方法名称
	 * @param e 异常对象
	 */
	public static void printException(String method, Exception e) {
		if (method != null)
			System.out.println(method);
		if (e != null)
			e.printStackTrace();
	}
	
	/**
	 * 比较两个字符串是否相同
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @return 比较结果，相同返回true，否则返回false
	 */
	public static boolean equalsString(String str1, String str2) {
		if (str1 == null) {
			return (str2 == null);
		} else {
			return str1.equals(str2);
		}
	}
	
	/**
	 * 比较两个字符串是否相同，忽略大小写
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @return 比较结果，相同返回true，否则返回false
	 */
	public static boolean equalsStringIgnoreCase(String str1, String str2) {
		if (str1 == null) {
			return (str2 == null);
		} else {
			return str1.equalsIgnoreCase(str2);
		}
	}
	
	/**
	 * 比较两个字符串
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @return 比较结果，str1=str2返回值等于0，str1<str2返回值小于0，str1>str2返回值大于0
	 */
	public static int compareString(String str1, String str2) {
		if (str1 == null) {
			return (str2 == null) ? 0 : -1;
		} else {
			return str1.compareTo(str2);
		}
	}
	
	/**
	 * 比较两个字符串，忽略大小写
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @return 比较结果，str1=str2返回值等于0，str1<str2返回值小于0，str1>str2返回值大于0
	 */
	public static int compareStringIgnoreCase(String str1, String str2) {
		if (str1 == null) {
			return (str2 == null) ? 0 : -1;
		} else {
			return str1.compareToIgnoreCase(str2);
		}
	}	
	
	/**
	 * 检查字符串中是否包含另一字符串
	 * @param str 用户检查是否包含其他字符串的字符串
	 * @param containsStr 包含的字符串
	 * @return 包含返回true，否则返回false
	 */
	public static boolean containsString(String str, String containsStr) {
		if (str == null || containsStr == null) {
			return false;
		}
		return str.contains(containsStr);
	}
	
	/**
	 * 检查字符串中是否包含另一字符串，检查过程中忽略大小写
	 * @param str 用户检查是否包含其他字符串的字符串
	 * @param containsStr 包含的字符串
	 * @return 包含返回true，否则返回false
	 */
	public static boolean containsStringIgnoreCase(String str, String containsStr) {
		if (str == null || containsStr == null) {
			return false;
		}
		return str.toLowerCase().contains(containsStr.toLowerCase());
	}
	
	/**
	 * 字符串转换整数
	 * @param str 字符串
	 * @param defaultValue 转换成的缺省整数
	 * @return 字符串转换的整数，转换失败，则返回缺省整数
	 */
	public static int stringToInteger(String str, int defaultValue) {
		int iValue;
		try {
			iValue = Integer.parseInt(str);
		}
		catch (Exception e) {
			iValue = defaultValue;
		}
		return iValue;
	}
	
	/**
	 * 字符串转换整数
	 * @param str 字符串
	 * @param defaultValue 转换成的缺省整数
	 * @return 字符串转换的整数，转换失败，则返回缺省整数
	 */
	public static long stringToLong(String str, long defaultValue) {
		long lValue;
		try {
			lValue = Long.parseLong(str);
		}
		catch (Exception e) {
			lValue = defaultValue;
		}
		return lValue;
	}
	
	/**
	 * 字符串转换字节
	 * @param str 字符串
	 * @param defaultValue 转换成的缺省字节
	 * @return 字符串转换的字节，转换失败，则返回缺省字节
	 */
	public static byte stringToByte(String str, byte defaultValue) {
		byte value;
		try {
			value = Byte.parseByte(str);
		}
		catch (Exception e) {
			value = defaultValue;
		}
		return value;
	}	
	
	/**
	 * 字符串是否等于null或者Empty
	 * @param str 字符串
	 * @return 字符串是否等于null或者Empty
	 */
	public static boolean isNullOrEmpty(String str) {
		return StringUtils.isBlank(str);
		//return (str == null || str.isEmpty());
	}
	
	/**
	 * 根据指定的字符串将字符串分割为字符串数组
	 * @param str 被切分的字符串
	 * @param regex 指定用于切分的字符串
	 * @return 被切分的字符串数组
	 */
	public static String[] splitString(String str, String regex) {
		if (!CCommon.isNullOrEmpty(str)) {
			String[] items = str.split(regex);
			if (items != null && items.length > 0)
				return items;
		}
		return null;
	}
	
	/**
	 * 根据指定的字符串将字符串分割为整数数组
	 * @param str 被切分的字符串
	 * @param regex 指定用于切分的字符串
	 * @return 被切分的字符串数组
	 */	
	public static int[] splitIntegers(String str, String regex) {
		int[] intArray = null;
		if (!CCommon.isNullOrEmpty(str)) {
			String[] items = str.split(regex);
			if (items != null && items.length > 0) {
				intArray = new int[items.length];
				for (int i = 0; i < items.length; i++) {
					intArray[i] = stringToInteger(items[i], 0);
				}
			}
		}
		return intArray;
	}
	
	/**
	 * 指定的类型是否是包装类
	 * @param type 指定的类型
	 * @return 类型是否是包装类
	 */	
	@SuppressWarnings("rawtypes")
	public static boolean isWrapClass(Class cls) {
		boolean result;
		if (cls == java.sql.Blob.class) {
			return true;
		}
		try {
			Field field = cls.getField("TYPE");
			Class type = (Class)field.get(null);
			result = type.isPrimitive();
        } catch (Exception e) {   
            result = false;
        }
		return result ? result : cls.equals(String.class);
    }
	
	/**
	 * 指定的类型是否是包装类或者基本类型
	 * @param type 指定的类型
	 * @return 类型是否是包装类或者基本类型
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isWrapClassOrSimpleType(Class<T> cls) {
		//object instanceof String, Number, Boolean, Character, null
		boolean result;
        try {
        	//判断是否为基本类型：int, double, float, long, short, boolean, byte, char，void
        	result = cls.isPrimitive();
        	if (!result) {
        		Field field = cls.getField("TYPE");
        		Class<T> type = (Class<T>)field.get(null);
        		result = type.isPrimitive();
        	}
        } catch (Exception e) { //NoSuchFieldException
        	result = false;
        }
		return result ? result : cls.equals(String.class);
	}
	
	/**
	 * 比较两个对象是否相等
	 * @param obj1 第一个对象
	 * @param obj2 第二个对象
	 * @return 两个对象相等返回true，否则返回false
	 */
	public static boolean equals(Object obj1, Object obj2) {
		if (obj1 == null)
			return (obj2 == null);
		return obj1.equals(obj2);
	}
	
	/**
	 * 转换对象为Long对象
	 * @param obj 转换的对象
	 * @return 转换后的Long对象
	 */
	public static long getLong(Object obj) {
		if (obj == null)
			return -1;
		try {
			return (Long)obj;
		}
		catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * 转换对象为Long对象
	 * @param obj 转换的对象
	 * @param min 转换目标值的最小值
	 * @return 转换后的Long对象
	 */	
	public static long getLongMin(Object obj, long min) {
		long result = getLong(obj);
		if (result != -1) {
			if (result <= min)
				result = -1;
		}
		return result;
	}
	
	/**
	 * 将一组整形数字组合成一个以指定分隔符分割成的字符串
	 * @param items 整形数字集合
	 * @param separator 分隔符
	 * @return 组合成的字符串
	 * @version 1.0   
	 */
	public final static String combineString(Integer[] items, String separator){
		if(items == null || items.length <= 0) {
			return "";
		}
		StringBuffer sbResult = new StringBuffer();
		for (int item : items) {
			sbResult.append(item);
			sbResult.append(separator);
		}
		sbResult.deleteCharAt(sbResult.length() - 1);
		return sbResult.toString();
	}
	
	/**
	 * 将一组整形数字组合成一个以指定分隔符分割成的字符串
	 * @param items 整形数字集合
	 * @param separator 分隔符
	 * @return 组合成的字符串
	 * @version 1.0   
	 */
	public final static String combineString(int[] items, String separator){
		if(items == null || items.length <= 0) {
			return "";
		}
		StringBuffer sbResult = new StringBuffer();
		for (int item : items) {
			sbResult.append(item);
			sbResult.append(separator);
		}
		sbResult.deleteCharAt(sbResult.length() - 1);
		return sbResult.toString();
	}
	
	/**
	 * 获取目录名称，如果目录以“/”或者“\”结尾，去除掉结尾字符
	 * @param path 原始目录
	 * @return 目标目录结尾不带“/”或者“\”
	 */
	public static String getDirectory(String path) {
		if (isNullOrEmpty(path))
			return null;
		if (path.endsWith("\\") || path.endsWith("/"))
			return path.substring(0, path.length() - 1);
		else
			return path;
	}
	
    /**
     * 创建文件，如果文件所在路径不存在则创建路径
     * @param filePath 文件完整名称（包含路径）
     * @return 创建的文件
     */
    public static File createFile(String filePath) {
        File targetFile = new File(filePath);
        if (targetFile.isDirectory()) {
        	targetFile.mkdirs();
        } else {
        	File parentFile = targetFile.getParentFile();
            if (!parentFile.exists()) {
            	parentFile.mkdirs();
            	targetFile = new File(targetFile.getAbsolutePath());
            }
        }
        return targetFile;
    }
    
    /**
     * 创建文件，如果文件所在路径不存在则创建路径
     * @param filePath 文件完整名称（包含路径）
     * @param isDirectory 文件是否为文件夹
     * @return 创建的文件
     */
    public static File createFile(String filePath, boolean isDirectory) {
        File targetFile = new File(filePath);
        if (isDirectory) {
        	targetFile.mkdirs();
        } else {
        	File parentFile = targetFile.getParentFile();
            if (!parentFile.exists()) {
            	parentFile.mkdirs();
            	targetFile = new File(targetFile.getAbsolutePath());
            }
        }
        return targetFile;
    }    
}
