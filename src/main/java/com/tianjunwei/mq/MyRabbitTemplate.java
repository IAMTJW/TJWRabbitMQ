/** 
*@ProjectName: TTRabbitMQ 
*@FileName: MyRabbitTemplate.java 
*@Date: 2016年4月17日 
*@Copyright: 2016 tianjunwei All rights reserved. 
*/  
package com.tianjunwei.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;

/**    
* @Title: MyRabbitTemplate.java  
* @Package com.tianjunwei.mq  
* @Description: RabbitTemplate的子类，添加是否开启方法 
* @author tianjunwei  tiantianjunwei@126.com   
* @date 2016年4月17日 下午9:35:49  
* @version V1.0    
*/
public class MyRabbitTemplate extends RabbitTemplate{
	
	private boolean store;

	public MyRabbitTemplate(){
		super();
	}
	public MyRabbitTemplate(ConnectionFactory connectionFactory){
		super();
	}
	
	/**
	 * @return the store
	 */
	public boolean isStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(boolean store) {
		this.store = store;
	}
	
}
