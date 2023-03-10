package com.mulcam.SpringProject.misc;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONUtill {
	
	@SuppressWarnings("unchecked")
	public String stringfy(List<String> list) {
		JSONObject obj = new JSONObject();
		obj.put("list", list);
		return obj.toString();
	}
	
	@SuppressWarnings("unchecked")
	public List<String> parse(String jsonStr){
		JSONParser parser = new JSONParser();
		List<String> list = null;
		try {
			JSONObject jsonList = (JSONObject) parser.parse(jsonStr);
			JSONArray jsonArr = (JSONArray) jsonList.get("list");
			list = (List<String>) jsonArr;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

}
