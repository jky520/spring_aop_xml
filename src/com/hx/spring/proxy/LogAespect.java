package com.hx.spring.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.hx.spring.log.Logger;

/**
 * @author @DT人 2017年7月24日 下午8:35:50
 *
 */
@Component("logAspect") // 让这个切面类被spring所管理
public class LogAespect {
	
	public void logStart(JoinPoint jp) { // 连接点JoinPoint
		// getTarget得到执行的对象
		System.out.println(jp.getTarget());
		// getSignature得到执行的方法
		System.out.println(jp.getSignature().getName());
		Logger.info("方法调用前");
	}
	
	
	public void logEnd(JoinPoint jp) {
		Logger.info("方法调用后");
	}
	
	
	public void logAround(ProceedingJoinPoint pjp) {
		Logger.info("开始在arond中加入日志");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} // 执行程序
		Logger.info("结束Around的日志加入");
	}
}
