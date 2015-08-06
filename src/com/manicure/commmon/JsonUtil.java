package com.manicure.commmon;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.Collection;
import java.util.Date;

import com.manicure.commmon.JsonDateValueProcessor;
/**
 * 
 * @author zhangquanwei
 *
 */
public class JsonUtil {
	
	public static String json2Sting(Object o){
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		//JavaBean转JSON  
		return JSONObject.fromObject(o, jsonConfig).toString();
	}
	
	public static String jsonArray2Sting(Collection<?> o){
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		//Array 转JSON  
		return JSONArray.fromObject(o, jsonConfig).toString();
	}
}
