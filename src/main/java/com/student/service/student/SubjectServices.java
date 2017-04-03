package com.student.service.student;


import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.student.constant.CommConstant;
import com.student.model.system.SystemSubject;

public class SubjectServices {
	
	Logger log=Logger.getLogger(SubjectServices.class);

	public Page<SystemSubject> getSubject(int pageNumber){
		return SystemSubject.dao.paginate(pageNumber, CommConstant.pageSize, "select *"," from system_subject");
	}
}
