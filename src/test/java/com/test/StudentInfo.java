package com.test;

import java.util.HashSet;
import java.util.Iterator;

public class StudentInfo {
	public static void main(String[] args) {
//		LinkedHashSet<String> set=new LinkedHashSet<String>();
//		set.add("a");
//		set.add("a");
//		set.add("b");
//		 Iterator<String> it=set.iterator();
//		 while(it.hasNext()){
//			 System.out.println(it.next());
//		 }
		 
		    HashSet<String> set1=new HashSet<String>();
		    set1.add("a");
			set1.add("b");
			set1.add("c");
			set1.add("d");
			set1.add("e");
			set1.add("f");
			 Iterator<String> it1=set1.iterator();
			 while(it1.hasNext()){
				 System.out.println(it1.next());
			 }
	}

//	private StudentInfoServices services=Duang.duang(StudentInfoServices.class.getName(), StudentInfoServices.class);
//	
//	private Logger log=Logger.getLogger(StudentControl.class);
//	
//	
//	/**
//	 * 添加学生信息
//	 * 
//	 */
//	public void index(){
//		rendView("student/add.jsp");
//	}
//	/**
//	 * 添加学生信息ajax检验
//	 */
//	public void Ajaxadd(){
//		String stu_number=getPara("stu_number");
//		String stu_jointime=getPara("stu_jointime");
//		String stu_tel=getPara("stu_tel");
//		Pattern number=Pattern.compile("\\d?[a-zA-Z]");
//		
//		//学号校验
//		if(!number.matcher(stu_number).find()){
//			renderJson(new ResultCode(ResultCode.FAIL, "学号为数字字母组合!"));
//			return;
//		}
//		//日期校验
//		Pattern time=Pattern.compile("(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01])");
//		if(!time.matcher(stu_jointime).find()){
//			renderJson(new ResultCode(ResultCode.FAIL, "日期格式错误"));
//			return;
//		}
//		//手机号码校验
//		Pattern mobile=Pattern.compile("13\\d{9}|15\\d{9}|18\\d{9}|17\\d{9}");
//		if(!mobile.matcher(stu_tel).find()){
//			renderJson(new ResultCode(ResultCode.FAIL, "手机号码格式错误"));
//			return;
//		}
//		renderJson(new ResultCode(ResultCode.SUCCESS, "保存成功!"));
//	}
//	/**
//	 * 保存学生信息
//	 */
//	public void save(){
//	    StudentInfo student=getModel(com.student.model.StudentInfo.class,"student");
//	    student.save();
//	    this.Paginate();
//	}
//	
//	
//	/**
//	 * 保存修改信息
//	 */
//	public void update(){
//		StudentInfo stu=getModel(StudentInfo.class,"student");
//		stu.update();
//		this.Paginate();
//	}
//	/**
//	 * 修改学生信息
//	 */
//
//	public  void alert(){
//	   Integer id=getParaToInt(0);
//	   if(id!=null&&id>0){
//			setAttr("student", services.findById(id));
//		}
//	    rendView("student/edit.jsp");
//	}
//	/**
//	 * 删除学生信息
//	 */
//	public void delete(){
//	   Integer id=getParaToInt("id");
//	   if(services.deteteById(id)){
//		   ResultCode result=new ResultCode(ResultCode.SUCCESS,"删除成功");
//		   renderJson(result);
//	   }
//	}
//	/**
//	 * 批量删除学生信息
//	 */
//	public void deleteByIds(){
//		String id=getPara("ids");
//		if(services.deleteByIds(StringUtils.split(id,","))){
//			ResultCode result=new ResultCode(ResultCode.SUCCESS,"批量删除成功");
//			renderJson(result);
//		}
//	}
//	/**
//	 * 分页显示学生信息
//	 */
//
//	public void Paginate(){
//     	String name=getPara("name");
//		String sex=getPara("sex");
//		String startTime=getPara("start_time");
//		String stopTime=getPara("stop_time");
//        Integer pageNumber=getParaToInt("pageNumber", 1);
//		Page<StudentInfo> page=services.Paginate(pageNumber, CommonConstant.pageSize,name,sex,startTime,stopTime);
//        setAttr("name", name);
//		setAttr("sex", sex);
//		setAttr("startTime",startTime);
//		setAttr("stopTime", stopTime);
//		setAttr("students", page);
//	    rendView("student/list.jsp");
//	}
//	
//	/**
//	 * excel数据导出
//	 */
//	public void Export(){
//		String name=getPara("name");
//		String sex=getPara("sex");
//		String startTime=getPara("start_time");
//		String stopTime=getPara("stop_time");
//	    List<StudentInfo> list=services.getExportData(name,sex,startTime,stopTime);
//		String fileName="学生信息表.xls";
//		HttpServletResponse response = getResponse();
//		HSSFWorkbook work=services.exportExcel(list);
//		render(new MyFileExcelRender(fileName, response, work));
//	}
//	
//	/**
//	 * 文件上传
//	 */
//	public void upload(){
//		UploadFile uploadFile=getFile("head");
//		String filePath=null;
//		try{
//			if(uploadFile.getFile().length()>1024 * 1024 * 2){
//				render(new JsonRender("{\"code\":-1, \"message\":\"图片大小不得超过2M\"}").forIE());
//				return;
//			}
//			String oriName = uploadFile.getFileName();
//			String ext=oriName.substring(oriName.lastIndexOf("."), oriName.length());
//			if(!ext.equals(".png")&&!ext.equals(".jpg")&&!ext.equals(".jpeg")&&!ext.equals(".bmp")){
//				render(new JsonRender("{\"code\":-1, \"message\":\"图片格式应为png,jpg,jpeg,bmp\"}").forIE());
//				return;
//			}
//		      filePath=UploadRename(uploadFile);
//		}catch(Exception e){
//			System.err.println("文件上传失败。。。");
//		}
//		render(new JsonRender("{\"code\":0,\"path\":\""+filePath+"\"}").forIE());
//	}
}
