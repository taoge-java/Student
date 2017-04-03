<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学科管理</title>
<script type="text/javascript" src="<%=basePath%>resource/js/jquery/jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="<%=basePath %>resource/css/index/pintuer.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/admin.css">
<link rel="stylesheet" href="<%=basePath %>resource/js/layer/skin/default/layer.css">
<script type="text/javascript" src="<%=basePath %>resource/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/add.js"></script>
<style type="text/css">
  a:hover{
    font-size: 18px;
  }
</style>
<script type="text/javascript">
	/**
	 * 添加学科
	 */
   function create(){
		location.href="<%=basePath%>"
   }
   //删除学科
   $(function(){
	   $("a[name='del']").click(function(){
		   var id=$(this).attr("value");
		   layer.confirm('确定删除', {
			   btn: ['删除','取消'] //按钮
			 }, function(){
			   $.ajax({
				   url:"<%=basePath%>subject/delById",
				   data:{
					   "id":id,
				   },
				   type:"get",
				   dataType:"json",
				   success:function(data){
					   alert(data.message);
					   if(data.code!=-1){
						   location.href="<%=basePath%>subject";
					   }
				   },
				   error:function(data){
					   alert("系统异常,请联系管理员");
				   }
			    });
			 }, function(){
			       return;
			 });
	   })
   });
   
</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <button class="button bg-yellow" style="margin: 8px 0px 15px 15px;height: 40px;" id="add" onclick="create()">
	       <span  class="icon-plus-circle">添加学科</span>
	</button>
 
  <table class="table table-hover text-center">
    <tr>
      <th width="3%"><input type="checkbox" name="id"></th>
      <th width="5%">id</th>
      <th width="8%">学科名称</th>
      <th width="8%">备注</th>
      <th width="10%">操作</th>
    </tr>
    <c:forEach items="${page.list}" var="list" >
    <tr>
      <td><input type="checkbox" id="role_id" value="${list.id}"></td>
      <td>${list.id}</td>
      <td>${list.subject_name }</td>
      <td>${list.remark }</td>
      <td>
       <a href="javascript:void(0)" name="update" ><span class="icon-pencil-square-o" style="color: blue;"></span></a>&nbsp;&nbsp;
       <a href="javascript:void(0)" name="del" value="${list.id}"><span class="icon-trash-o" style="color: red;"></span></a>
      </td>
    </tr>
   </c:forEach>
   <tr>
      
   
   </tr>
   
  </table>
</body>
</html>