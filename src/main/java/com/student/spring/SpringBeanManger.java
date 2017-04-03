package com.student.spring;

import org.springframework.context.ApplicationContext;

public class SpringBeanManger {
	
	private static ApplicationContext context;
	

	public static void initContext(ApplicationContext ctx){
		context=ctx;
	}
	
	public static Object getBean(String name){
		return context.getBean(name);
	}

	public static ApplicationContext getContext() {
		return context;
	}
	
	public static <T> T getBean(String name, Class<T> cls) {
		return context.getBean(name, cls);
	}
}
