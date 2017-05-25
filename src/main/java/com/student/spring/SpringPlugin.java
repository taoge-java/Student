package com.student.spring;

import org.springframework.context.ApplicationContext;

import com.jfinal.plugin.IPlugin;
import com.student.interceptor.IocInterceptor;

/**
 * 集成Spring插件
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年5月25日 下午3:48:51
 */
public class SpringPlugin implements IPlugin{

	private ApplicationContext context;
	
	public SpringPlugin(ApplicationContext context){
		this.context=context;
	}
	
	@Override
	public boolean start() {
		if(context!=null){
			IocInterceptor.ctx=context;
		}
		return true;
	}

	@Override
	public boolean stop() {
		return true;
	}
}
