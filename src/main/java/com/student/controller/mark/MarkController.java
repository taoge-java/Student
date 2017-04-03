package com.student.controller.mark;
import java.util.ArrayList;
import java.util.List;

import com.jfinal.ext.route.ControllerBind;
import com.student.common.BaseController;
import com.student.model.student.Mark;
import com.student.model.student.Student;
import com.student.model.system.SystemSubject;
import com.student.service.student.MarkServices;
import com.student.utils.Result;
@ControllerBind(controllerKey="/mark")
public class MarkController extends BaseController{
	
	private MarkServices markServices=new MarkServices();
	/**
	 * 学生成绩信息列表
	 */
	public void list(){
		List<Mark> mark=new ArrayList<>();
		Result result=markServices.list();
		setAttr("subjects", result.getList());
		List<Object> all=new ArrayList<Object>();
		//List list=Student.dao.find("select * from student_info as si INNER JOIN student_mark as sm on si.number=sm.number INNER JOIN system_subject as subject on subject.subject_name=sm.subject_name");
		//List score=Mark.dao.find("select id,group_concat(score) as score from student_mark group by  number");
		List<Student> lists=Student.dao.find("select * from student_info");
		//for(Student list:lists){
		//	String number1=list.getStr("number");
			//mark=Mark.dao.find("select * from  student_mark where number=?","C10D1405");
		  //  all.addAll(mark);
	//	}
		//List<Mark> mark=Mark.dao.find("select * from  student_mark where number=?","C10D1405");
		//setAttr("lists", lists);
		//setAttr("all", all);
		setAttr("list", lists);
		//setAttr("score", score);
		rendView("mark/list.jsp");
		//setAttr("score", score);
		
	}

	/**
	 * 添加考试成绩
	 */
	public void add(){
		Result result=markServices.add();
		setAttr("exams", result.getList());
		setAttr("subjects",SystemSubject.dao.find("select * from system_subject"));
		rendView("mark/add.jsp");
	}
	/**
	 * 保存学生成绩
	 */
	public void save(){
		String name=getPara("name");
		String souces=getPara("souces");
		String subject=getPara("subject");
		String title_id=getPara("title");
		String number=getPara("number");
		Result result=markServices.save(name, subject, title_id, number, souces);
		renderJson(result.getResultCode());
	}
}
