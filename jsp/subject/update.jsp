<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改学科</title>
</head>
<body>
<div class="panel admin-panel" >
   <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>学科修改</strong></div>
     <form action="<%=basePath%>subject/update" method="post"  id="student_form">
        <jsp:include page="form.jsp"/>
          <div class="student_info">
            <label> 
               <input type="button" value="修改"  id="btn_sub">
            </label>
         </div>
     </form>
   </div>
</div>
</body>
</html>