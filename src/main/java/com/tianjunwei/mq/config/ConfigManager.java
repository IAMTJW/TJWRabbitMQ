/** 
*@ProjectName:TTRabbitMQ 
*@FileName: ConfigManager.java 
*@Date: 2016年4月16日下午4:48:51
*@Copyright: 2016 tianjunwei All rights reserved. 
*/ 
package com.tianjunwei.mq.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @Description: 配置文件类，读取RabbitMq的相关配置
 * @author tianjunwei
 * @date 2016年4月16日下午4:48:51
 * @modify by user: tianjunwei
 * @modify by reason: TODO
 * 
 * @version V1.0
 */
public class ConfigManager {
	
	private static Logger logger = LoggerFactory.getLogger(ConfigManager.class);
	
	public static Properties SystemPeroerties;
	static{
		 // system.properties读取 
        File systempoperties = null;
        systempoperties = new File(ConfigManager.class.getClassLoader().getResource("system.properties").getPath());
        FileInputStream inpf = null;  
        try {  
            inpf = new FileInputStream(systempoperties);  
        } catch (Exception e) { 
        	if(logger.isDebugEnabled()){
        		logger.debug("system.properties is loaded fail");
        	}
            e.printStackTrace();  
        }  
  
        // 获取配置文件
        SystemPeroerties = new Properties();  
        try {  
        	SystemPeroerties.load(inpf);  
        } catch (Exception e) {
        	if(logger.isDebugEnabled()){
        		logger.debug("RedisPeroerties is fali");
        	}
            e.printStackTrace();  
        }  
	}
}
