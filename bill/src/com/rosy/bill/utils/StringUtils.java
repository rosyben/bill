package com.rosy.bill.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.UUIDHexGenerator;

/**
 * String Utility Class This is used to encode passwords programmatically
 * 
 * <p>
 * <a h ref="StringUtil.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class StringUtils {
	// ~ Static fields/initializers
	// =============================================

	private final static Log log = LogFactory.getLog(StringUtils.class);

	// ~ Methods
	// ================================================================

	/**
	 * Encode a string using algorithm specified in web.xml and return the
	 * resulting encrypted password. If exception, the plain credentials string
	 * is returned
	 * 
	 * @param password
	 *            Password or other credentials to use in authenticating this
	 *            username
	 * @param algorithm
	 *            Algorithm used to do the digest
	 * 
	 * @return encypted password based on the algorithm.
	 */
	public static String encodePassword(String password, String algorithm) {
		byte[] unencodedPassword = password.getBytes();

		MessageDigest md = null;

		try {
			// first create an instance, given the provider
			md = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			log.error("Exception: " + e);

			return password;
		}

		md.reset();

		// call the update method one or more times
		// (useful when you don't know the size of your data, eg. stream)
		md.update(unencodedPassword);

		// now calculate the hash
		byte[] encodedPassword = md.digest();

		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10) {
				buf.append("0");
			}

			buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}

		return buf.toString();
	}

	/**
	 * Encode a string using Base64 encoding. Used when storing passwords as
	 * cookies.
	 * 
	 * This is weak encoding in that anyone can use the decodeString routine to
	 * reverse the encoding.
	 * 
	 * @param str
	 * @return String
	 */
	public static String encodeString(String str) {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return encoder.encodeBuffer(str.getBytes()).trim();
	}

	/**
	 * Decode a string using Base64 encoding.
	 * 
	 * @param str
	 * @return String
	 */
	public static String decodeString(String str) {
		sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
		try {
			return new String(dec.decodeBuffer(str));
		} catch (IOException io) {
			throw new RuntimeException(io.getMessage(), io.getCause());
		}
	}

	/**
	 * 判断字符串是否有中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean hasChinese(String str) {
		if (str == null) {
			return false;
		}
		if (str.getBytes().length != str.length()) {
			return true;
		}
		return false;

	}
    /**
     * 字符串分割 默认按照";" 分割
     * @param selItem
     * @return
     */
    public static String [] getItemsForSplit (String selItem){
    	return getItemsForSplit(selItem,";");
    }
    
    /**
     * 字符串分割 
     * @param selItem
     * @return
     */
    public static String [] getItemsForSplit (String selItem,String split){
  	   if(selItem == null){
  		   return new String[0];
  	   }
  	    return selItem.split(split); 	  	  
    }
   
    /**
     * 格式化数字，若为 null 返回 ""，否则返回其数值
     * @author 谢庚才
     * @param number
     * @return
     */
    public static String formatNumber(Number number) {
    	if (number!=null) {
			return number+"";
		} else {
			return "";
		}
    }
    
    

    /**
     * 格式化桩号 将Double类型的桩号 转化为 形如K999+333类型的桩号写法
     * 犹如0.0转化为 K0+0
     * 犹如333转化为 K333+0
     * 犹如3.33 转化成3K330米
     * @param pegNum
     * @return
     */
    public static String formatPegNum(Number pegNum){
    	if(pegNum ==null) {
    		return "";
    	}
    	
    	Double doubleValue =new Double(pegNum.doubleValue());
    	doubleValue  = doubleValue*1000;
    	
    	Double kilo  = (doubleValue/1000);
    	int kiloPart =kilo.intValue();
    	Double meterPart = doubleValue - kiloPart*1000;
    	return "K"+ kiloPart +"+"+ meterPart.intValue();


    }
    
    /**
     * 格式化桩号 将Double类型的桩号 转化为 形如K999+333类型的桩号写法
     * 犹如0.0转化为 K0+0
     * 犹如333转化为 K333+0
     * @param pegNum
     * @return
     */
    public static String formatPegNum(String pegNum){
    	if(pegNum ==null) {
    		return "";
    	} 
    	return formatPegNum(Double.parseDouble(pegNum));
    }
    
    /**
     * 获得uuid
     * @return
     */
    public static String genUUID(){
		Properties props = new Properties();
		props.setProperty("separator", "");
		IdentifierGenerator gen = new UUIDHexGenerator();
		( (Configurable) gen ).configure(Hibernate.STRING, props, null);
			return (String) gen.generate(null, null);
		
	}
    
    public static void main(String[] args) {
      System.out.println(formatPegNum(52.922));

	}
}
