package cn.com.objcet.api.service.aspect;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.com.objcet.client.exception.ExceptionHandle;
import cn.com.objcet.client.exception.Result;

/**
 * AOP 切面类
 * @author Administrator
 *
 */
@Aspect
@Component
public class HttpAspect {

	private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

	@Autowired
	private ExceptionHandle exceptionHandle;

	@Pointcut("execution(public * cn.com.objcet.*.*.*.controller.*.*(..))")
	public void log(){

	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		LOGGER.info("url={}",request.getRequestURL());
		//method
		LOGGER.info("method={}",request.getMethod());
		//ip
		LOGGER.info("id={}",request.getRemoteAddr());
		//class_method
		LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
		//args[]
		LOGGER.info("args={}",joinPoint.getArgs());
	}

	
	@SuppressWarnings({ "unused", "rawtypes" })
	@Around("log()")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Result result = null;
		try {

		} catch (Exception e) {
			return exceptionHandle.exceptionGet(e);
		}
		if(result == null){
			return proceedingJoinPoint.proceed();
		}else {
			return result;
		}
	}

	@AfterReturning(pointcut = "log()",returning = "object")//打印输出结果
	public void doAfterReturing(Object object){
		LOGGER.info("response={}",object.toString());
	}
}
