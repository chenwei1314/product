package com.cw.product.util.db.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import com.cw.product.util.db.listener.SpringContextLoaderListener;


/**
 * spring 工具类
 * @author Administrator
 *
 */
public final class SpringUtils {

    private static Logger logger = LoggerFactory.getLogger("SpringUtils");

    /**
     * 获取全局WebApplicationContext
     * 
     * @return 全局WebApplicationContext
     */
    public static WebApplicationContext getContext() {
        WebApplicationContext context = SpringContextLoaderListener.getWebRootAppContext();
        return context;
    }

    /**
     * 根据id获取bean
     * 
     * @return spring bean对象
     */
    public static Object getBean(String id) {
        Object bean = null;
        try {
            bean = getContext().getBean(id);
        } catch (RuntimeException e) {
            logger.error("SpringUtils.getBean(String id) get bean failure, bean id = " + id);
            throw e;
        }
        return bean;
    }
}
