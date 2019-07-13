package cn.com.objcet.client.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Administrator
 * 使用一个Handle来把Try，Catch中捕获的错误进行判定，
 * 是一个我们已知的错误信息，还是一个未知的错误信息，
 * 如果是未知的错误信息，那我们就用log记录它，便于之后的查找和解决
 */
@ControllerAdvice
public class ExceptionHandle {

  private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

  /**
   * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
   * @param e
   * @return
   */
  @SuppressWarnings("rawtypes")
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Result exceptionGet(Exception e){
      if(e instanceof DescribeException){
          DescribeException MyException = (DescribeException) e;
          return ResultUtil.error(MyException.getCode(),MyException.getMessage());
      }

      LOGGER.error("【系统异常】{}",e);
      return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
  }
}
