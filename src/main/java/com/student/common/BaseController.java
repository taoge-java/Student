package com.student.common;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.student.config.SysConfig;
import com.student.dao.UserSession;
import com.student.model.system.SystemLog;
import com.student.utils.DateUtil;
import com.student.utils.IpUtils;
import com.student.utils.NumberUtils;

public class BaseController extends Controller{
	
	
	public void rendView(String path){
		render(SysConfig.BASE_VIEW+path);
	}
	
	public  UserSession getCurrentUser(){
		return  getSessionAttr("user");
	}
	
	@SuppressWarnings("static-access")
	public void systemLog(String oper_des,int type){
		UserSession user=getCurrentUser();
		SystemLog systemLog=new SystemLog();
		systemLog.set("oper_user", user.getLoginName());
		systemLog.set("user_id", user.getUserId());
		systemLog.set("oper_time", new DateUtil().getDateTime());
		systemLog.set("oper_ip", IpUtils.getAddressIp(getRequest()));
		systemLog.set("login_type",type);
		systemLog.set("oper_desc",oper_des);
		systemLog.save();
	}
	
	/**
	 * 文件上传重命名
	 */
	public String UploadRename(UploadFile upload){
		File file=upload.getFile();
		try {
			FileInputStream in=new FileInputStream(file);
			String fileName=upload.getFileName();
			String style=fileName.substring(fileName.indexOf(","),fileName.length());
			String newName=NumberUtils.getMessageNum(4)+style;
			String imagePath=getImagePath();
			String basePath=SysConfig.resourceUpload+"/"+imagePath;
			File fi=new File(basePath);
			if(!fi.exists()){
				fi.mkdirs();
			}
			File upFile=new File(basePath,newName);
			FileOutputStream out=new FileOutputStream(upFile);
			byte[] bytes=new byte[1024];
			int flag=0;
			while((flag=in.read(bytes, 0, 1024))!=-1){
				out.write(bytes, 0, flag);
			}
			if(out!=null){
				out.close();
			}
			if(in!=null){
				in.close();
			}
			file.delete();
			return basePath+"/"+newName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public String getImagePath(){
		DateFormat format = new SimpleDateFormat("yyyy-MMdd");
		return format.format(new Date()).replaceAll("-", "/");
	}
}
