package com.rosy.bill.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;

import com.rosy.bill.Constants;


/**
 * Date Utility Class
 * This is used to convert Strings to Dates and Timestamps
 *
 * <p>
 * <a href="DateUtil.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a> 
 *   to correct time pattern. Minutes should be mm not MM
 * 	(MM is month). 
 * @version $Revision: 1.1 $ $Date: 2011/03/30 07:22:47 $
 */
public class DateUtils {
    //~ Static fields/initializers =============================================

    private static Log log = LogFactory.getLog(DateUtils.class);
    private static String defaultDatePattern = "yyyy年MM月dd日";
    private static String timePattern = "HH:mm";
    private static String yearPattern = "yyyy年";
    private static String monthPattern = "yyyy年MM月";
    //~ Methods ================================================================

    /**
	 * date:2010.03.01 author:jw
	 * 日期加天数返回日期
	 */
	 public static Date addDate(Date d,long day) throws ParseException { 

		  long time = d.getTime(); 
		  day = day*24*60*60*1000; 
		  time+=day; 
		  return new Date(time); 

		  } 
    /**
     * date:12.27 author:jw
     * 把日期统一换成yyyy年MM月dd日
     * @param date
     * @return date
     */
    public static Date convertDateToDefaultDate(Date date){
    	if(date==null){
    		return convertStringToMoreDate(convertDateToMonthString(date));
    	}else 
    		return date;
    }
    //1026 jw
    /**
     * 获得日期的月份
     */
    public static int getMonthNum(Date date){
		   	 if(date == null) {
				 return 0;
			 }
    	Calendar c = Calendar.getInstance();
	       c.setTime(date);
    	return c.get(Calendar.MONTH)+1;
    }
    /**
     * 获得日期的年份
     * @param date
     * @return
     */
    public static int getYearNum(Date date){
    	 if(date == null) {
    		 return 1900;
    	 }
    	Calendar c = Calendar.getInstance();
	       c.setTime(date);
    	return c.get(Calendar.YEAR);
    }
    /**
     * 获得两个日期间的月份列表（带年份）
     * @param sBegin
     * @param sEnd 
     * @return list
     */
    public static List getMonths(Date sBegin,Date sEnd){
    	List list = new ArrayList();
    	if(sBegin!=null&&sEnd!=null){
	       String sCurrent="";   
	       Calendar calStart=Calendar.getInstance();   
	       calStart.setTime(sBegin);
	       Calendar calEnd=Calendar.getInstance();   
	       calEnd.setTime(sEnd);
	       Calendar calTmp=(Calendar)calStart.clone();
	       calTmp.add(Calendar.MONTH,-1);
	       int iLoop=1;   
	       while(!(calEnd.get(Calendar.YEAR)==calTmp.get(Calendar.YEAR)&&calEnd.get(Calendar.MONTH)==calTmp.get(Calendar.MONTH)))   
	       {   
	               calTmp.add(Calendar.MONTH,iLoop);   
	               SimpleDateFormat df = new SimpleDateFormat(monthPattern);
	               sCurrent=df.format(calTmp.getTime()); 
	               list.add(sCurrent);        
	       }
    	}
    	return list;
    }
    /**
     * 获得月份加减后的字符串
     * @param date
     * @param num(包括+,-)
     * @param pattern
     * @return
     */
    public static String getMonthSubString(Date date,int num){
    	if(date==null){
    		return null;
    	}
    	Calendar cal=Calendar.getInstance();   
    	cal.setTime(date);
    	cal.add(Calendar.MONTH,num);
    	SimpleDateFormat df = new SimpleDateFormat(monthPattern);
    	return df.format(cal.getTime()); 
    }
    
    /**
     * 获得日期加减 
     * @param date
     * @param num(包括+,-)
     * @param pattern
     * @return
     */
    public static Date getDayUpOrDown(Date date,int num){
    	if(date==null){
    		return null;
    	}
    	Calendar cal=Calendar.getInstance();   
    	cal.setTime(date);
    	cal.add(Calendar.DATE,num);
    	return cal.getTime();
    }
    /**
	 * 获得日期加减
	 * @param day_i
	 * @return
	 */
	public static final String getBefDateString(int day_i){
		Calendar day=Calendar.getInstance();
		day.add(Calendar.DATE,day_i);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(day.getTime());
		
		}
	public static final Date getSimpleDate(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return convertStringToStrigulaDate(sdf.format(date));
	}
	
    /**
     * 获得同年的两个月份之间的月份数
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthSubNum(Date date1,Date date2){
    	Calendar c1 = Calendar.getInstance();
	       c1.setTime(date1);
	    Calendar c2 = Calendar.getInstance();
	       c2.setTime(date2);   
	    return (c2.get(1)-c1.get(1))*12+(c2.get(2)-c1.get(2));
    }
    
    /**
     * Return default datePattern (yyyy年MM月dd日)
     * @return a string representing the date pattern on the UI
     */
    public static String getDatePattern() {
        Locale locale = LocaleContextHolder.getLocale();
        try {
            defaultDatePattern = ResourceBundle.getBundle(Constants.BUNDLE_KEY, locale)
                .getString("date.format");
        } catch (MissingResourceException mse) {
            defaultDatePattern = "yyyy年MM月dd日";
        }
        
        return defaultDatePattern;
    }
    
