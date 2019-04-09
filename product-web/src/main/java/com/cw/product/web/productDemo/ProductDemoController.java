package com.cw.product.web.productDemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cw.product.framework.basecontroller.impl.BaseControllerImpl;
import com.cw.product.framework.baseservice.IBaseService;
import com.cw.product.service.productDemo.IProductDemoService;


/**
 * 
 * 产品DemoController类
 * 
 * @version 
 * <pre>
 * Author Administrator
 * Version 	1.0
 * Date  2019年04月07日
 * </pre>
 * @since 1.0
 */

@Controller
@RequestMapping("/ProductDemoController")
public class ProductDemoController extends BaseControllerImpl {
	
	
	@Autowired
	private IProductDemoService iProductDemoService;
	
	@Override
	public IBaseService getBaseService() {
		// TODO Auto-generated method stub
		return iProductDemoService;
	}
	
	/**
	 * 跳转到产品DemoIndex页面
	 * @param request
	 * @return
	 */
	@RequestMapping(BaseControllerImpl.URL_PAGE)
	public ModelAndView indexProductDemo(HttpServletRequest request) {
		return new ModelAndView("/test");
	}
	
	/**
	 * 查询数据字典列表(分页)
	 * @param request
	 * @return
	 */
	@RequestMapping(BaseControllerImpl.URL_SELECTlIST_BYPAGE)
	@ResponseBody
	public JSON selectProductDemoListByPage(HttpServletRequest request) {
		return  this.selectListByPage(request);
	}
	
	/**
	 * 查询产品Demo列表(不分页)
	 * @param request
	 * @return
	 */
	@RequestMapping(BaseControllerImpl.URL_SELECTLIST)
	@ResponseBody
	public JSON selectProductDemoList(HttpServletRequest request) {
		return  this.selectList(request);
	}
	
	/**
	 * 查询产品Demo信息(通过Id)
	 * @param request
	 * @return
	 */
	@RequestMapping(BaseControllerImpl.URL_SELECTBYID)
	@ResponseBody
	public JSON selectProductDemoById(HttpServletRequest request){
		return  this.selectById(request);
	}
	
	/**
	 * 插入产品Demo信息
	 * @param request
	 * @return
	 */
	@RequestMapping(BaseControllerImpl.URL_INSERT)
	@ResponseBody
	public JSON insertProductDemo(HttpServletRequest request) {
		return  this.insert(request);
	}
	
	/**
	 * 删除产品Demo信息
	 * @param request
	 * @return
	 */
	@RequestMapping(BaseControllerImpl.URL_DELETE)
	@ResponseBody
	public JSON deleteProductDemo(HttpServletRequest request) {
		return this.delete(request);
	}
	
	/**
	 * 删除产品Demo信息(批量)
	 * @param request
	 * @return
	 */
	@RequestMapping(BaseControllerImpl.URL_DELETE_BYBATCH)
	@ResponseBody
	public JSON deleteProductDemoByBatch(HttpServletRequest request) {
		return this.deleteByBatch(request);
	}
	
	/**
	 * 更新产品Demo信息
	 * @param request
	 * @return
	 */
	@RequestMapping(BaseControllerImpl.URL_UPDATE)
	@ResponseBody
	public JSON updateProductDemo(HttpServletRequest request) {
		return this.update(request);
	}

}
