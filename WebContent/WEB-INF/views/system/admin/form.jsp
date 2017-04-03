<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
   <div>
      <table>
         <tr>
            <td>登  录  名:</td><td><input  style="line-height: 25px;" type="text" name="systemAdmin.login_name" value="${admin.login_name }"></td>
            <td style="width: 90px;"></td>
            <td>登录密码:</td><td><input style="line-height: 25px;" type="password" name="password"  value="${admin.sys_password }" ></td>
         </tr>
         <tr>
            <td>真实姓名:</td><td><input style="line-height: 25px;" type="text" name="systemAdmin.real_name" value="${admin.real_name }"></td>
            <td style="width: 90px;"></td>
            <td>选择角色:</td>
              <td>
                 <select  style="width:175px;height: 30px;">
                 <option value="">---请选择角色---</option>
                 <c:forEach items="${list}" var="role">
                    <option value="${role.id}">${role.role_name }</option>
                 </c:forEach>
                  
               </select>
             </td>
         </tr>
         <tr>
            <td>QQ:</TD><TD><input type="text" style="line-height: 25px;" name="systemAdmin.qq" value="${admin.qq }"></td>
             <td style="width: 90px;"></td>
            <td>Email:</td><td><input type="text" style="line-height: 25px;" name="systemAdmin.email" value="${admin.email }"></td>
             <td></td>
         </tr>
         <tr>
             <td>手机号码:</td><td><input type="text" style="line-height: 25px;" name="systemAdmin.mobile" value="${admin.mobile }"></td>
              <td style="width: 90px;"></td>
              <td>是否禁用:</td>
              <td ><input type="radio" name="systemAdmin.disabled_flag" value="1" <c:if test="${admin.disabled_flag==1 }">checked="checked"</c:if> checked="checked">是&nbsp;&nbsp;&nbsp;
               <input type="radio" name="systemAdmin.disabled_flag" <c:if test="${admin.disabled_flag==0 }">checked="checked"</c:if>  value="0">否 </td>
         </tr>
         <tr>
           <td>
                          是否超级管理员:</td><td >
            <input type="radio" name="systemAdmin.super_flag" <c:if test="${admin.super_flag==1 }">checked="checked"</c:if> value="1" checked="checked">是&nbsp;&nbsp;&nbsp;
            <input type="radio" name="systemAdmin.flag" <c:if test="${admin.super_flag==0 }">checked="checked"</c:if> value="0">否
            </td>
            <td>  </td></td>
             <td></td>
         </tr>
      </table>
   
   
   
   </div>



  <!--    <div class="student_info">
        <>登  录  名:</><input type="text" name="login_name" value="${student.name}">*
        <>登录密码:</><input type="text" name="student.number"  value="${student.number }" >*
     </div>  
     <div class="student_info">
        <>真是角色:</><input type="text" name="student.tel" value="${student.tel}">*
        <>学生职务:</><input type="text" name="student.office" value="${student.office }">(可选填)
     </div>
     <div class="student_info">
        <>QQ:</><input type="text" name="student.tel" value="${student.tel}">*
        <>Email:</><input type="text" name="student.office" value="${student.office }">(可选填)
     </div>
     <div class="student_info">
        <>是否超级管理员:</><input type="text" name="login_name" value="${student.name}">*
        <>是否禁用:</><input type="text" name="student.number"  value="${student.number }" >*
     </div>  

-->

  
