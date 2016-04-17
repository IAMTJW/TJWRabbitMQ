/** 
 * @ProjectName: TTRabbitMQ 
 * @FileName: MqLogger.java 
 * @Date: 2016年4月17日 
 * @Copyright: 2016 tianjunwei All rights reserved. 
 */  
package com.tianjunwei.log.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

/**
 * 模仿ch.qos.logback.classic.Logger这个类
 * @author tianjunwei
 * @date 2016年4月17日下午4:21:47
 * @modify by user: tianjunwei
 * @modify by reason:
 * @version V1.0
 */
public class MqLogger implements Logger {

	
	Logger log ;
	
	
	public MqLogger(Class<?> clazz) {
		log = LoggerFactory.getLogger(clazz);
	}
	
	/**
	 *
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public String getName() {
		return log.getName();
	}

	/**
	 *
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	/**
	 *
	 * @param msg 
	 * 2016年4月17日
	 */ 
	@Override
	public void trace(String msg) {
		log.trace(msg);
	}

	/**
	 *
	 * @param format
	 * @param arg 
	 * 2016年4月17日
	 */ 
	@Override
	public void trace(String format, Object arg) {
		log.trace(format, arg);
	}

	/**
	 *
	 * @param format
	 * @param arg1
	 * @param arg2 
	 * 2016年4月17日
	 */ 
	@Override
	public void trace(String format, Object arg1, Object arg2) {
		log.trace(format, arg1, arg2);
	}

	/**
	 *
	 * @param format
	 * @param arguments 
	 * 2016年4月17日
	 */ 
	@Override
	public void trace(String format, Object... arguments) {
		log.trace(format, arguments);
	}

