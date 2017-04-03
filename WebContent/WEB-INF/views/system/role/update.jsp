<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/pintuer.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/admin.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/my/add.css"> 
<link rel="stylesheet" href="<%=basePath %>resource/js/layui-v1.0.5/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/layui.css">
<script type="text/javascript" src="<%=basePath%>resource/js/jquery/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
   $(function(){
	   $("#btn_sub").click(function(){
		   var flag=$('input:radio[name="admin"]:checked').attr("value");
		   var id=$("input[name='id']").attr("value");
		   $.ajax({
			   url:"/Student/system/role/update",
			   type:"post",
			   dataType:"json",
			   data:{
				   "id":id,
				   "flag":flag,
				   "name":$("input[name='role']").val(),
				   "remark":$("#remark").val(),
			   },
			   success:function(data){
				  if(data.code!=-1){
					  layer.alert(data.message, {
	   					  icon: 1,
	   					  skin: 'layer-ext-moon',
	   					},function(){
						  location.href="/Student/system/role";
					  });
				  }else{
					  layer.alert(data.message, {
	   					  icon: 2,
	   					  skin: 'layer-ext-moon',
	   					})
				  } 
			   },
			   error:function(data){
				   layer.alert(data.message, {
	   					  icon: 2,
	   					  skin: 'layer-ext-moon',
	   					})
			   }
		   });
	 
	   });
   });
</script>
<title>Insert title here</title>
</head>
<body>
   <div class="panel admin-panel">
	   <div class="panel-head"><strong><span class="icon-key">
	       </span>角色设置</strong>
	   </div>
	   <div class="body-content">
		   <form method="post" class="form-x" id="addform" action="<%=basePath%>system/role/update">
		    
		       <jsp:include page="form.jsp"/> 
		       <div class="student_info" style="margin-top: 15px;">
		         <label> 
		            <input type="button" value="修改角色" id="btn_sub">
		         </label>
               </div>
		   </form>
	   </div>
   </div>
</body>
</html>