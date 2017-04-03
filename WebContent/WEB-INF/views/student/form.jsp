<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input type="hidden" name="student.id" value="${student.id}">
     <div class="student_info">
        <label>学生姓名:</label><input type="text" name="student.name" value="${student.name}">*
        <label>学生学号:</label><input type="text" name="student.number"  value="${student.number }" >*
     </div>
     <div class="student_info">
        <label >学生地址:</label><input type="text" name="student.address" value="${ student.address}">*
     </div>
     <div class="student_info">
        <label>学生年龄:</label><select name="student.age" id="ages">
              <option <c:if test="${student.age==10 }">selected="selected"</c:if>>10</option>
              <option <c:if test="${student.age==11 }">selected="selected"</c:if>>11</option>
              <option <c:if test="${student.age==12 }">selected="selected"</c:if>>12</option>
              <option <c:if test="${student.age==13 }">selected="selected"</c:if>>13</option>
              <option <c:if test="${student.age==14 }">selected="selected"</c:if>>14</option>
              <option <c:if test="${student.age==15 }">selected="selected"</c:if>>15</option>
              <option <c:if test="${student.age==16 }">selected="selected"</c:if>>16</option>
              <option <c:if test="${student.age==17 }">selected="selected"</c:if>>17</option>
              <option <c:if test="${student.age==18 }">selected="selected"</c:if>>18</option>
          </select>岁*
       
     </div>
     <div class="student_info">
        <label>所在年级:</label>
            <select name="student.grade" >
              <option <c:if test="${student.grade=='初一' }">selected="selected"</c:if> >初一</option>
              <option <c:if test="${student.grade=='初二' }">selected="selected"</c:if>>初二</option> 
              <option <c:if test="${student.grade=='初三' }">selected="selected"</c:if>>初三</option>
               <option <c:if test="${student.grade=='高一' }">selected="selected"</c:if>>高一</option>
              <option <c:if test="${student.grade=='高二' }">selected="selected"</c:if>>高二</option>
              <option <c:if test="${student.grade=='高三' }">selected="selected"</c:if>>高三</option>
            </select>
             <select name="student.s_class">
              <option <c:if test="${student.s_class==1 }">selected="selected"</c:if>>1</option>
              <option <c:if test="${student.s_class==2 }">selected="selected"</c:if>>2</option>
              <option <c:if test="${student.s_class==3 }">selected="selected"</c:if>>3</option>
              <option <c:if test="${student.s_class==4 }">selected="selected"</c:if>>4</option>
              <option <c:if test="${student.s_class==5 }">selected="selected"</c:if>>5</option>
              <option <c:if test="${student.s_class==6 }">selected="selected"</c:if>>6</option>
              <option <c:if test="${student.s_class==7 }">selected="selected"</c:if>>7</option>
              <option <c:if test="${student.s_class==8 }">selected="selected"</c:if>>8</option>
              <option <c:if test="${student.s_class==9 }">selected="selected"</c:if>>9</option>
              <option <c:if test="${student.s_class==10}">selected="selected"</c:if>>10</option>
              <option <c:if test="${student.s_class==11}">selected="selected"</c:if>>11</option>
              <option <c:if test="${student.s_class==12}">selected="selected"</c:if>>12</option>
              <option <c:if test="${student.s_class==13}">selected="selected"</c:if>>13</option>
              <option <c:if test="${student.s_class==14}">selected="selected"</c:if>>14</option>
              <option <c:if test="${student.s_class==15}">selected="selected"</c:if>>15</option>
              <option <c:if test="${student.s_class==16}">selected="selected"</c:if>>16</option>
              <option <c:if test="${student.s_class==17}">selected="selected"</c:if>>17</option>
              <optiop <c:if test="${student.s_class==18}">selected="selected"</c:if>>18</option>
              <option <c:if test="${student.s_class==19}">selected="selected"</c:if>>19</option>
              <option <c:if test="${student.s_class==20}">selected="selected"</c:if>>20</option>
            </select>班
         </div> 
         <div class="student_info">
        <label>学生性别:</label>&nbsp;&nbsp;
        <input type="radio" name="student.sex"  
         <c:if test="${student.sex==1}"> checked="checked"</c:if>
           value="1">男
        <label style="padding-left: 50px;"><input type="radio" name="student.sex" 
          <c:if test="${student.sex==2}">checked="checked"</c:if>
        value="2" >女</label>
     </div>
     
     <div class="student_info">
        <label>联系电话:</label><input type="text" name="student.tel" value="${student.tel}">*
        <label>学生职务:</label><input type="text" name="student.office" value="${student.office }">(可选填)
     </div>
      <div class="student_info">
        <label>入学时间:</label><input type="text" name="student.join_school_time"
          value="${student.join_school_time}" onclick="WdatePicker()"
        >*
         <font color="red" style="padding-left: 50px;">注:(带*为必填项)</font>
     </div>
      <div style="position:relative;left: 55px;margin-top:5px;color:red;  height: 30px;" id="error"></div>
 