/**
 * 明日科技
 * 于国良 2016-06-29
 * QQ:80303857
 */
package com.mrkj.ygl.util;

public class SystemContext {	
	private static ThreadLocal<Integer> offset=new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> limit=new ThreadLocal<Integer>();
	
	public static int getOffset() {
		return offset.get();
	}
	public static void setOffset(int _offset) {
		offset.set(_offset);
	}
	public static void removeOffset()
	{
		offset.remove();
	}
	public static int getLimit() {
		return limit.get();
	}
	public static void setLimit(int _limit) {
		limit.set(_limit);
	}
	public static void removeLimit()
	{
		limit.remove();
	}	

}
