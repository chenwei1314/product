package com.cw.product.util.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统公用工具类
 * @author Administrator
 *
 */
public class V {
	final static Logger logger = LoggerFactory.getLogger(V.class);
	
	public final static String UTF8 = "UTF-8";
	public final static String UI = "ui";
	public final static String WEB_INF = "WEB-INF";
	public final static String CLASSESS = "classes";
	public final static String PAGES = "pages";
	public final static String File_SEP = "/";
	public final static String EASYUI = "easyui";
	public final static String File_COMMA = ",";
	/**
	 * 处理请求JS
	 * @param request
	 * @param requestPath
	 * @return
	 */
	public static String buildRequestPath(HttpServletRequest request ,String requestPath){
		String fullPath = "";
		if(request.getRequestURI().contains(UI)) {
			fullPath = buildUiPath(request,requestPath);
		}else{
			fullPath = buildPagePath(request,requestPath);
		}
		return fullPath;
	}
	/**
	 * 处理UIJS
	 * @param request
	 * @param requestPath
	 * @return
	 */
	public static String buildUiPath(HttpServletRequest request ,String requestPath){
		String requestUri = request.getRequestURI();
		requestUri = UI+File_SEP+requestUri.substring(14,requestUri.length());
		if(requestPath.contains(WEB_INF))
			requestPath = requestPath.substring(0,requestPath.indexOf(WEB_INF));
		return requestPath+requestUri;
	}
	/**
	 * 处理page页面下的js
	 * @param request
	 * @param requestPath
	 * @return
	 */
	public static String buildPagePath(HttpServletRequest request,String requestPath){
		String requestUri = request.getRequestURI();
		if(StringUtils.isNotBlank(requestUri))
			requestUri=requestUri.substring(request.getContextPath().length(),requestUri.length());
		if(requestPath.contains(CLASSESS))
			requestPath = requestPath.substring(0,requestPath.indexOf(CLASSESS));
		return requestPath+PAGES+requestUri;
	}
	
	
	/**
	 * 获取请求浏览器类型(登录时用)
	 * @param request
	 * @return
	 */
	public static String getBrowVersion(HttpServletRequest request){
		String browInfo = request.getHeader("user-agent")==null ?"MSIE 9.0" :request.getHeader("user-agent");
		String browVersion = "";
		if(browInfo.indexOf("MSIE") != -1) browVersion = "IE";
		if(browInfo.indexOf("Firefox") != -1)  browVersion = "Firefox";
		if(browInfo.indexOf("Chrome") != -1 && browInfo.indexOf("Safari") != -1) browVersion = "Chrome";
		return browVersion;
	}
	/**
	 * js
	 * @param request
	 * @param path
	 * @return
	 */
	public static String includedJavascript(HttpServletRequest request,String path) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript'");
		sb.append(" src='").append(path).append("'>");
		sb.append("</script>");
		return sb.toString();
	}
	/**
	 * css
	 * @param request
	 * @param path
	 * @return
	 */
	public static String includedStyle(HttpServletRequest request, String path) {
		StringBuffer sb = new StringBuffer();
		sb.append("<link type='text/css' rel='stylesheet'");
		sb.append(" href='").append(path).append("'>");
		return sb.toString();
	}
	
	/**
	 * 下载输出js
	 * @param response
	 * @param o
	 */
	public static void outPrintJs(HttpServletResponse response, String o) {
		response.setCharacterEncoding(UTF8);
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(o);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	
}