	/**
	 *
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	@Override
	public void trace(String msg, Throwable t) {
		log.trace(msg, t);
	}

	/**
	 *
	 * @param marker
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public boolean isTraceEnabled(Marker marker) {
		return log.isTraceEnabled(marker);
	}

	/**
	 *
	 * @param marker
	 * @param msg 
	 * 2016年4月17日
	 */ 
	@Override
	public void trace(Marker marker, String msg) {
		log.trace(marker, msg);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arg 
	 * 2016年4月17日
	 */ 
	@Override
	public void trace(Marker marker, String format, Object arg) {
		log.trace(marker, format, arg);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arg1
	 * @param arg2 
	 * 2016年4月17日
	 */ 
	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		log.trace(marker, format, arg1, arg2);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param argArray 
	 * 2016年4月17日
	 */ 
	@Override
	public void trace(Marker marker, String format, Object... argArray) {
		log.trace(marker, format, argArray);
	}

	/**
	 *
	 * @param marker
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	@Override
	public void trace(Marker marker, String msg, Throwable t) {
		log.trace(marker, msg, t);
	}

	/**
	 *
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	/**
	 *
	 * @param msg 
	 * 2016年4月17日
	 */ 
	@Override
	public void debug(String msg) {
		log.debug(msg);
	}

	/**
	 *
	 * @param format
	 * @param arg 
	 * 2016年4月17日
	 */ 
	@Override
	public void debug(String format, Object arg) {
		log.debug(format, arg);
	}

	/**
	 *
	 * @param format
	 * @param arg1
	 * @param arg2 
	 * 2016年4月17日
	 */ 
	@Override
	public void debug(String format, Object arg1, Object arg2) {
		log.debug(format, arg1, arg2);
	}

	/**
	 *
	 * @param format
	 * @param arguments 
	 * 2016年4月17日
	 */ 
	@Override
	public void debug(String format, Object... arguments) {
		log.debug(format, arguments);
	}

	/**
	 *
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	@Override
	public void debug(String msg, Throwable t) {
		log.debug(msg, t);
	}

	/**
	 *
	 * @param marker
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public boolean isDebugEnabled(Marker marker) {
		return log.isDebugEnabled(marker);
	}

	/**
	 *
	 * @param marker
	 * @param msg 
	 * 2016年4月17日
	 */ 
	@Override
	public void debug(Marker marker, String msg) {
		log.debug(marker, msg);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arg 
	 * 2016年4月17日
	 */ 
	@Override
	public void debug(Marker marker, String format, Object arg) {
		log.debug(marker, format, arg);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arg1
	 * @param arg2 
	 * 2016年4月17日
	 */ 
	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		log.debug(marker, format, arg1, arg2);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arguments 
	 * 2016年4月17日
	 */ 
	@Override
	public void debug(Marker marker, String format, Object... arguments) {
		log.debug(marker, format, arguments);
	}

	/**
	 *
	 * @param marker
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	@Override
	public void debug(Marker marker, String msg, Throwable t) {
		log.debug(marker, msg, t);
	}

	/**
	 *
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	/**
	 *
	 * @param msg 
	 * 2016年4月17日
	 */ 
	@Override
	public void info(String msg) {
		log.info(msg);
	}

	/**
	 *
	 * @param format
	 * @param arg 
	 * 2016年4月17日
	 */ 
	@Override
	public void info(String format, Object arg) {
		log.info(format, arg);
	}

	/**
	 *
	 * @param format
	 * @param arg1
	 * @param arg2 
	 * 2016年4月17日
	 */ 
	@Override
	public void info(String format, Object arg1, Object arg2) {
		log.info(format, arg1, arg2);
	}

	/**
	 *
	 * @param format
	 * @param arguments 
	 * 2016年4月17日
	 */ 
	@Override
	public void info(String format, Object... arguments) {
		log.info(format, arguments);
	}

	/**
	 *
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	@Override
	public void info(String msg, Throwable t) {
		log.info(msg, t);
	}

	/**
	 *
	 * @param marker
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public boolean isInfoEnabled(Marker marker) {
		return log.isInfoEnabled(marker);
	}

	/**
	 *
	 * @param marker
	 * @param msg 
	 * 2016年4月17日
	 */ 
	@Override
	public void info(Marker marker, String msg) {
		log.info(marker, msg);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arg 
	 * 2016年4月17日
	 */ 
	@Override
	public void info(Marker marker, String format, Object arg) {
		log.info(marker, format, arg);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arg1
	 * @param arg2 
	 * 2016年4月17日
	 */ 
	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		log.info(marker, format, arg1, arg2);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arguments 
	 * 2016年4月17日
	 */ 
	@Override
	public void info(Marker marker, String format, Object... arguments) {
		log.info(marker, format, arguments);
	}

	/**
	 *
	 * @param marker
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	@Override
	public void info(Marker marker, String msg, Throwable t) {
		log.info(marker, msg, t);
	}

	/**
	 *
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public boolean isWarnEnabled() {
		return log.isWarnEnabled();
	}

	/**
	 *
	 * @param msg 
	 * 2016年4月17日
	 */ 
	@Override
	public void warn(String msg) {
		log.warn(msg);
	}

	/**
	 *
	 * @param format
	 * @param arg 
	 * 2016年4月17日
	 */ 
	@Override
	public void warn(String format, Object arg) {
		log.warn(format, arg);
	}

	/**
	 *
	 * @param format
	 * @param arguments 
	 * 2016年4月17日
	 */ 
	@Override
	public void warn(String format, Object... arguments) {
		log.warn(format, arguments);
	}

	/**
	 *
	 * @param format
	 * @param arg1
	 * @param arg2 
	 * 2016年4月17日
	 */ 
	@Override
	public void warn(String format, Object arg1, Object arg2) {
		log.warn(format, arg1, arg2);
	}

	/**
	 *
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	@Override
	public void warn(String msg, Throwable t) {
		log.warn(msg, t);
	}

	/**
	 *
	 * @param marker
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public boolean isWarnEnabled(Marker marker) {
		return log.isWarnEnabled(marker);
	}

	/**
	 *
	 * @param marker
	 * @param msg 
	 * 2016年4月17日
	 */ 
	@Override
	public void warn(Marker marker, String msg) {
		log.warn(marker, msg);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arg 
	 * 2016年4月17日
	 */ 
	@Override
	public void warn(Marker marker, String format, Object arg) {
		log.warn(marker, format, arg);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arg1
	 * @param arg2 
	 * 2016年4月17日
	 */ 
	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		log.warn(marker, format, arg1, arg2);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arguments 
	 * 2016年4月17日
	 */ 
	@Override
	public void warn(Marker marker, String format, Object... arguments) {
		log.warn(marker, format, arguments);
	}

	/**
	 *
	 * @param marker
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	@Override
	public void warn(Marker marker, String msg, Throwable t) {
		log.warn(marker, msg, t);
	}

	/**
	 *
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public boolean isErrorEnabled() {
		return log.isErrorEnabled();
	}

	/**
	 *
	 * @param msg 
	 * 2016年4月17日
	 */ 
	@Override
	public void error(String msg) {
		log.error(msg);
	}

	/**
	 *
	 * @param format
	 * @param arg 
	 * 2016年4月17日
	 */ 
	@Override
	public void error(String format, Object arg) {
		log.error(format, arg);
	}

	/**
	 *
	 * @param format
	 * @param arg1
	 * @param arg2 
	 * 2016年4月17日
	 */ 
	@Override
	public void error(String format, Object arg1, Object arg2) {
		log.error(format, arg1, arg2);
	}

	/**
	 *
	 * @param format
	 * @param arguments 
	 * 2016年4月17日
	 */ 
	@Override
	public void error(String format, Object... arguments) {
		log.error(format, arguments);
	}

	/**
	 *
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	@Override
	public void error(String msg, Throwable t) {
		log.error(msg, t);
	}

	/**
	 *
	 * @param marker
	 * @return 
	 * 2016年4月17日
	 */ 
	@Override
	public boolean isErrorEnabled(Marker marker) {
		return log.isErrorEnabled(marker);
	}

	/**
	 *
	 * @param marker
	 * @param msg 
	 * 2016年4月17日
	 */ 
	@Override
	public void error(Marker marker, String msg) {
		log.error(marker, msg);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arg 
	 * 2016年4月17日
	 */ 
	@Override
	public void error(Marker marker, String format, Object arg) {
		log.error(marker, format, arg);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arg1
	 * @param arg2 
	 * 2016年4月17日
	 */ 
	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		log.error(marker, format, arg1, arg2);
	}

	/**
	 *
	 * @param marker
	 * @param format
	 * @param arguments 
	 * 2016年4月17日
	 */ 
	@Override
	public void error(Marker marker, String format, Object... arguments) {
		log.error(marker, format, arguments);
	}

	/**
	 *
	 * @param marker
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	@Override
	public void error(Marker marker, String msg, Throwable t) {
		log.error(marker, msg, t);
	}
	
}
