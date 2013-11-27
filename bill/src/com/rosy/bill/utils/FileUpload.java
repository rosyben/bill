package com.rosy.bill.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.rosy.bill.entity.system.Appendix;

public class FileUpload {
	public static Date getStringDateShort(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}

	// public static void upload(HttpServletRequest request,HttpServletResponse
	// response,AppAppendix appAppendix) {
	//
	// final long MAX_SIZE = 3 * 1024 * 1024;// 设置上传文件最大为 3M
	//
	// // 允许上传的文件格式的列表
	// final String[] allowedExt = new String[] { "jpg", "jpeg", "gif",
	// "txt","doc", "docx", "mp3", "wma", "m4a" };
	// response.setContentType("text/html");
	// // 设置字符编码为UTF-8, 这样支持汉字显示
	// response.setCharacterEncoding("UTF-8");
	//
	// // 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
	// DiskFileItemFactory dfif = new DiskFileItemFactory();
	// dfif.setSizeThreshold(4096);// 设置上传文件时用于临时存放文件的内存大小,这里是4K.多于的部分将临时存在硬盘
	// dfif.setRepository(new File(request.getRealPath("/") +
	// "ImagesUploadTemp"));// 设置存放临时文件的目录,web根目录下的ImagesUploadTemp目录
	//
	// // 用以上工厂实例化上传组件
	// ServletFileUpload sfu = new ServletFileUpload(dfif);
	// // 设置最大上传尺寸
	// sfu.setSizeMax(MAX_SIZE);
	//
	// PrintWriter out = null;
	// try {
	// out = response.getWriter();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// // 从request得到 所有 上传域的列表
	// List fileList = null;
	// try {
	// fileList = sfu.parseRequest(request);
	// } catch (FileUploadException e) {// 处理文件尺寸过大异常
	// if (e instanceof SizeLimitExceededException) {
	// out.println("文件尺寸超过规定大小:" + MAX_SIZE + "字节<p />");
	// out.println("<a href=\"upload.html\" target=\"_top\">返回</a>");
	// return;
	// }
	// e.printStackTrace();
	// }
	// // 没有文件上传
	// if (fileList == null || fileList.size() == 0) {
	// out.println("请选择上传文件<p />");
	// out.println("<a href=\"upload.html\" target=\"_top\">返回</a>");
	// return;
	// }
	// // 得到所有上传的文件
	// Iterator fileItr = fileList.iterator();
	// int i = 0;
	// // 循环处理所有文件
	// while (fileItr.hasNext()) {
	// FileItem fileItem = null;
	// String path = null;
	// long size = 0;
	// // 得到当前文件
	// fileItem = (FileItem) fileItr.next();
	// i++;
	// // 忽略简单form字段而不是上传域的文件域(<input type="text" />等)
	// if (fileItem == null || fileItem.isFormField()) {
	// continue;
	// }
	// // 得到文件的完整路径
	// path = fileItem.getName();
	// // 得到文件的大小
	// size = fileItem.getSize();
	// if ("".equals(path) || size == 0) {
	// out.println("请选择上传文件<p />");
	// out.println("<a href=\"upload.html\" target=\"_top\">返回</a>");
	// return;
	// }
	//
	// // 得到去除路径的文件名
	// String t_name = path.substring(path.lastIndexOf("\\") + 1);
	// // 得到文件的扩展名(无扩展名时将得到全名)
	// String t_ext = t_name.substring(t_name.lastIndexOf(".") + 1);
	//
	// appAppendix.setAppendixType(t_ext);
	//
	// // 拒绝接受规定文件格式之外的文件类型
	// int allowFlag = 0;
	// int allowedExtCount = allowedExt.length;
	// for (; allowFlag < allowedExtCount; allowFlag++) {
	// if (allowedExt[allowFlag].equals(t_ext))
	// break;
	// }
	// if (allowFlag == allowedExtCount) {
	// out.println("请上传以下类型的文件<p />");
	// for (allowFlag = 0; allowFlag < allowedExtCount; allowFlag++)
	// out.println("*." + allowedExt[allowFlag]
	// + "&nbsp;&nbsp;&nbsp;");
	// out.println("<p /><a href=\"upload.html\" target=\"_top\">返回</a>");
	// return;
	// }
	//
	// long now = System.currentTimeMillis();
	// appAppendix.setUploadDate(FileUpload.getStringDateShort(""+now));
	// // 根据系统时间生成上传后保存的文件名
	// String prefix = String.valueOf(now);
	// // 保存的最终文件完整路径,保存在web根目录下的ImagesUploaded目录下
	// String u_name = request.getRealPath("/") + "ImagesUploaded/"
	// + prefix + "." + t_ext;
	// appAppendix.setAppendixUrl(u_name);
	// try {
	// // 保存文件
	// File f=new File(u_name);
	// if(!f.exists()){//文件是否存在
	// f.mkdir();//创建新文件
	// }
	// fileItem.write(new File(u_name));
	// out.println("文件上传成功. 已保存为: " + prefix + "." + t_ext
	// + " &nbsp;&nbsp;文件大小: " + size + "字节<p />");
	// out.println("<a href=\"upload.html\" target=\"_top\">继续上传</a>");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// }
	public static void upload(File ifile, HttpServletRequest request,Appendix appendix) {

		final int MAX_SIZE = 3 * 1024 * 1024;// 设置上传文件最大为 3M

		// 允许上传的文件格式的列表
		final String[] allowedExt = new String[] { "jpg", "jpeg", "gif", "txt","doc", "docx", "mp3", "wma", "m4a" };

		String path = null;

		// 得到文件的完整路径
		path = ifile.getName();

		// 得到去除路径的文件名
		String t_name = path.substring(path.lastIndexOf("\\") + 1);
		// 得到文件的扩展名(无扩展名时将得到全名)
		String t_ext = t_name.substring(t_name.lastIndexOf(".") + 1);

		appendix.setAppendixType(t_ext);

		// 拒绝接受规定文件格式之外的文件类型
//		int allowFlag = 0;
//		int allowedExtCount = allowedExt.length;
//		for (; allowFlag < allowedExtCount; allowFlag++) {
//			if (allowedExt[allowFlag].equals(t_ext))
//				break;
//		}
//		if (allowFlag == allowedExtCount) {
//			System.out.println("拒绝接受规定文件格式之外的文件类型");
//			return;
//		}

		long now = System.currentTimeMillis();

		// 根据系统时间生成上传后保存的文件名
		String prefix = String.valueOf(now);
		appendix.setUploadTime(new Timestamp(System.currentTimeMillis()));

		// 保存的最终文件完整路径,保存在web根目录下的ImagesUploaded目录下
		String u_name = request.getRealPath("/") + "ImagesUploaded/" + prefix
				+ "." + t_ext;

		//appendix.setAppendixUrl(u_name);
		
		File  ofile = new File(u_name);
		if(!ofile .exists()){//文件是否存在
			ofile .mkdir();//创建新文件
		}
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(ifile);
			fileOutputStream = new FileOutputStream(ofile );
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(fileInputStream, MAX_SIZE);
			out = new BufferedOutputStream(fileOutputStream,MAX_SIZE);
			byte[] buffer = new byte[MAX_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				fileInputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
