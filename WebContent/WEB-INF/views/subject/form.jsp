<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <input type="hidden" name="student.id" value="${student.id}">
     <div class="student_info">
        <label>学科名称:</label><input type="text" name="" value="">
     </div>
     <div class="form-group">
        <div class="label">
          <label for="stop">备注：</label>
        </div>
        <div class="field">
           <textarea rows="10" cols="60" name="reamrk"></textarea>
        </div>
      </div>
