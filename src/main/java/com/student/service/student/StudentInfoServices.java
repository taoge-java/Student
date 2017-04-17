package com.student.service.student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.DateUtil;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.jfinal.plugin.activerecord.Page;
import com.student.constant.Gender;
import com.student.dao.StudentInfoDao;
import com.student.model.student.StudentInfo;


@SuppressWarnings("unused")
public class StudentInfoServices {
	private StudentInfoDao studentDao=new StudentInfoDao();
	/**
	 * 学生列表
	 * @return
	 */
	public List<StudentInfo> StudentList(){
		
		return studentDao.StudentList();
	}
	/**
	 * 根据id修改学生信息
	 * @param id
	 * @return
	 */
	public StudentInfo findById(int id){
		return StudentInfo.dao.findById(id);
	}
    /***
     * 单条删除学生信息
     * @param id
     * @return
     */
	public boolean deteteById(Integer id){
		return StudentInfo.dao.deleteById(id);
	}
	/**
	 * 批量删除学生信息
	 */
	
	public boolean deleteByIds(String[] ids){
	    
		for(String id:ids){
			StudentInfo.dao.deleteById(id);
		}
		return true;
	}
	/**
	 * 分页查询
	 */

	public Page<StudentInfo> Paginate(int pageNumber,int pageSize,String name,String sex,
			String	startTime,String  topTime){
	    	List<Object> param=new ArrayList<Object>();
	    	StringBuilder context=new StringBuilder("from student_info where 1=1");
	    	if(StringUtils.isNotBlank(name)){
	    		context.append(" and (name=? or address=?)");
	    		param.add(name);
	    		param.add(name);
	    	}
	    	if(StringUtils.isNotEmpty(sex)){
	    		context.append(" and sex=?");
	    		param.add(Integer.parseInt(sex));
	    	}
	    	if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(topTime)){
	    		
	    		context.append(" and join_school_time between ? and ?");
	    		param.add(startTime.replaceAll("/", "-"));
	    		param.add(topTime.replaceAll("/", "-"));
	    	}
	    	return  StudentInfo.dao.paginate(pageNumber, pageSize, "select *",context.toString(),param.toArray());
    }
	
	
	
	/**
	 * 得到excel数据
	 */
	public List<StudentInfo> getExportData(String name,String sex,String startTime,String stopTime){
		
		List<Object> param=new ArrayList<Object>();
		StringBuilder context=new StringBuilder("from student_info where 1=1");
		if(StringUtils.isNotBlank(name)){
			context.append(" and (name=? or address=?)");
    		param.add(name);
    		param.add(name);
		}
		if(StringUtils.isNotEmpty(sex)){
    		context.append(" and sex=?");
    		param.add(sex);
		}
    	if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(stopTime)){
    		
    		context.append(" and join_school_time between ? and ?");
    		param.add(startTime.replaceAll("/", "-"));
    		param.add(stopTime.replaceAll("/", "-"));
    	}
    	return StudentInfo.dao.find("select *"+context.toString(),param.toArray());
	}
	/**
	 * 生成excel表格
	 */
	public HSSFWorkbook exportExcel(List<StudentInfo> list){
		HSSFWorkbook work=new HSSFWorkbook();
		HSSFSheet sheet=work.createSheet("sheet1");
		HSSFRow row=sheet.createRow(0);
		// 设置excel每列宽度  
		sheet.setColumnWidth(0, 3500);  
		sheet.setColumnWidth(1, 5000);  

		// 创建字体样式  
		HSSFFont font = work.createFont();  
		font.setFontName("Verdana");  
		font.setBoldweight((short) 100);  
		font.setFontHeight((short) 300);  
		font.setColor(HSSFColor.BLUE.index);  

		// 创建单元格样�?  
		HSSFCellStyle style = work.createCellStyle();  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  

		// 设置边框  
		style.setBottomBorderColor(HSSFColor.RED.index);  
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);  

		String title[]={"序号","学号","姓名","年龄","性别","班级","职务","联系电话","入学时间","家庭地址"};
	    for(int i=0;i<title.length;i++){
	      HSSFCell cell=row.createCell(i);
	      cell.setCellValue(title[i]);
	      cell.setCellStyle(style);
	    }
		System.out.println(list.size());
	    for(int i=1;i<=list.size();i++){
	    	HSSFRow next=sheet.createRow(i);
	    	//创建第一�?
	    	HSSFCell cell0=next.createCell(0);
	    	cell0.setCellStyle(style);
	    	cell0.setCellValue(list.get(i-1).getInt("id"));
	    	//创建第二�?
	    	HSSFCell cell1=next.createCell(1);
	    	cell1.setCellStyle(style);
	    	cell1.setCellValue(list.get(i-1).getStr("number"));
	    	
	    	HSSFCell cell2=next.createCell(2);
	    	cell2.setCellStyle(style);
	    	cell2.setCellValue(list.get(i-1).getStr("name"));
	    	
	    	HSSFCell cell3=next.createCell(3);
	    	cell3.setCellStyle(style);
	    	cell3.setCellValue(list.get(i-1).getInt("age"));
	    	
	    	HSSFCell cell4=next.createCell(4);
	    	cell4.setCellStyle(style);
	    	if(list.get(i-1).getInt("sex")==Gender.MAN.getValue()){
	    	    cell4.setCellValue("�?");
	    	}else{
	    		cell4.setCellValue("�?");
	    	}
	    	
	    	HSSFCell cell5=next.createCell(5);
	    	cell5.setCellStyle(style);
	    	cell5.setCellValue(list.get(i-1).getStr("grade")+list.get(i-1).getInt("s_class")+"�?");
	    	
	    	HSSFCell cell6=next.createCell(6);
	    	cell6.setCellStyle(style);
	    	cell6.setCellValue(list.get(i-1).getStr("office"));
	    	
	    	HSSFCell cell7=next.createCell(7);
	    	cell7.setCellStyle(style);
	    	cell7.setCellValue(list.get(i-1).getStr("tel"));
	    	
	    	HSSFCell cell8=next.createCell(8);
	    	cell8.setCellStyle(style);
	    	Date data=list.get(i-1).getDate("join_school_time");
	    	SimpleDateFormat  format=new SimpleDateFormat("yyy-MM-dd");
			String  text=format.format(data);
	    	cell8.setCellValue(text);
	    	
	    	HSSFCell cell9=next.createCell(9);
	    	cell9.setCellStyle(style);
    	    cell9.setCellValue(list.get(i-1).getStr("address"));
	    }
	    return work;
	    
	}
}
