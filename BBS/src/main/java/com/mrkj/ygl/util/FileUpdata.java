/**
 * 明日科技
 * 于国良 2016-06-29
 * QQ:80303857
 */
package com.mrkj.ygl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpdata {

	public static Boolean updataFiles (MultipartFile[] files,String path) throws IOException{
		Boolean bflag = false;
		
		FileOutputStream os  = null;
		FileInputStream in = null;
		String url = path;
		for(int i = 0;i<files.length;i++){
            System.out.println("fileName---------->" + files[i].getOriginalFilename());  
          
            if(!files[i].isEmpty()){
                int pre = (int) System.currentTimeMillis();  
                try {
                    //拿到输出流，同时重命名上传的文件  
                    os = new FileOutputStream(url + files[i].getOriginalFilename());  
                    //拿到上传文件的输入流  
                    in = (FileInputStream) files[i].getInputStream();  
                    
                    //以写字节的方式写文件  
                    int b = 0;  
                    while((b=in.read()) != -1){
                        os.write(b);  
                    }
                      os.flush();
                    int finaltime = (int) System.currentTimeMillis();  
                    System.out.println(finaltime - pre);  
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("上传出错");  
                } finally {
                    os.close();
                    in.close();
				}
            }
        }
		bflag = true;
		return bflag;
	}
	
	public static String updataFile (MultipartFile file,String path) throws IOException{
		String FileName = null;
		
		FileOutputStream os  = null;
		InputStream in = null;
		if(!file.isEmpty()){
			String fn = file.getOriginalFilename();
	              
			String fnex = fn.substring(fn.lastIndexOf('.'));
	            File filemkdir =new File(path);
	            if (!filemkdir.exists()  && !filemkdir.isDirectory()){
	            	filemkdir.mkdir();
	            }
	            if(!file.isEmpty()){
	                  
	                try {
	                	
	                	FileName = UuidUtil.get32UUID();
	                    //拿到输出流，同时重命名上传的文件  
	                    os = new FileOutputStream(path + FileName+fnex);  
	                    //拿到上传文件的输入流  
	                    in = file.getInputStream();  
	                    //以写字节的方式写文件  
	                    int b = 0;  
	                    while((b=in.read()) != -1){
	                        os.write(b);  
	                    }
	                      os.flush();  
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    System.out.println("上传出错");  
	                } finally {
	                    os.close();
	                    in.close();
					}
	            }
	           
			return FileName+fnex;
		}
		
		return "";
	}
	/**
	 * 上传本地服务器文件
	 * @param request		
	 * @param folderName	上传文件的路径
	 * @param fileMaxSize	每个上传文件的最大值（M为单位）
	 * @param files			上传的文件
	 * @return
	 */
	public static List<String> uploadFiles(HttpServletRequest request,String folderName, String fileMaxSize, List<MultipartFile> files){
		List<String> recNameList = new ArrayList<String>();
		String recName = null; 
		if(files!=null && files.size()>0){
			for(MultipartFile file:files){
				String originalFileName = file.getOriginalFilename();
				String realFileName = UuidUtil.get32UUID()+originalFileName.substring(originalFileName.lastIndexOf("."));
				Path dir = getFileDir(request,folderName);
				Path target = dir.resolve(realFileName);
				long filesize = file.getSize();
	    		long m = filesize/(1024*1024);
	    		try {
		    		if(m<Long.parseLong(fileMaxSize)){
		    			if(!Files.exists(dir)) {
							Files.createDirectories(dir);
						} 
		    			recName= realFileName ;
		    			recNameList.add(recName);
		    			Files.copy(file.getInputStream(), target);
	        		} else{
		    			recName="error";
		    		}
	    		}catch (IOException e) {
					recName="error";
					e.printStackTrace();
				}
			}
		}else{
			recName="error";
		}
		return recNameList;
	}
	/**
	 * 获取实际存储文件的目录
	 * @param request
	 * @return
	 */
	private static Path getFileDir(HttpServletRequest request,String folderName) {
		//获得项目路径
		String realPath = request.getServletContext().getRealPath("/");
		//获得工程名称
		String realPath1 = request.getContextPath();   
    	//将附件发布移除到与工程同层级
		Path dir = Paths.get(realPath.substring(0, realPath.length()-realPath1.length())).resolve(folderName);
		return dir;
	}
}
