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
<title></title>
<link rel="stylesheet" href="<%=basePath %>resource/css/index/pintuer.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/admin.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/my/add.css"> 
<script type="text/javascript" src="<%=basePath%>resource/js/jquery/jquery-3.1.0.min.js"></script>
 <script type="text/javascript" src="<%=basePath%>resource/js/add.js"></script>
 <script type="text/javascript" src="<%=basePath %>resource/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div class="panel admin-panel" >
   <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加学生信息</strong></div>
     <form action="<%=basePath%>student/save" method="post"  id="student_form">
        <jsp:include page="form.jsp"/>
       <div class="student_info">
         <label> 
            <input type="button" value="保存"  id="btn_sub">
         </label>
       </div>
     </form>
   </div>
</div>
</body>
</html>