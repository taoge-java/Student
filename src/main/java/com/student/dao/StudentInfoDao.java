package com.student.dao;

import java.util.List;

import com.student.model.student.Student;



public class StudentInfoDao {
	
      public List<Student> StudentList(){
		  return Student.dao.find("select *from student_info");
      }
      
    
}
