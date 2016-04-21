package com.tianjunwei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianjunwei.log.dao.MqLogger;

/**
* @Title: MQLoggerController.java  
* @Package com.tianjunwei.controller  
* @Description: 测试类
* @author tianjunwei  tiantianjunwei@126.com   
* @date 2016年4月21日 下午11:16:09  
* @version V1.0
 */

@Controller
@RequestMapping("/mq")
public class MQLoggerController {
	
	@Autowired
	MqLogger mq;
	
	
	
	@ResponseBody
	@RequestMapping("/info")
	public String inf(){
		mq.info("info", new Throwable("info"));
		return "info";
	}
	
	@ResponseBody
	@RequestMapping("/debug")
	public String debug(){
		return "debug";
	}
	
	@ResponseBody
	@RequestMapping("/warn")
	public String warn(){
		return "warn";
	}
	
	@ResponseBody
	@RequestMapping("/error")
	public String error(){
		return "error";
	}

}
