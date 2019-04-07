package com.cw.product.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.cw.product.util.db.UpgradeDatabase;



/**
 * 自动升级脚本
 * @author Administrator
 *
 */
@Component
public class InitParameterListener implements ApplicationListener<ContextRefreshedEvent> {
    
	private Logger logger = LoggerFactory.getLogger(InitParameterListener.class);
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent()!=null){
			/**
			 * 暂不启动自动升级脚本
			 */
			checkAndUpgradeDatabase();
		}
		
		
	}
	/**
	 * 自动升级数据库
	 */
	private void checkAndUpgradeDatabase() {
		logger.info("检测和执行升级数据库。。。");
		UpgradeDatabase upgrade = new UpgradeDatabase();
		try {
			upgrade.init();
			upgrade.doUpgrade();
		} catch (Exception e) {
			logger.error("检测和执行升级数据库失败，需要手动升级：" + e.getMessage(), e);
			throw new RuntimeException("检测和执行升级数据库失败，需要手动升级：" + e.getMessage(), e);
		} finally {
			upgrade.release();
		}
	}

}
