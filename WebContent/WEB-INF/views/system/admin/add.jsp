<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" href="<%=basePath %>resource/css/index/pintuer.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/admin.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/my/add.css"> 
<link rel="stylesheet" href="<%=basePath %>resource/js/layui-v1.0.5/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/layui.css">
<script type="text/javascript" src="<%=basePath%>resource/js/jquery/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
   function create(){
	   $.post("<%=basePath%>system/admin/save",
		   $("#addform").serialize(),function(data){
		     if(data.code!=-1){
		    	 layer.alert(data.message, {
  					  icon: 1,
  					  skin: 'layer-ext-moon',
  					},function(){
  					location.href="<%=basePath%>system/admin";
				  });
		     }else{
		    	 layer.alert(data.message, {
  					  icon: 2,
  					  skin: 'layer-ext-moon',
  				 })
		     }
	   },"json"); 
   }
</script>
</head>
<body>
   <div class="panel admin-panel">
	   <div class="panel-head"><strong><span class="icon-key">
	       </span>管理员管理</strong>
	   </div>
	   <div class="body-content">
		   <form method="post" class="form-x" id="addform" action="<%=basePath%>system/admin/save"> 
		     <jsp:include page="form.jsp"/> 
		       <div class="student_info" style="margin-top: 15px;">
		         <label> 
		            <input type="button" value="添加管理员" id="btn_sub" onclick="create()">
		         </label>
               </div>
		   </form>
	   </div>
   </div>
</body>
</html>