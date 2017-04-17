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
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath %>resource/css/index/pintuer.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/admin.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/layui.css"> 
<link rel="stylesheet" href="<%=basePath %>resource/js/layer/skin/default/layer.css">
<script type="text/javascript" src="<%=basePath%>resource/js/jquery/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/add.js"></script>
<style type="text/css">
  a:hover{
    font-size: 18px;
  }
</style>
<script type="text/javascript">
	/**
	 * 添加角色
	 */
    function add(){
		location.href="<%=basePath%>system/role/add";
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
   /**
         分页
   **/
   function pageChange(pageNumber){
	   $("#pageNumber").val(pageNumber);
	   $("#data-form").submit();
   }
   function datasubmit(){
	   $("#data-form").submit();
   }
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
			url:"<%=basePath%>system/role/delAll",
			data:{
				"ids":ids
				},
		    type:"post",
		    dataType:"json",
		    success:function(data){
				if(data.code!=-1){
					alert(data.message);
					location.href="<%=basePath%>system/role";
		        }
		    }
		   });
		}
		}else{
			return false;
		}
   }
   $(function(){
	   $("a[name='del']").click(function(){
		   if(confirm("确定删除吗")){
			   $.ajax({
				   url:"<%=basePath%>system/role/deleteById",
				   type:"get",
				   dataType:"json",
				   data:{
					   "id":$(this).attr("value"),
				   },
				   success:function(data){
					   alert(data.message);
					   if(data.code!=-1){
						   location.href="<%=basePath%>system/role";
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
		//alert("val:"+$(".all").attr("value"));
		if($("input[type='checkbox']").is(':checked')){
			$("input[type='checkbox']").attr("checked",false);
			
		}else{
			$("input[type='checkbox']").attr("checked",true);
			
		}
	}
</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    
  <div class="padding border-bottom" style="margin-left: 80px;">
     <form action="<%=basePath%>system/role/Paginate" method="post" id="data-form">
        <button type="button" class="button bg-yellow" style="margin: 8px 0px 15px 15px;height: 40px;" onclick="add()" >
	       <span  class="icon-plus-circle">添加角色</span>
	     </button>
          <input type="text" placeholder="请输入角色名称" name="role.name" class="input" value="${role_name}"  style="width:250px; line-height:17px;display:inline-block" />
          <button class="button border-main icon-search"> 搜索</button>
   
    </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="3%"><input type="checkbox" name="id"></th>
      <th width="5%">id</th>
      <th width="8%">角色名称</th>
      <th width="8%">是否系统管理员</th>
      <th width="10%">操作</th>
    </tr>
    <c:forEach items="${roles.list}" var="role" >
    <tr>
      <td><input type="checkbox" id="role_id" name="all" value="${role.id}"></td>
      <td>${role.id}</td>
      <td>${role.role_name }</td>
      <td>
        <c:choose>
          <c:when test="${role.flag==1}">是</c:when>
          <c:when test="${role.flag==0}">否</c:when>
        </c:choose>
      </td>
      <td>
        <div class="button-group"> 
         <a href="<%=basePath%>system/role/alert/${role.id}" name="update" ><span class="icon-pencil-square-o" style="color: blue;"></span></a>&nbsp;&nbsp;
         <a href="javascript:void(0)" name="del" value="${role.id}"><span class="icon-trash-o" style="color: red;"></span></a>
        </div>
      </td>
     
    </tr>
     </c:forEach>
    <tr>
       <td >
          <button type="button" class="icon-check" id="del_all" class="all" onclick="check_all()">全部选择</button>
       
       </td>
       <td>
         <button type="button" class="icon-trash-o" id="del_all"  onclick="delAll()">批量删除</button>
       </td>
       <td colspan="50">
         <div class="pagelist">
         <input type="hidden" id="pageNumber" name="pageNumber" value="">
         <c:if test="${roles.totalPage>0}">
         <c:choose>
           <c:when test="${roles.pageNumber>1 }">
              <a href="javascript:pageChange(${roles.pageNumber-1})">上一页</a> 
           </c:when>
           <c:otherwise>
              <a href="javascript:showMessage(1)">上一页</a> 
           </c:otherwise>
         </c:choose>
            <c:forEach begin="1" end="${roles.totalPage }" varStatus="role">
               <c:choose>
                  <c:when test="${roles.pageNumber==role.index}">
                       <a href="javascript:pageChange(${role.index})" style="background:#00AAEE;">${role.index}</a>
                  </c:when>
                  <c:otherwise>
                       <a href="javascript:pageChange(${role.index})">${role.index}</a>
                  </c:otherwise>
               </c:choose>
            </c:forEach>
            <c:choose>
               <c:when test="${roles.pageNumber<roles.totalPage}">
                  <a href="javascript:pageChange(${roles.pageNumber+1})">下一页</a>
               </c:when>
               <c:otherwise>
                  <a href="javascript:showMessage(${roles.totalPage})">下一页</a>
               </c:otherwise>
             
            </c:choose>
              <a href="javascript:pageChange(${roles.totalPage})">尾页</a>
         </div> </td>   
        </c:if>
     
    </tr>
  
   
  </table>
  </form>
</body>
</html>