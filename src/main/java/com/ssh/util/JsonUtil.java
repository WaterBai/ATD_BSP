package com.ssh.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ssh.page.PageBean;

import net.sf.json.JSONObject;

public class JsonUtil {

	/**
	 * 后端分页json
	 * @param page 分页数据
	 * @return 分页json
	 */
	public static String PageJson(PageBean page) {
		List list = page.getResults();
		int total = page.getTotalCount();
		JSONObject jsonBean = new JSONObject();
		jsonBean.put("total", total);
		if (list==null){
			jsonBean.put("rows", new ArrayList());
		}else{
			jsonBean.put("rows", list);
		}
		return jsonBean.toString();
	}
	
	public static String JsonSuccess(boolean success, Object obj) {
		JSONObject jsonBean = new JSONObject();
		jsonBean.put("success", success);
		jsonBean.put("msg", obj);
		return jsonBean.toString();
	}
	
	public static String JsonSuccess(boolean success,String dataString) {
		JSONObject jsonBean = new JSONObject();
		jsonBean.put("success", success);
		jsonBean.put("msg", dataString);
		return jsonBean.toString();
	}

	public static String JsonSuccess(boolean success, int obj) {
		JSONObject jsonBean = new JSONObject();
		jsonBean.put("success", success);
		jsonBean.put("msg", obj);
		return jsonBean.toString();
	}

}
