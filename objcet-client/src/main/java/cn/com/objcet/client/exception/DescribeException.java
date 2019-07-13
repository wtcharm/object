package cn.com.objcet.client.exception;
import cn.com.objcet.client.utils.ErrorUtil;

/**
 * 
 * @author Administrator
 * 继承RuntimeException这个类后重新定义一个构造方法来定义我们自己的错误信息
 */
public class DescribeException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1781999264667767520L;
	private Integer code;

    /**
     * 继承exception，加入错误状态值
     * @param exceptionEnum
     */
	
    public DescribeException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    /**
     * 自定义错误信息
     * @param message
     * @param code
     */
    
    public DescribeException(Integer code,String message) {
        super(message);
        this.code = code;
    }
    
    
    
    public DescribeException(Integer code) {
    	super(ErrorUtil.RESULT_MASSAGE_MAP.get(code));
		this.code = code;
	}

	public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
