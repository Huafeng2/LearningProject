/**
 * 明日科技
 * 于国良 2016-06-29
 * QQ:80303857
 */
package com.mrkj.ygl.util;

import java.util.UUID;
/**
 * @description  生成UUID工具类
 * @author 	shikl
 * @date 	2015-9-24 下午3:28:45
 */
public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
}
