package com.cw.product.service.impl.productDemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cw.product.dao.productDemo.IProductDemoDao;
import com.cw.product.framework.basedao.IBaseDao;
import com.cw.product.framework.baseservice.impl.BaseServiceImpl;
import com.cw.product.service.productDemo.IProductDemoService;
import com.cw.product.util.common.SystemUtils;


/**
 * 
 * 产品DemoServiceImpl类
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * Administrator 	1.0  		2019年04月07日 	Created
 *
 * </pre>
 * @since 1.0
 */

@Service
public class ProductDemoServiceImpl extends BaseServiceImpl implements IProductDemoService {
	
	@Autowired
	private IProductDemoDao iProductDemoDao;

	@Override
	public IBaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return iProductDemoDao;
	}
    
	
	@Override
	public void beforeInsert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		map.put("id", SystemUtils.buidLongId());
	}

	@Override
	public void beforeUpdate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeDelete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}


}
