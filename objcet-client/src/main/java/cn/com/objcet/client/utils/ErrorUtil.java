package cn.com.objcet.client.utils;

import java.util.HashMap;
import java.util.Map;

public class ErrorUtil {
	public static final Integer RESULT_FAIL = 400;
	
	public static final Integer CODE_SUCCESS = 200;
	public static final String MSG_SUCCESS_MSG = "成功";

	public static final Integer CODE_ERROR = 201;
	public static final String MSG_ERROR_MSG = "失败";	
	
	
	public static final int LOGIN_NO_NAME=902;
    public static final int LOGIN_PASSWORD=901;
    public static final int LOGIN_CODE=903;
    public static final int LOGIN_TOKEN=904;
    public static final int TOKEN_NULL = 501;

	//自定义的状态码
    public static Map<Integer, String> RESULT_MASSAGE_MAP = null;

    static {
        RESULT_MASSAGE_MAP = new HashMap<Integer,String>();
        RESULT_MASSAGE_MAP.put(CODE_SUCCESS,"成功");
        RESULT_MASSAGE_MAP.put(LOGIN_NO_NAME,"用户和密码不匹配");
        RESULT_MASSAGE_MAP.put(LOGIN_NO_NAME,"当前用户不存在");
        RESULT_MASSAGE_MAP.put(LOGIN_CODE,"验证码输入错误");
        RESULT_MASSAGE_MAP.put(LOGIN_TOKEN,"token 不允许为空");
        RESULT_MASSAGE_MAP.put(TOKEN_NULL, "权限不足，请重新登录");
        
    }


}

