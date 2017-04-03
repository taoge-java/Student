package com.student.service.student;

import java.util.List;
import java.util.regex.Pattern;

import com.jfinal.log.Logger;
import com.student.model.student.ExamInfo;
import com.student.model.student.Mark;
import com.student.model.system.SystemSubject;
import com.student.utils.Result;
import com.student.utils.ResultCode;

public class MarkServices {
	
	private Logger log=Logger.getLogger(MarkServices.class);
	/**
	 * 学生成绩列表
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Result list(){
		Result result=new Result();
		List subject=SystemSubject.dao.find("select * from system_subject");
		result.setList(subject);
		return result;
	}
	/**
	 * 添加学生成绩
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	 public Result add(){
		Result result=new Result();
		List exams=ExamInfo.dao.find("select * from exam_info");
		result.setList(exams);
		return result;
	}
	
	/**
	 * 保存学生成绩
	 */
	public Result save(String name,String subject,String title_id,String number,String souces){
		Result result=new Result();
		ResultCode resultCode=new ResultCode(ResultCode.SUCCESS, "数据添加成功");
        Pattern num=Pattern.compile("\\d?[a-zA-Z]");
		//学号校验
		if(!num.matcher(number).find()){
			resultCode= new ResultCode(ResultCode.FAIL, "学号为数字字母组�?!");
			result.setResultCode(resultCode);
			return result;
		}
		try{
			Mark mark=new Mark();
			mark.set("name", name);
			mark.set("exam_title_id", title_id);
			mark.set("number", number);
			mark.set("score", souces);
			mark.set("subject_name", subject);
			mark.save();
		}catch(Exception e){
			resultCode=new ResultCode(ResultCode.FAIL, "更新数据异常!");
			e.printStackTrace();
			log.error("更新数据异常!!!");
		}
		result.setResultCode(resultCode);
		return result;
	}

}