    public static String getDateTimePattern() {
        return DateUtils.getDatePattern() + " HH时mm分";
    }

    /**
     * This method attempts to convert an Oracle-formatted date
     * in the form dd-MMM-yyyy to mm/dd/yyyy.
     *
     * @param aDate date from database as a string
     * @return formatted string for the ui
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate)
      throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '"
                      + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method returns the current date time in the format:
     * MM/dd/yyyy HH:MM a
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(timePattern, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     * 
     * @return the current date
     * @throws ParseException
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * 
     * @see java.text.SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
        	
           // log.error("aDate is null!");
            return "";
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based
     * on the System Property 'dateFormat'
     * in the format you specify on input
     * 
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * This method converts a String to a date using the datePattern
     * 
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * 
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate)
      throws ParseException {
        Date aDate = null;

        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }

            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate
                      + "' to a date, throwing exception");
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(),
                                     pe.getErrorOffset());
                    
        }

        return aDate;
    }
    
    public static String getTimePattern() {
  	  Locale locale = LocaleContextHolder.getLocale();
  	  try {
  		  return ResourceBundle.getBundle(Constants.BUNDLE_KEY, locale).getString("datetime.format");
		} catch (Exception e) {
			return "yyyy年MM月dd日 HH时mm分";

		}
   }
    
    public static String getNowPattern() {
    	  Locale locale = LocaleContextHolder.getLocale();
    	  try {
    		  return ResourceBundle.getBundle(Constants.BUNDLE_KEY, locale).getString("datetime.format");
  		} catch (Exception e) {
  			//return "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒"; //dd/MM/yyyy hh:mm:ss.SSS
  			return "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";
  			//return "yyyy年MM月dd日 HH时mm分ss秒";

  		}
     }
    
    /**
     * 
     * yyyy年MM月dd日 HH时mm分";
     * @param strDate the date to convert  yyyy年MM月dd日 HH时mm分";
     * @return a date object
     * 
     * @throws ParseException
     */
    public static Date convertStringToDatetime(String strDate)
      throws ParseException {
        Date aDate = null;

        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getTimePattern());
            }

            aDate = convertStringToDate(getTimePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate
                      + "' to a date, throwing exception");
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(),
                                     pe.getErrorOffset());
                    
        }

        return aDate;
    }
    

    /**
     * 
     * yyyy年MM月dd日 HH时mm分";
     * @param strDate the date to convert  yyyy年MM月dd日 HH时mm分";
     * @return a date object
     * 
     * @throws ParseException
     */
    public static String convertDatetimeToString(Date dateTime)
      throws ParseException {
        String adateTime = null;  
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getTimePattern());
            }

            adateTime = getDateTime(getTimePattern(), dateTime);

        return adateTime;
    }
    
    public static String convertNowToString(Date dateTime) {
        String adateTime = null;  
        if (log.isDebugEnabled()) {
            log.debug("converting date with pattern: " + getNowPattern());
        }
        try {
        	adateTime = getDateTime(getNowPattern(), dateTime);

        } catch (Exception e) {
        	
        }
        return adateTime;
    }
    
    /**
     * 获得当前系统时间
     * @return
     * @throws ParseException
     */
    public static Date getCurrentDate() {
    	 return new Date(System.currentTimeMillis());
    	
    }
    /**
     * 获得当前年份
     * @return
     * 
     * 631wj
     * int
     */
    public static int getCurrentYear(){
    	Date date = getCurrentDate();
    	Calendar cal =Calendar.getInstance(); 
    	cal.setTime(date);
    	return cal.get(Calendar.YEAR);	
    }
    
    /**
     * 时间的年份
     * @return
     * 
     * 631wj
     * int
     */
    public static int getYearofDate(Date date){
    	 if(date == null) {
    	  return 0;
    		 }
    	Calendar cal =Calendar.getInstance(); 
    	cal.setTime(date);
    	return cal.get(Calendar.YEAR);	
    }
    /**
     * 获得当前系统时间
     * @return
     * @throws ParseException
     */
    public static String getCurrentStrDate() {
    	 return convertDateToString(new Date(System.currentTimeMillis()));
    	
    }
    
    /**
     * 获得当前系统时间
     * @return
     * @throws ParseException
     */
    public static String getCurrentMonthStrDate() {
    	 return convertDateToMonthString(new Date(System.currentTimeMillis()));
    	
    }
    /**
     * 将 yyyy、yyyyMM、yyyyMMdd 格式的字符串转换为日期
     * @param str
     * @return
     */
    public static Date toDate(String str) {
    	Date date = null;
    	if (!StringUtils.isEmpty(str)) {
			try {
				if (str.length() == 8) {
					date = DateUtils.convertStringToDate("yyyyMMdd",
							str.substring(0, 8));
				} else if (str.length() == 6) {
					date = DateUtils.convertStringToDate("yyyyMM",
							str.substring(0, 6));
				} else if (str.length() == 4) {
					date = DateUtils.convertStringToDate("yyyy",
							str.substring(0, 4));
				}
			} catch (ParseException e) {
				return date;
			}
    	}
    	return date;
    }
    /**
     * 将 yyyy.、yyyy.MM、yyyy.MM.dd 格式的字符串转换为日期
     * @param str
     * @return
     */
    public static Date toDotDate(String str) {
    	Date date = null;
    	if (!StringUtils.isEmpty(str)) {
			try {
				if (str.length() >= 10) {
					date = DateUtils.convertStringToDate("yyyy.MM.dd",
							str.substring(0, 10));
				} else if (str.length() == 7) {
					date = DateUtils.convertStringToDate("yyyy.MM",
							str.substring(0, 7));
				} else if (str.length() == 4) {
					date = DateUtils.convertStringToDate("yyyy",
							str.substring(0, 4));
				}
			} catch (ParseException e) {
				return date;
			}
    	}
    	return date;
    }
    /**
     * 将 yyyy、yyyy-MM、yyyy-MM-dd 格式的字符串转换为日期
     * @param str
     * @return
     */
    public static Date convertStringToStrigulaDate(String str) {
    	Date date = null;
    	if (!StringUtils.isEmpty(str)) {
			try {
				if (str.length() >= 10) {
					date = DateUtils.convertStringToDate("yyyy-MM-dd",
							str.substring(0, 10));
				} else if (str.length() == 7) {
					date = DateUtils.convertStringToDate("yyyy-MM",
							str.substring(0, 7));
				} else if (str.length() == 4) {
					date = DateUtils.convertStringToDate("yyyy",
							str.substring(0, 4));
				}
			} catch (ParseException e) {
				return date;
			}
    	}
    	return date;
    }   
    /**
     * 将 yyyy年、yyyy年MM月、yyyy年MM月dd日 格式的字符串转换为日期
     * @param str
     * @return
     */
    public static Date convertStringToMoreDate(String str) {
    	Date date = null;
    	if (!StringUtils.isEmpty(str)) {
			try {
				if (str.length() > 11) {
					date = DateUtils.convertStringToDatetime(str);
				}
				if (str.length() == 11) {
					date = DateUtils.convertStringToDate(getDatePattern(),
							str);
				} else if (str.length() == 8 ) {
					date = DateUtils.convertStringToDate(monthPattern,
							str);
				} else if (str.length() == 5) {
					date = DateUtils.convertStringToDate(yearPattern,
							str);
				}
			} catch (ParseException e) {
				return date;
			}
    	}
    	return date;
    }
