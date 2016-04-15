/** 
*@ProjectName: TTRabbitMQ 
*@FileName: MybatisTest.java 
*@Date: 2016年4月14日 
*@Copyright: 2016 tianjunwei All rights reserved. 
*/  
package com.tianjunwei.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianjunwei.log.dao.entity.Log;

/**    
* @Title: MybatisTest.java  
* @Package com.tianjunwei.mybatis  
* @Description: 测试mybatis配置 
* @author tianjunwei  tiantianjunwei@126.com   
* @date 2016年4月14日 下午11:59:06  
* @version V1.0    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_test.xml")
public class MybatisTest {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Test 
	public void get(){
		Log log = sqlSessionTemplate.selectOne(Log.class.getName()+".get");
		System.err.println(log.getLogInfo());
	}

}
