/**
 * <p>Copyright @ 2009 深圳市金绎科技发展有限公司 </p>
 * <p>All right reserved. </p>
 * <p>项目名称					： 佛山市地方公路信息资源整合</p>
 * <p>JDK使用版本号				：jdk1.6.0_12 </P>
 * <p>描述						： 压缩 解压缩 支持zip压缩,解压缩,已经rar文件的解压缩文件的帮助类</p>
 * @version						： 1.0.0 
 * @author						： created by 631wj 
 * 
 * <p>修改历史 </p>
 * 		
 * <p>修改时间     						修改人员             修改内容 </p>
 * <p> 2009-04-18                    	631wj					 新建   </p>
 */
package com.rosy.bill.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;



public class ZipHelper {
private static final int BUFFEREDSIZE = 1024;
    private static ZipHelper zipHelper = new ZipHelper();
    
    private ZipHelper(){
    	
    }
	
    /**
     * 获得唯一的实例
     * @return
     */
    public synchronized static ZipHelper getZipHelper(){
		if (zipHelper == null) {
			zipHelper = new ZipHelper();
		}
		return zipHelper;
    }
    
    /**
     * 解压zip格式的压缩文件到指定位置
     * @param zipFileName 压缩文件
     * @param extPlace 解压目录
     * @throws Exception
     */
    public synchronized void unzip(String zipFileName, String extPlace) throws Exception {
        try {
            (new File(extPlace)).mkdirs();
            File f = new File(zipFileName);
            ZipFile zipFile = new ZipFile(zipFileName);
            if((!f.exists()) && (f.length() <= 0)) {
                throw new Exception("要解压的文件不存在!");
            }
            String strPath, gbkPath, strtemp;
            File tempFile = new File(extPlace);
            strPath = tempFile.getAbsolutePath();
            java.util.Enumeration e = zipFile.getEntries();
            while(e.hasMoreElements()){
                ZipEntry zipEnt = (ZipEntry) e.nextElement();
                gbkPath=zipEnt.getName();
                if(zipEnt.isDirectory()){
                    strtemp = strPath + File.separator + gbkPath;
                    File dir = new File(strtemp);
                    dir.mkdirs();
                    continue;
                } else {
                    //读写文件
                    InputStream is = zipFile.getInputStream(zipEnt);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    gbkPath=zipEnt.getName();
                    strtemp = strPath + File.separator + gbkPath;
                
                    //建目录
                    String strsubdir = gbkPath;
                    for(int i = 0; i < strsubdir.length(); i++) {
                        if(strsubdir.substring(i, i + 1).equalsIgnoreCase("/")) {
                            String temp = strPath + File.separator + strsubdir.substring(0, i);
                            File subdir = new File(temp);
                            if(!subdir.exists())
                            subdir.mkdir();
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(strtemp);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    int c;
                    while((c = bis.read()) != -1) {
                        bos.write((byte) c);
                    }
                    bos.close();
                    fos.close();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
   
    /**
     * 压缩zip格式的压缩文件
     * @param inputFilename 压缩的文件或文件夹及详细路径
     * @param zipFilename 输出文件名称及详细路径
     * @throws IOException
     */
    public synchronized void zip(String inputFilename, String zipFilename) throws IOException {
        zip(new File(inputFilename), zipFilename);
    }
    
    /**
     * 压缩zip格式的压缩文件
     * @param inputFile 需压缩文件
     * @param zipFilename 输出文件及详细路径
     * @throws IOException
     */
    public synchronized void zip(File inputFile, String zipFilename) throws IOException {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFilename));
        try {
            zip(inputFile, out, "");
        } catch (IOException e) {
            throw e;
        } finally {
        	out.setEncoding("GBK");
            out.close();
        }
    }
    
    /**
     * 压缩zip格式的压缩文件
     * @param inputFile 需压缩文件
     * @param out 输出压缩文件
     * @param base 结束标识
     * @throws IOException
     */
    private synchronized void zip(File inputFile, ZipOutputStream out, String base) throws IOException {
        if (inputFile.isDirectory()) {
            File[] inputFiles = inputFile.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < inputFiles.length; i++) {
                zip(inputFiles[i], out, base + inputFiles[i].getName());
            }
        } else {
            if (base.length() > 0) {
                out.putNextEntry(new ZipEntry(base));
            } else {
                out.putNextEntry(new ZipEntry(inputFile.getName()));
            }
            FileInputStream in = new FileInputStream(inputFile);
            try {
                int c;
                byte[] by = new byte[BUFFEREDSIZE];
                while ((c = in.read(by)) != -1) {
                    out.write(by, 0, c);
                }
            } catch (IOException e) {
                throw e;
            } finally {
                in.close();
                
            }
        }
    }
//    /**
//     * 解压rar格式的压缩文件到指定目录下
//     * @param rarFileName 压缩文件
//     * @param extPlace 解压目录
//     * @throws Exception
//     */
//    public synchronized void unrar(String rarFileName, String extPlace) throws Exception{
//		File f = new File(rarFileName);
//		Archive a=null;
//		try {
//			a = new Archive(f);
//		} catch (RarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(a!=null){
//			a.getMainHeader().print();
//			FileHeader fh = a.nextFileHeader();
//			while(fh!=null){	
//				try {
//					File out = new File(extPlace+fh.getFileNameString().trim());
//					 if(out.isDirectory()){
//						 out.mkdirs();
//		                    
//					 }
//					 else{
//					FileOutputStream os = new FileOutputStream(out);
//					a.extractFile(fh, os);
//					 
//					os.close();
//					 }
//				} catch (FileNotFoundException e) {
//				
//					e.printStackTrace();
//				} catch (RarException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				fh=a.nextFileHeader();
//			}
//		}
//	}
//    
    public static void main(String[] args) {
		
	}
}