//    /**
//     * 将日期格式转换为 yyyy年、yyyy年MM月、yyyy年MM月dd日 类型的字符串
//     * @param str
//     * @return
//     */
//    public static String convertDateToMoreStr(String ,Date sDate) {
//    	Calendar  calendar = Calendar.getInstance(); 
//    	calendar.setTime(sDate);
//    	calendar.get(Calendar.MONTH);
//    	calendar.get(Calendar.DATE);
//    	calendar.get(Calendar.)
//		return null;    
//    }
    
    /**
     * 转换成yyyy年 形,字符串
     */
    public static String convertDateToYearString(Date sDate){
    	return getDateTime(yearPattern,sDate);
    	
    }
    
    
    /**
     * 转换成yyyy年1月1日 代表这一年的开始 是年度数据
     * @throws ParseException 
     */
    public static Date getCurrentYearDate() {
    	try {
			return  convertStringToDate(yearPattern,
					convertDateToYearString(getCurrentDate()));
		} catch (ParseException e) {
			return null;
		}
    	
    }
    
    /**
     * 转换成yyyy年MM月 形,字符串
     */
    public static String convertDateToMonthString(Date sDate){
    	return getDateTime(monthPattern,sDate);
    	
    }
    /**
     * 转换成yyyy年 形,字符串
     */
    public static String convertDateToYearString(String  s){
    	String sDate = null;
    	if(s!=null&&s.length()>=5){
    		sDate = s.substring(0,5);
    	}
    	return sDate;
    	
    }
    /**
     * 转换成yyyy年MM月 形,字符串
     */
    public static String convertDateToMonthString(String  s){
    	String sDate = null;
    	if(s!=null&&s.length()>=8){
    		sDate = s.substring(0,8);
    	}
    	return sDate;
    	
    }
    
    
    //public static String getNowToString() {
   // 	return 
    //}
    
    public static void main(String[] args) {
    	Calendar  calendar = Calendar.getInstance(); 
    	   String date = "2012-02-12";
    	Date  newday = convertStringToStrigulaDate(date);
    	System.out.println("ddasfasdfa:"+getMonthSubNum(newday, new Date()));
    	
    	System.out.println(getDateTime("yyyy-mm-dd HH:mm:ss", new Date()));

	}
    		
}
