package com.zjy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @brief DateUtils.java 日期类工具
 * @attention 使用注意事项
 * @author zhangjunyong
 * @date 2014年1月17日
 * @note begin modify by 修改人 修改时间  修改内容摘要说明
 */
public class DateUtils {
	/**
	 * 日期格式
	 */
	public static final String DateFormat = "yyyy-MM-dd";
	/**
	 * 时间格式(时分秒)
	 */
	public static final String DateTimeFormat = "yyyy-MM-dd hh:mm:ss";
	/**
	 * 
	 * \brief parseFromString 根据字符串日期转换为Date类型  
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 * @attention 方法的使用注意事项 
	 * @author zhangjunyong
	 * @date 2014年1月17日 
	 * @note  begin modify by 修改人 修改时间   修改内容摘要说明
	 */
	public static Date parseFromString(String date,String format) throws ParseException{
		if(date == null){
			return Calendar.getInstance().getTime();
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(date);
	}
	/**
	 * 
	 * \brief format根据传入的日期和格式得到格式化输出字符串
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 * @attention 方法的使用注意事项 
	 * @author zhangjunyong
	 * @date 2014年1月17日 
	 * @note  begin modify by 修改人 修改时间   修改内容摘要说明
	 */
	public static String format(Date date,String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
