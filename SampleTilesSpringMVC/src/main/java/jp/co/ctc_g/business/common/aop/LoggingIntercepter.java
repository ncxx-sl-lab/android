// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 */
@Component
@Aspect
public class LoggingIntercepter {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(LoggingIntercepter.class);

	/**
	 * アクションのメソッドをポイントカット
	 */
	@Pointcut("execution(* jp.co.ctc_g.presentation.controller.*.*(..))")
	public void loggingActionPointCut() {
	}

	/**
	 *
	 * @param joinPoint ジョインポイント
	 */
	@Before("loggingActionPointCut()")
	public void loggingActionBefoue(final JoinPoint joinPoint) {
		StringBuffer logMessageStringBuffer = new StringBuffer();
		logMessageStringBuffer.append("@Before");
		logMessageStringBuffer.append(" class=[");
		logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
		logMessageStringBuffer.append("] method=[");
		logMessageStringBuffer.append(joinPoint.getSignature().getName());
		logMessageStringBuffer.append("]");
		LOGGER.info(logMessageStringBuffer.toString());
	}

	/**
	 *
	 * @param joinPoint ジョインポイント
	 * @param result 戻り値
	 */
	@AfterReturning(pointcut = "loggingActionPointCut()", returning = "result")
	public void loggingActionReturning(JoinPoint joinPoint, Object result) {
		if (result == null) {
			result = "";
		}
		StringBuffer logMessageStringBuffer = new StringBuffer();
		logMessageStringBuffer.append("@AfterReturning");
		logMessageStringBuffer.append(" class=[");
		logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
		logMessageStringBuffer.append("] method=[");
		logMessageStringBuffer.append(joinPoint.getSignature().getName());
		logMessageStringBuffer.append("] ret=[");
		logMessageStringBuffer.append(result.toString());
		logMessageStringBuffer.append("]");
		LOGGER.info(logMessageStringBuffer.toString());
	}

	/**
	 *
	 * @param joinPoint ジョインポイント
	 * @param error 例外
	 */
	@AfterThrowing(pointcut = "loggingActionPointCut()", throwing = "error")
	public void loggingActionThrowing(JoinPoint joinPoint, Throwable error) {
		StringBuffer logMessageStringBuffer = new StringBuffer();
		logMessageStringBuffer.append("@AfterThrowing");
		logMessageStringBuffer.append(" class=[");
		logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
		logMessageStringBuffer.append("] method=[");
		logMessageStringBuffer.append(joinPoint.getSignature().getName());
		logMessageStringBuffer.append("] exception=[");
		logMessageStringBuffer.append(error.toString());
		logMessageStringBuffer.append("]");

		LOGGER.info(logMessageStringBuffer.toString());
	}

	/**
	 *
	 * @param joinPoint ジョインポイント
	 */
	@After("loggingActionPointCut()")
	public void loggingActionAfter(JoinPoint joinPoint) {
		StringBuffer logMessageStringBuffer = new StringBuffer();
		logMessageStringBuffer.append("@After");
		logMessageStringBuffer.append(" class=[");
		logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
		logMessageStringBuffer.append("] method=[");
		logMessageStringBuffer.append(joinPoint.getSignature().getName());
		logMessageStringBuffer.append("]");
		LOGGER.info(logMessageStringBuffer.toString());
	}

}
