package cn.com.objcet.client.utils;
import java.util.HashMap;
import java.util.Map;

public class MapUtile {
	
	public static Map<String, Object> overMapall(Integer code,Object data){
		Map<String, Object> map =new HashMap<String,Object>();
		map.put("code", code);
		map.put("msg", ErrorUtil.RESULT_MASSAGE_MAP.get(code));
		if(StringUtils.isNotEmpty(data)){
			map.put("data", data);
		}
		return map;
	}
}
