package com.feinno.commonlib.tools;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTools 
{

	/**
	 * 获取当前时间(年-月-日 时:分)
	 */
	public static String getTimeString () {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return df.format(date) ;
	}
	/**
	 * 获取当前时间(年-月-日 时:分:秒)
	 */
	public static String getTimeString2 () {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date) ;
	}
	/**
	 * 获取当前时间(年-月-日 时:分:秒)
	 */
	public static String getTimeString (long time) {
		Date date = new Date(time);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date) ;
	}
	/**
	 * 由时间的字符串(yyyy-MM-dd HH:mm:ss)获取时间的毫秒值
	 * @param timeStr
	 * @return
	 */
	public static long getTimeFromStr(String timeStr){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = df.parse(timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long time = 0;
		if(date != null) {
			time = date.getTime();
		}
		return time;
	}

	/**
	 * 获取当前时间(年-月-日 时:分:秒)
	 * @param time 时间毫秒值
	 * @param pattern 想获取的时间格式,默认为"yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static String getTimeString (long time, String pattern) {
		Date date = new Date(time);
		if(TextUtils.isEmpty(pattern)){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(date) ;
	}

	/**
	 * 由时间的字符串获取时间的毫秒值
	 * @param timeStr 时间串
	 * @param pattern 时间串的格式,默认为"yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static long getTimeFromStr(String timeStr, String pattern){
		if(TextUtils.isEmpty(pattern)){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = df.parse(timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long time = 0;
		if(date != null) {
			time = date.getTime();
		}
		return time;
	}

	/**
	 * 获取当前时间(年月日时分秒毫秒)
	 */
	public static String getTimeOfMsec () {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
		return df.format(date) ;
	}


	/**
	 * 由时间值(小时/分钟),返回"mm:ss"的格式
	 * @param hour 小时
	 * @param minute 分钟
	 */
	public static String setTimeFormat(int hour, int minute) {
		String timeShowStr;
		if(minute<=9){
			if(hour<=9){
				timeShowStr = "0"+hour+":0"+minute;
			}else{
				timeShowStr = ""+hour+":0"+minute;
			}
		}else{
			if(hour<=9){
				timeShowStr = "0"+hour+":"+minute;
			}else{
				timeShowStr = ""+hour+":"+minute;
			}
		}
		return timeShowStr;
	}
	/**
	 * 由时间值(月/日),返回"MM月dd日"的格式
	 * @param month
	 * @param day
	 */
	public static String setDateFormat(int month, int day) {
		String timeShowStr;
		if(day<=9){
			if(month<=9){
				timeShowStr = "0"+month+"月0"+day+"日";
			}else{
				timeShowStr = ""+month+"月0"+day+"日";
			}
		}else{
			if(month<=9){
				timeShowStr = "0"+month+"月"+day+"日";
			}else{
				timeShowStr = ""+month+"月"+day+"日";
			}
		}
		return timeShowStr;
	}
	/**
	 * 获取当天是星期几
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 */
	public static String getWeekdayStr(int year, int month, int day) {
		Calendar calendar = new GregorianCalendar(year, month-1, day);
		String strWeek = "";
		int dw = calendar.get(Calendar.DAY_OF_WEEK);
		switch (dw) {
			case 1:
				strWeek = "周日";
				break;
			case 2:
				strWeek = "周一";
				break;
			case 3:
				strWeek = "周二";
				break;
			case 4:
				strWeek = "周三";
				break;
			case 5:
				strWeek = "周四";
				break;
			case 6:
				strWeek = "周五";
				break;
			case 7:
				strWeek = "周六";
				break;
			default:
				break;
		}
		return strWeek;
	}
	
	/**
	 * 解析时间 yyyy-MM-dd HH:mm:ss TO long
	 * 
	 * @param dataStr
	 *            （yyyy-MM-dd HH:mm:ss）
	 * @return
	 */
	public static long parserData(String dataStr) {
		try {
			if (TextUtils.isEmpty(dataStr))
				return 0;
			if (dataStr.contains("-") && dataStr.contains(":")) {
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				return dateFormat.parse(dataStr).getTime();
			} else
				return 0;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}



	/**
	 * 转换时间为yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param milliseconds
	 *            时间
	 * @return String
	 */
	public static String formartData(long milliseconds) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = new Date(milliseconds);
		String dataString = dateFormat.format(date);
		return dataString;
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式对应long类型的时间转换为yyyy-MM-dd格式对应long类型的时间
	 * 
	 * @param timeMillis
	 * @return
	 * @throws ParseException
	 */
	private static long parserDataToYMD(long timeMillis) throws ParseException {
		// 将当前时间转换为yyyy-MM-dd HH:mm:ss格式
		String formartData = formartData(timeMillis);
		// 再将时间转换为yyyy-MM-dd的long类型
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.parse(formartData).getTime();
	}

	
	public static Boolean isToday(String passTime) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String passDay="";
		try {
			passDay = myFormatter.format(myFormatter.parse(passTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String thisDay = myFormatter.format(new Date());
		
		return thisDay.equals(passDay);
	}

	
	/**
	 * 最近会话时间格式
	 * 今天： hh:mm
	 * 昨天： 昨天 
	 * 这个星期：星期x 
	 * 今年： mm/dd
	 * 以前 ：yy/mm/dd
	 * @param rtdate
	 * @return
	 */
	public  static String getFormatDate(String rtdate)
	{
		long oneDayMillis=24*60*60*1000;
		String result="";
		long oneYearDiff=365*oneDayMillis;
		try
		{
			long weeHours = parserDataToYMD(System.currentTimeMillis());
			long compareDate=DateTools.parserData(rtdate);
			//传入日期为今天凌晨之前。
			if (weeHours>compareDate)
			{
				if ((weeHours-compareDate)>=oneYearDiff)
				{
					result=rtdate.substring(0,11);
					String year=result.substring(2, 4);
					String month=result.substring(5, 6);
					//10月之前
					if (month.equals("0"))
					{
						month=result.substring(6, 7);
					}
					else
					{
						month=result.substring(5, 7);
					}
					
					//10日之前
					String dd=result.substring(8, 9);
					
					if (dd.equals("0"))
					{
						dd=result.substring(9,10);
					}
					else
					{
						dd=result.substring(8, 10);
					}
					
					result=year+"/"+month+"/"+dd;
					
				}
				else
				{
				     String ret = "";
				     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				     long passtime = sdf.parse(rtdate).getTime();
				            
				     Calendar now = Calendar.getInstance();
				     long ms  = 1000*(now.get(Calendar.HOUR_OF_DAY)*3600+now.get(Calendar.MINUTE)*60+now.get(Calendar.SECOND));//毫秒数
				     long ms_now = now.getTimeInMillis();
				     if(ms_now-passtime <ms+24*3600*1000*6){
				           if(ms_now-passtime<ms){
					            result = rtdate.substring(11,rtdate.length() - 3);
					       }else if(ms_now-passtime<(ms+24*3600*1000)){
					            	// 昨天
								result = "昨天";
					       }else{
									//这个星期
								result = getWeekOfDate(passtime);
							}
				      }else{
				            	result=rtdate.substring(5,10);
								String month=result.substring(0, 1);
								//10月之前
								if (month.equals("0"))
								{
									month=result.substring(1, 2);
								}
								else
								{
									month=result.substring(0, 2);
								}
								
								//10日之前
								String dd=result.substring(3, 4);
								
								if (dd.equals("0"))
								{
									dd=result.substring(4, 5);
								}
								else
								{
									dd=result.substring(3, 5);
								}
								
								result=month+"/"+dd;
				            }
				  
				}
			}
			else
			{
				//今天日期
				result=rtdate.substring(11,16);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result=rtdate;
		}
		
		return result;
	}

	/**
	 * 聊天界面和短信界面时间格式
	 * 今天： hh:mm
	 * 昨天： 昨天 hh:mm
	 * 这个星期：星期x hh:mm
	 * 今年： mm/dd hh:mm
	 * 以前 ：yy/mm/dd hh:mm
	 * @param rtdate
	 * @return
	 */
	public  static String getFormatDateForSession(String rtdate)
	{
		long oneDayMillis=24*60*60*1000;
		String result="";
		long oneYearDiff=365*oneDayMillis;
		try
		{
			long weeHours = parserDataToYMD(System.currentTimeMillis());
			long compareDate=DateTools.parserData(rtdate);
			//传入日期为今天凌晨之前。
			if (weeHours>compareDate)
			{
				if ((weeHours-compareDate)>=oneYearDiff)
				{
					result=rtdate.substring(0,11);
					String year=result.substring(2, 4);
					String month=result.substring(5, 6);
					//10月之前
					if (month.equals("0"))
					{
						month=result.substring(6, 7);
					}
					else
					{
						month=result.substring(5, 7);
					}

					//10日之前
					String dd=result.substring(8, 9);

					if (dd.equals("0"))
					{
						dd=result.substring(9,10);
					}
					else
					{
						dd=result.substring(8, 10);
					}

					result=year+"/"+month+"/"+dd +" "+rtdate.substring(11,16);

				}
				else
				{
					String ret = "";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					long passtime = sdf.parse(rtdate).getTime();

					Calendar now = Calendar.getInstance();
					long ms  = 1000*(now.get(Calendar.HOUR_OF_DAY)*3600+now.get(Calendar.MINUTE)*60+now.get(Calendar.SECOND));//毫秒数
					long ms_now = now.getTimeInMillis();
					if(ms_now-passtime <ms+24*3600*1000*6){
						if(ms_now-passtime<ms){
							result = rtdate.substring(11,rtdate.length() - 3);
						}else if(ms_now-passtime<(ms+24*3600*1000)){
							// 昨天
							result = "昨天 "+rtdate.substring(11,16);
						}else{
							//这个星期
							result = getWeekOfDate(passtime)+" "+rtdate.substring(11,16);
						}
					}else{
						result=rtdate.substring(5,10);
						String month=result.substring(0, 1);
						//10月之前
						if (month.equals("0"))
						{
							month=result.substring(1, 2);
						}
						else
						{
							month=result.substring(0, 2);
						}

						//10日之前
						String dd=result.substring(3, 4);

						if (dd.equals("0"))
						{
							dd=result.substring(4, 5);
						}
						else
						{
							dd=result.substring(3, 5);
						}

						result=month+"/"+dd +" "+ rtdate.substring(11,16);
					}

				}
			}
			else
			{
				//今天日期
				result=rtdate.substring(11,16);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result=rtdate;
		}

		return result;
	}
	
	/**
	 * 根据当前时间判断星期几
	 * @param
	 * @return
	 */
	public static String getWeekOfDate(long time) {

		Date date = new Date(time);
		String[] weekDays = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;

		return weekDays[w];
	}
	
	
	/**
	 * yy/mm/dd hh:ss
	 * @param
	 * @return
	 */
	public static String FormatDate(String rtdate) {
		String result ="";
		result=rtdate.substring(0,11);
		String year=result.substring(2, 4);
		String month=result.substring(5, 6);
		//10月之前
		if (month.equals("0"))
		{
			month=result.substring(6, 7);
		}
		else
		{
			month=result.substring(5, 7);
		}
		
		//10日之前
		String dd=result.substring(8, 9);
		
		if (dd.equals("0"))
		{
			dd=result.substring(9,10);
		}
		else
		{
			dd=result.substring(8, 10);
		}
		
		result=year+"/"+month+"/"+dd+" "+rtdate.substring(11,16);
		
		return result;
	}

	/**
	 * 获取当前时间(11年11月11日)
	 */
	public static String getDateString (long time) {
		long oneDayMillis=24*60*60*1000;
		long oneYearDiff=365*oneDayMillis;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String result="";
		String year = "";
		String month = "";
		String day = "";
		try {

			long nowTime = System.currentTimeMillis();
			if (nowTime>time) {

				Date date = new Date(time);
				String str =  df.format(date) ;
				month = str.substring(5,7);
				day = str.substring(8,10);
				if ((nowTime - time) >= oneYearDiff) {
					year = str.substring(0,4);
					result = year+"年"+month+"月"+day+"日";
				}else{
					result = month+"月"+day+"日";
				}
			}else{

				Date date = new Date(System.currentTimeMillis());
				String str =  df.format(date) ;
				month = str.substring(5,7);
				day = str.substring(8,10);
				result = month+"月"+day+"日";
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
}
