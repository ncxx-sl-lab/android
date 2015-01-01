package jp.sji_inc.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingIntercepter {

	private static final Logger logger = Logger.getLogger(LoggingIntercepter.class);

	/**
	 * アクションのメソッドをポイントカット
	 */
	@Pointcut("execution(* jp.sji_inc.action.*.*(..))")
	public void RestActionLogPointCut() {
	}

	@Before("RestActionLogPointCut()")
	public void loggingActionBefoue(JoinPoint joinPoint){
		StringBuffer buf = new StringBuffer();
		buf.append("RestActionLogPointCut@Before");
		buf.append(" ");
		buf.append(joinPoint.getTarget().getClass().getName());
		buf.append(" ");
		buf.append(joinPoint.getSignature().getName());
		logger.info(buf.toString());
	}

//	@AfterReturning(pointcut="RestActionLogPointCut()",returning="result")
//	public void loggingActionReturning(JoinPoint joinPoint, Object result) {
//		if (result == null) {
//			result = "";
//		}
//		StringBuffer logMessageStringBuffer = new StringBuffer();
//		logMessageStringBuffer.append("@AfterReturning");
//		logMessageStringBuffer.append(" class=[");
//		logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
//		logMessageStringBuffer.append("] method=[");
//		logMessageStringBuffer.append(joinPoint.getSignature().getName());
//		logMessageStringBuffer.append("] ret=[");
//		logMessageStringBuffer.append(result.toString());
//		logMessageStringBuffer.append("]");
//		logger.info(logMessageStringBuffer.toString());
//	}
//
//	@AfterThrowing(pointcut="RestActionLogPointCut()", throwing= "error")
//	public void loggingActionThrowing(JoinPoint joinPoint,Throwable error) {
//		StringBuffer logMessageStringBuffer = new StringBuffer();
//		logMessageStringBuffer.append("@AfterThrowing");
//		logMessageStringBuffer.append(" class=[");
//		logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
//		logMessageStringBuffer.append("] method=[");
//		logMessageStringBuffer.append(joinPoint.getSignature().getName());
//		logMessageStringBuffer.append("] exception=[");
//		logMessageStringBuffer.append(error.toString());
//		logMessageStringBuffer.append("]");
//		logger.info(logMessageStringBuffer.toString());
//	}
//
//	@After("RestActionLogPointCut()")
//	public void loggingActionAfter(JoinPoint joinPoint) {
//		StringBuffer logMessageStringBuffer = new StringBuffer();
//		logMessageStringBuffer.append("@After");
//		logMessageStringBuffer.append(" class=[");
//		logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
//		logMessageStringBuffer.append("] method=[");
//		logMessageStringBuffer.append(joinPoint.getSignature().getName());
//		logMessageStringBuffer.append("]");
//		logger.info(logMessageStringBuffer.toString());
//	}
//
//	@Around("RestActionLogPointCut()")
//	public void loggingActionAround(ProceedingJoinPoint joinPoint) throws Throwable {
//		StringBuffer logMessageStringBuffer = new StringBuffer();
//		logMessageStringBuffer.append("@Around Before");
//		logMessageStringBuffer.append(" class=[");
//		logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
//		logMessageStringBuffer.append("] method=[");
//		logMessageStringBuffer.append(joinPoint.getSignature().getName());
//		logMessageStringBuffer.append("]");
//		logger.info(logMessageStringBuffer.toString());
//
//		joinPoint.proceed();
//
//		logMessageStringBuffer = new StringBuffer();
//		logMessageStringBuffer.append("@Around After");
//		logMessageStringBuffer.append(" class=[");
//		logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
//		logMessageStringBuffer.append("] method=[");
//		logMessageStringBuffer.append(joinPoint.getSignature().getName());
//		logMessageStringBuffer.append("]");
//		logger.info(logMessageStringBuffer.toString());
//	}


}
