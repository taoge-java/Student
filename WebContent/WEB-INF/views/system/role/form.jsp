<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


  <div class="layui-form-item" style="margin-left: 30px;">
   <input type="hidden" name="id" value="${role.id}">
    <label class="layui-form-label">角色名称:</label>
    <div class="layui-input-block">
      <input type="text" name="role" autocomplete="off" placeholder="请输入角色" value="${role.role_name}"   class="layui-input" style="width: 300px;margin-left: 60px;">
    </div>
  </div>
    <div class="layui-form-item" style="margin-left: 30px;">
	    <label class="layui-form-label">是否系统管理员:</label>
	    <input type="radio" <c:if test="${role.flag==1}">checked="checked"</c:if>  name="admin" checked="checked" value="1" style="margin-left: 20px;margin-top: 10px;">是
	    <input type="radio" <c:if test="${role.flag==0}">checked="checked"</c:if>  name="admin" value="0" style="margin-left: 40px;">否
    </div>
  </div>
        <div class="label" style="margin-left: 30px;">
          <label class="layui-form-label">备注：</label>
        </div>
        <div class="field">
           <textarea id="remark" rows="10" cols="60" name="remark" style="margin-left: 25px;margin-top: 0px;padding-left:10px;padding-top:5px;">${role.remark}</textarea>
        </div>


  
