package com.tianjunwei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianjunwei.log.dao.MqLogger;

@Controller
@RequestMapping("/mq2")
public class MQLoggerController2 {
	
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
		mq.error("error", new Throwable("eroor"));
		return "error";
	}

}
