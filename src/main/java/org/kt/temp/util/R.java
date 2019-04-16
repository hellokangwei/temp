package org.kt.temp.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public R() {
		put("code", 0);
		put("msg", "访问成功");
	}
	
	public static R error() {
		return error(500, "系统内部错误，请联系管理员");
	}
	
	public static R error(String msg) {
		return error(500, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public static R ok(List<?> data){
		R r = new R();
		r.put("code", "0");
		r.put("msg", "访问成功");
		r.put("data",data);
		return r;
	}

	public static R ok(Object data){
		R r = new R();
		r.put("code", "0");
		r.put("msg", "访问成功");
		r.put("data",data);
		return r;
	}
}
