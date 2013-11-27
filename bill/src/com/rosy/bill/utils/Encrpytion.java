package com.rosy.bill.utils;
 
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/** 
 * 数据加密
 * @author qinqizhao
 * create-date 2010-12-07
 */
public class Encrpytion {
	
	private Encrpytion(){};
	private static Encrpytion _instance = new Encrpytion();
	public static Encrpytion getInstance(){
		return _instance;
	}
	
	private Key key;
	
	/**
	 * 根据参数生成KEY
	 * @param strKey
	 */
	private final void GeneratKey(String strKey){
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey.getBytes()));
			key = _generator.generateKey();
			_generator = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输入加密String明文
	 * 输出String密文
	 * @param mingwen
	 * @return
	 */
	private final String getEncString(String mingwen){
		String miwen = "";
		try {
			return byte2hex(getEncCode(mingwen.getBytes())); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return miwen;
	}

	/**
	 * 输入解密 以String密文
	 * 输出String明文 
	 * @param strMi
	 * @return
	 */
	private final String getDesString(String miwen) throws Exception{ 
		return new String(getDesCode(hex2byte(miwen.getBytes()))); 
	}

	/**
	 * 输入加密以byte[]明文
	 * 输出byte[]密文
	 * @param bytemingwen
	 * @return
	 */
	private final byte[] getEncCode(byte[] bytemingwen) throws Exception{
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(bytemingwen);
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 输入解密以byte[]密文
	 * 输出以byte[]明文	  
	 * @param bytemiwen
	 * @return
	 */
	private final byte[] getDesCode(byte[] bytemiwen) throws Exception{
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(bytemiwen); 
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 二行制转字符串
	 * @param b
	 * @return
	 */
	private final static String byte2hex(byte[] b){ // 一个字节的数，
		// 转成16进制字符串
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			// 整数转成十六进制表示
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1){
				hs = hs + "0" + stmp;
			}else{
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase(); // 转成大写
	}

	private final static byte[] hex2byte(byte[] b)throws Exception {
		if ((b.length % 2)!= 0)
			 throw new IllegalArgumentException("输入的值长度不是偶数"); 
		
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			// 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}
	
	/**
	 * @param key 	密钥
	 * @param data 	加密数据
	 * @return encrypt data 返回加密后的数据
	 */
	public final String Encrypt(String key, String data){
		this.GeneratKey(key);
		return this.getEncString(data);
	}
	
	/**
	 * @param key 	密钥
	 * @param data	解密数据
	 * @return decrypt data 返回解密后的数据
	 * @throws Exception 
	 */
	public final String Decrypt(String key, String data) throws Exception {
		try{
			this.GeneratKey(key);
			return this.getDesString(data);
		}catch(javax.crypto.BadPaddingException e ){
			return null;
		}catch(java.lang.IllegalArgumentException e ){
			return null;
		}
	}
}