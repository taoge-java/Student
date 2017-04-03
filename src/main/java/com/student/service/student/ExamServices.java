package com.student.service.student;

import org.apache.commons.lang.StringUtils;

import com.jfinal.log.Logger;
import com.student.model.student.ExamInfo;
import com.student.utils.MatchUtil;
import com.student.utils.Result;
import com.student.utils.ResultCode;

public class ExamServices {
	
	private Logger log=Logger.getLogger(ExamServices.class);
	/**
	 * 保存信息
	 * @param exam
	 * @param subject_ids
	 * @return
	 */
	public Result save(ExamInfo exam,String subject_ids){
		Result result=new Result();
		ResultCode resultCode=new ResultCode(ResultCode.SUCCESS, "信息保存成功");
		ExamInfo info = ExamInfo.dao.findFirst("select * from exam_info where title=?",exam.getStr("title"));
		if(info!=null){
			resultCode=new ResultCode(ResultCode.FAIL, "该�?�试信息已存�?!");
			result.setResultCode(resultCode);
		    return result;
		}
		if(StringUtils.isEmpty(exam.getStr("title"))){
			resultCode=new ResultCode(ResultCode.FAIL, "考试信息不能为空!");
			result.setResultCode(resultCode);
		    return result;
		}
		if(StringUtils.isEmpty(exam.getStr("start_time"))){
			resultCode=new ResultCode(ResultCode.FAIL, "�?始时间不能为�?!");
			result.setResultCode(resultCode);
		    return result;
		}
		if(StringUtils.isEmpty(exam.getStr("stop_time"))){
			resultCode=new ResultCode(ResultCode.FAIL, "结束时间不能为空!");
			result.setResultCode(resultCode);
		    return result;
		}
		if(!MatchUtil.getMatcher(exam.getStr("start_time")).matches()||!MatchUtil.getMatcher(exam.getStr("stop_time")).matches()){
			resultCode=new ResultCode(ResultCode.FAIL, "时间格式错误!");
		    result.setResultCode(resultCode);
			return result;
		}
		try{
			exam.set("subject_ids", subject_ids);
		    exam.save();
		}catch(Exception e){
			resultCode=new ResultCode(ResultCode.FAIL, "创建数据异常");
			log.error("创建数据异常");
		}
		result.setResultCode(resultCode);
	    return result;
	}

}
