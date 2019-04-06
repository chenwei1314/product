package com.cw.product.util.redis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 系统会话工具类
 * @author Administrator
 *
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware{
	
	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		ApplicationContextUtil.context = context;
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

     
	

}
