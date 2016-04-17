/** 
*@ProjectName: TTRabbitMQ 
*@FileName: Test.java 
*@Date: 2016年4月17日 
*@Copyright: 2016 tianjunwei All rights reserved. 
*/  
package com.tianjunwei;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.alibaba.druid.sql.visitor.functions.Reverse;
import com.tianjunwei.routingkey.ReceiveLogsDirect;

/**    
* @Title: Test.java  
* @Package com.tianjunwei  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tianjunwei  tiantianjunwei@126.com   
* @date 2016年4月17日 下午10:00:28  
* @version V1.0    
*/
public class Test {
	@org.junit.Test
	public void tetstd(){
		ReceiveLogsDirect direct = new ReceiveLogsDirect();
		String [] args = new String[2];
		try {
			direct.main(args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
