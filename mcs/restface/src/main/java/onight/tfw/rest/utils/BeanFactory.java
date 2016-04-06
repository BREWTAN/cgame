package onight.tfw.rest.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * bean容器
 */
public class BeanFactory implements ApplicationContextAware {
	private static ApplicationContext ctx;

	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}
	
}
