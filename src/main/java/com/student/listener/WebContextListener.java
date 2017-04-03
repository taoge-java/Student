package com.student.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jfinal.log.Logger;
import com.student.spring.SpringBeanManger;
/**
 * 系统监听器,初始化加载数据
 * @author Administrator
 *
 */
public class WebContextListener implements ServletContextListener{
	
	Logger log=Logger.getLogger(WebContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.info("spring-context start........");
		ApplicationContext app=new ClassPathXmlApplicationContext("spring-context.xml");
		SpringBeanManger.initContext(app);
		log.info("spring-context.xml加载完成.......");
	}

}
