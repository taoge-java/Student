<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath %>resources/pintuer.css">
<link rel="stylesheet" href="<%=basePath %>resources/admin.css">
<script type="text/javascript" src="<%=basePath %>resources/js/jquery-3.1.0.min.js"></script>
<script src="<%=basePath %>resources/js/pintuer.js"></script>
<link rel="stylesheet" href="<%=basePath %>resources/layui-v1.0.5/layui/css/layui.css"  media="all">
<script type="text/javascript" src="<%=basePath %>resources/layui-v1.0.5/layui/layui.js"></script>
</head>
<body>
<div class="panel admin-panel">
 <form action="<%=basePath%>" id="form" method="post">
 <input type="hidden" name="pageNumber" id="next">
 <div>
	  <table class="table table-hover text-center">
		    <tr>
			      <th width="1%"><input type="checkbox"  name="student.id"></th>
			      <th width="1%">序号</th>
			      <th width="3%">学号</th>
			      <th width="5%">姓名</th>
		    </tr>
		    <tbody id="content">
            </tbody>
			     <tr>
			        <td colspan="50">
				      <div id="demo1"></div>
					  <ul id="biuuu_city_list"></ul> 
					</td>
			     </tr>	  
	  </table>
 </form> 
 </div>
</body>
<script type="text/javascript">
layui.use(['laypage', 'layer'], function(){
	  var laypage = layui.laypage
	  ,layer = layui.layer;
      //调用分页
	   laypage({
		   cont: 'demo1',
		   pages: "${page.totalPage}",//总页数
		   groups: 5, //连续显示分页数
		   jump: function(obj,first){
			   if(first!=true){//是否首次进入页面
				   $.ajax({
						url:"<%=basePath%>ajaxPage",
						dataType:"html",
						data:{
							"pageNumber":obj.curr
						},
						type:"post",
						success:function(data){
							$("#content").html(data);
						}
					})
			   }
		   }
       });
});
$(function(){
	$.ajax({
		url:"<%=basePath%>ajaxPage",
		dataType:"html",
		data:{
			"pageNumber":1
		},
		type:"post",
		success:function(data){
			$("#content").html(data);
		}
	})
});
</script>
</html>


 <!--    <tr>
        <td colspan="50">
          <div class="pagelist" > 
     <form action="<%=basePath%>" id="form" method="post">
          <input type="hidden" id="next" name="pageNumber">
          <c:if test="${page.totalPage>0}">
          <c:choose>
             <c:when test="${page.pageNumber>1}">
                <a href="javascript:changePage(${page.pageNumber-1})">上一页</a> 
             </c:when>
             <c:otherwise>
                <a href="javascript:showMessage(1)">上一页</a> 
             </c:otherwise>
          </c:choose>
          <c:forEach begin="1" end="${page.totalPage}" varStatus="user">
               <c:choose>
                 <c:when test="${page.pageNumber==user.index }">
                    <a href="javascript:changePage(${user.index})" style="background:#00AAEE ">${user.index}</a>
                 </c:when>
                 <c:otherwise>
                     <a href="javascript:changePage(${user.index})">${user.index}</a>
                 </c:otherwise>
               </c:choose>
            </c:forEach>
        <c:choose>
           <c:when test="${page.pageNumber<page.totalPage}">
              <a href="javascript:changePage(${page.pageNumber+1})">下一页</a>
           </c:when>
           <c:otherwise>
              <a href="javascript:showMessage(${page.totalPage})">下一页</a>
           </c:otherwise>
       </c:choose>
           <a href="javascript:changePage(${page.totalPage})">尾页</a> 
           </div></td>
       </c:if>
       </tr>
     --> 