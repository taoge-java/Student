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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath %>resource/css/index/pintuer.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/admin.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/layui.css"> 
<script type="text/javascript" src="<%=basePath %>resource/js/jquery/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=basePath %>resource/js/jquery.js"></script>
<script src="<%=basePath %>resource/js/pintuer.js"></script>
<script type="text/javascript">
	/**
	 * 添加管理员
	 */
   function create(){
	   location.href="<%=basePath%>system/admin/add";
   }
	//分页
   function pageChange(pageNumber){
	   $("#pageNumber").val(pageNumber);
	   $("#data-form").submit();
   }
   function showMessage(pageNumber){
		if(pageNumber==1){
			layer.alert('已经是首页了', {
				  icon: 2,
				  skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
			})
		}else{
			layer.alert('已经是最后一页了', {
				  icon: 2,
				  skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
			 })
		}
	}
   //删除
   $(function(){
	   $("a[name='del']").click(function(){
		 var id= $(this).attr("value");
		   if(confirm("确定删除吗")){
			   $.ajax({
				   url:"<%=basePath%>system/admin/deleteById",
				   type:"get",
				   dataType:"json",
				   data:{
					   "id":id,
				   },
				   success:function(data){
					   alert(data.message);
					   if(data.code!=-1){
						   location.href="<%=basePath%>system/admin";
					   }
				   },
				   error:function(data){
					   alert("系统异常,请联系管理员");
				   }
			   });
		   }else{
			   return ;
		   }
	   })
   })
   function check_all(){
		if($("input[type='checkbox']").is(':checked')){
			$("input[type='checkbox']").attr("checked",false);
			
		}else{
			$("input[type='checkbox']").attr("checked",true);
			
		}
		
	}
   /**
   批量删除
*/
function delAll(){
	var ids="";
	$("input[name='all']").each(function(){
		if(this.checked){
			ids+=this.value+",";
		}
		 
	});
    if(confirm("确定删除吗")){
		if(ids==""){
			alert("请选择要删除的数据!");
			return ;
		}else{
	$.ajax({
		url:"<%=basePath%>system/admin/delAll",
		data:{
			"ids":ids
			},
	    type:"post",
	    dataType:"json",
	    success:function(data){
			if(data.code!=-1){
				alert(data.message);
				location.href="<%=basePath%>system/admin";
	        }
	    }
	  });
		}
	}else{
		return false;
	}
}
</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <form action="<%=basePath%>system/admin/Paginate" method="post" id="data-form">
    <button class="button bg-yellow" type="button"  style="margin: 8px 0px 15px 15px;height: 40px;" id="add" onclick="create()">
	       <span  class="icon-plus-circle">添加管理员</span>
	</button>
	<input type="text" placeholder="请输入登录名" name="admin.name" class="input" value="${login_name}"  style="width:250px; line-height:17px;display:inline-block" />
     <button  class="button border-main icon-search"> 搜索</button>
  <table class="table table-hover text-center">
    <tr>
      <th width="3%"><input type="checkbox" name="id"></th>
      <th width="5%">id</th>
      <th width="8%">登录名</th>
      <th width="10%">手机号码</th>
      <th width="5%">最后登录IP</th>
      <th width="18%">最后登录时间</th>
      <th width="10%">操作</th>
    </tr>
    <c:forEach items="${admins.list}" var="admin" >
    <tr>
      <td><input type="checkbox" name="all" value="${admin.id}"></td>
      <td>${admin.id}</td>
      <td>${admin.login_name}</td>
      <td>${admin.mobile}</td>
      <td>${admin.login_ip}</td>
      <td>${admin.login_time }</td>
      <td>
        <div class="button-group"> 
           <a href="<%=basePath%>system/admin/alert/${admin.id}" name="update" ><span class="icon-pencil-square-o" style="color: blue;"></span></a>&nbsp;&nbsp;
           <a href="javascript:void(0)" name="del" value="${admin.id}"><span class="icon-trash-o" style="color: red;"></span></a>
         </div>
      </td>
     </tr>
   </c:forEach>
   <tr>
      <td colspan="1">
      <button type="button" class="icon-check" id="del_all" onclick="check_all()">全部选择</button>
       
      </td>
      <td colspan="1">
         <button type="button" class="icon-trash-o" id="del_all" onclick="delAll()">批量删除</button>
      </td>
      <td  colspan="50">
         <div class="pagelist">
         <input type="hidden" name="pageNumber" id="pageNumber" value="">
         <c:choose>
            <c:when test="${admins.pageNumber>1}">
                <a href="javascript:pageChange(${admins.pageNumber-1})">上一页</a>
            </c:when>
            <c:otherwise>
                <a href="javascript:showMessage(1)">上一页</a>
            </c:otherwise>
         </c:choose>
         <c:forEach begin="1" end="${admins.totalPage }" varStatus="page">
            <c:choose>
              <c:when test="${admins.pageNumber==page.index }">
                  <a href="javascript:pageChange(${admins.pageNumber})" style="background:#00AAEE ">${page.index}</a>
              </c:when>
              <c:otherwise>
                  <a href="javascript:pageChange(${admins.pageNumber})">${page.index}</a>
              </c:otherwise>
            </c:choose>
         </c:forEach>
         <c:choose>
           <c:when test="${admins.pageNumber<admins.totalPage}">
                <a href="javascript:pageChange(${admins.pageNumber+1})">下一页</a>
           </c:when>
           <c:otherwise>
                <a href="javascript:showMessage(${admins.totalPage})">下一页</a>
           </c:otherwise>
         </c:choose>
               <a href="javascript:pageChange(${admins.totalPage})">尾页</a>
         </div>
      </td>
   </tr>
  </table>
  </form>
</body>
</html>