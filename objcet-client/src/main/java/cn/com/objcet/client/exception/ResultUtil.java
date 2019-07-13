package cn.com.objcet.client.exception;

import cn.com.objcet.client.utils.ErrorUtil;

public class ResultUtil {
	 /**
     * 返回成功，传入返回体具体出參
     * @param object
     * @return
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ErrorUtil.CODE_SUCCESS);
        result.setMsg(ErrorUtil.MSG_SUCCESS_MSG);
        result.setData(object);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    
    @SuppressWarnings("rawtypes")
	public static Result success(){
        return success(null);
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内
     * @param exceptionEnum
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Result error(ExceptionEnum exceptionEnum){
        Result result = new Result();
        result.setCode(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }
}
