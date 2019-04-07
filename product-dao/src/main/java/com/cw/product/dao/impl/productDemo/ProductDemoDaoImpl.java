package com.cw.product.dao.impl.productDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cw.product.dao.productDemo.IProductDemoDao;
import com.cw.product.framework.basedao.impl.BaseDaoImpl;
import com.cw.product.framework.baseentity.IBaseMapper;
import com.cw.product.mapper.productDemo.IProductDemoMapper;

/**
 * 
 * 产品DemoDaoImpl
 * 
 * @version 
 * <pre>
 * Author  Administrator	
 * Version 1.0 				
 * Date	 2019年04月07日
 * </pre>
 * @since 1.
 */

@Repository 
public class ProductDemoDaoImpl extends BaseDaoImpl implements IProductDemoDao {
	
	@Autowired
	private IProductDemoMapper  iProductDemoMapper;

	@Override
	public IBaseMapper getBaseMapper() {
		// TODO Auto-generated method stub
		return iProductDemoMapper;
	}

}
