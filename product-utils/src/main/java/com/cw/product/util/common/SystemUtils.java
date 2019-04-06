package com.cw.product.util.common;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Administrator
 *
 */
public class SystemUtils {
	
	/*---用户上传文件地址---*/
	public final static String LOVE_UPLOAD = "upload";
	/*-----逗号----*/
	public final static String LOVE_COMMA = ",";
	/*----java---home---*/
	public final static String LOVE_JAVA_HOME = "java.home";
	/*---用户上传图片---*/
	public final static String LOVE_IMAGE = "image";
	/*---用户上传音乐---*/
	public final static String LOVE_MUSIC = "music";
	/*---文件分隔符-----*/
	public final static String LOVE_SEPARATOR = "/";
	/*--盘符----*/
	public final static String LOVE_DISKC = "C:";
	
	
	
	/**
	 * 提供图片上传路径
	 * @param type
	 * @return
	 */
	public static String getUserWorkHome(String type) {
		// 上传图片
		if (StringUtils.equals(type, LOVE_IMAGE)) {
			return System.getProperty(LOVE_JAVA_HOME) == null ? LOVE_DISKC
					+ File.separatorChar + LOVE_UPLOAD : System
					.getProperty(LOVE_JAVA_HOME).substring(0, 2)
					+ File.separatorChar
					+ LOVE_UPLOAD
					+ File.separatorChar + LOVE_IMAGE;
			// 上传音乐
		} else if (StringUtils.equals(type, LOVE_MUSIC)) {
			return System.getProperty(LOVE_JAVA_HOME) == null ? LOVE_DISKC
					+ File.separatorChar + LOVE_UPLOAD : System
					.getProperty(LOVE_JAVA_HOME).substring(0, 2)
					+ File.separatorChar
					+ LOVE_UPLOAD
					+ File.separatorChar + LOVE_MUSIC;
			// 上传其他
		} else {
			return "";
		}
	}
   /**
    * 处理字符串
    * @param str
    * @return
    */
	public static String buildNewStr(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		return str.substring(str.indexOf(LOVE_COMMA) + 1)+LOVE_COMMA;
	}
	/**
	 * 创建图像URL
	 * @return
	 */
	public static String buildImageUrl() {
		return DateUtil.formatDateSecond(new Date())
				+ UUID.randomUUID().toString().substring(0, 6);

	}
	
	/**
	 * 构造短Id
	 * @return
	 */
	public static String buidId(){
		return DateUtil.formatDateSecond(new Date());
	}
	
	/**
	 * 长ID
	 * @return
	 */
	public static String buidLongId(){
		return buidId()+UUID.randomUUID().toString().substring(0, 6);
	}
	
	
	
	/**
	 * 构建array 字符串
	 * @param navIdArray
	 * @return
	 */
	public static String buildSqlStr(String [] navIdArray){
		StringBuffer sb = new StringBuffer("(");
		
		for (String str : navIdArray) {
			sb.append(",'"+str+"'");
		}
		sb.append(")");
		return sb.toString().replaceFirst(",","");
	}
	
	/**
	 * 构建str 通过maplist
	 * @param mapList
	 * @param key
	 * @return
	 */
	public static String buildSqlStr(List<Map<String, Object>> mapList,String key){
		StringBuffer sb = new StringBuffer("(");
		for (Map<String, Object> map : mapList) {
			sb.append(",'"+map.get(key)+"'");
		}
		sb.append(")");
		return sb.toString().replaceFirst(",","");
	}
    /**
     * 构建str 通过maplist
     * @param mapList
     * @param key
     * @return
     */
	public static String buildSqlStr1(List<Map<String, Object>> mapList,String key){
		StringBuffer sb = new StringBuffer("");
		for (Map<String, Object> map : mapList) {
			sb.append(map.get(key));
		}
		String str= "";
		if(sb!=null){
			str = sb.toString();
			if(StringUtils.isNotBlank(str)){
				return str.indexOf(",") > 0 ? str.substring(0,str.lastIndexOf(",")) : str ;
			}
		}
		return  null;
	}
	
	/**
	 * 创建空的listMap
	 * @return
	 */
	public static List<Map<String, Object>> buildEmptyListMap(){
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		return listMap;
	}
	
	
	
	public static void main(String[] args) {
		List<Map<String, Object>> aa = new ArrayList<Map<String, Object>>();
		Map<String, Object> bb = new HashMap<String, Object>();
		bb.put("navid", "201181212121");
	   aa.add(bb);
		
		System.out.println(buildSqlStr1(aa,"navid"));
	}

}
