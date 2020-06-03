/**
 * 明日科技
 * 于国良 2016-06-29
 * QQ:80303857
 */
package com.mrkj.ygl.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Result {
	private boolean success = true;
	private Object message = "操作成功";
	private Object data;

	public Result() {
	}
	
	public Result(boolean success, Object message) {
		super();
		this.success = success;
		this.message = message;
	}
	public Result(boolean success){
		this.success=success;
	}
	public Result(Object data) {
		this.data=data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
