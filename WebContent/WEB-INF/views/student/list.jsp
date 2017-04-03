<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath %>resource/css/index/pintuer.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/admin.css">
<link rel="stylesheet" href="<%=basePath %>resource/css/index/layui.css"> 
<script type="text/javascript" src="<%=basePath %>resource/js/jquery/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=basePath %>resource/js/jquery.js"></script>
<script src="<%=basePath %>resource/js/pintuer.js"></script>
<script type="text/javascript"> 
	$(function(){
		/*
		单条删除学生信息
        */
      
        $("a[name='del']").on("click",function(){
        	 var id=$(this).attr("value");
        	 layer.confirm('确定删除吗？', {
  			  btn: ['删除','取消'] //按钮
  			  }, function(){
  				$.ajax({
					   url:"<%=basePath%>student/delete",
					   type:"get",
					   dataType:"json",
					   data:{
						  "id":id,
					  },
					   success:function(data){
						  
						   if(data.code!=-1){
							   alert(data.message);
							   location.href="<%=basePath%>student/Paginate"
						   }
					   },
					   error:function(){
						   alert("系统异常,请联系管理员");
					   }
				   });
  			}, function(){
  				return;
  			});
  	  });
       
	/**分页查询
	*/
	
		/***
		 Excel数据导出
		*/
		$("#export").click(function(){
			$("#form").attr("action","<%=basePath%>student/Export/");
			$("#form").submit();
		});
		$(".btn_search").click(function(){
			$("#form").attr("action","<%=basePath%>student/Paginate/");
			$("#form").submit();
		});
		
		
   });
	function showMessage(number){
		if(number==1){
			alert("已经是第一页了!");
		}else{
			alert("已经是最后一页了!");
		}
	}
	
	function add(){
		location.href="<%=basePath%>student/add";
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
			url:"<%=basePath%>student/deleteByIds",
			data:{
				"ids":ids
				},
		    type:"post",
		    dataType:"json",
		    success:function(data){
				if(data.code!=-1){
					alert(data.message);
					location.href="<%=basePath%>student/Paginate";
		        }
		    }
		  });
			}
		}else{
			return false;
		}
	}
	/*分页查询*/
	function changePage(pageNumber){
		$("#next").val(pageNumber);
		$('#form').submit();
	}
	function check_all(){
		if($("input[type='checkbox']").is(':checked')){
			$("input[type='checkbox']").attr("checked",false);
			$(this).html("全部选中");
		}else{
			$("input[type='checkbox']").attr("checked",true);
			$(this).html("取消选中");
		}
		
	}
</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  <div class="padding border-bottom">
   <form action="<%=basePath%>student/Paginate" id="form" method="post">
     <button type="button" class="button border-yellow" onclick="add()"><span class="icon-plus-square-o"></span> 添加学生</button>
          <span id="search">姓名:<input type="text" name="name" placeholder="姓名/地址" value="${name}"></span>
         <span id="search"> 性别:<select name="sex" id="sex">
           <option    value="">--请选择--</option>
           <option <c:if test="${sex==1 }">selected="selected"</c:if>  value="1" >男</option>
           <option <c:if test="${sex==2 }">selected="selected"</c:if>  value="2">女</option>
       </select></span>
          <sapn id="search">开始时间:<input type="text" name="start_time" value="${startTime}" onclick="WdatePicker()" style="width:115px"></span>
          <sapn id="search">结束时间:<input type="text" name="stop_time" value="${stopTime}" onclick="WdatePicker()" style="width:115px"></span>
    <button type="submit" class="btn_search">查询</button>
    <button class="export" id="export">数据导出</button>
  </div>

  <table class="table table-hover text-center">
    <tr>
      <th width="1%"><input type="checkbox"  name="student.id"></th>
      <th width="1%">序号</th>
      <th width="3%">学号</th>
      <th width="5%">姓名</th>
      <th width="2%">年龄</th>
	  <th width="3%">性别</th>
	  <th width="5%">班级</th>
	  <th width="3%">职务</th>
	  <th width="5%">联系电话</th>
	  <th width="7%">入学时间</th>
	  <th width="8%">家庭地址</th>
      <th width="10%">操作</th>
    </tr>
    <c:forEach items="${students.list}" var="student" varStatus="status" >
	    <tr>
	       <td><input type="checkbox" name="all" value="${student.id}"></td>
	       <td>${student.id}</td>
	       <td>${student.number}</td>
	       <td>${student.name}</td>
	       <td>${student.age}</td>
	       <c:choose >
	          <c:when test="${student.sex==1}">
	             <td>男</td>
	          </c:when> 
	          <c:otherwise>
	             <td>女</td>
	          </c:otherwise>
	       </c:choose>
	       <td>${student.grade}${student.s_class}班</td>
	       <c:choose >
	          <c:when test="${student.office==''}">
	             <td>无</td>
	          </c:when> 
	          <c:otherwise>
	             <td>${student.office}</td>
	          </c:otherwise>
	       </c:choose>
	       <td>${student.tel}</td>
	       <td>${student.join_school_time}</td>
	       <td>${student.address}</td> 
	       <td>
	          <a href="<%=basePath%>student/alert/${student.id}" name="alert" value="${student.id}"   target="right"><input type="button" value="修改" id="btn"></a> |
	          <a name="del"  value="${student.id}"> <input type="button" value="删除" class="btn"></a> 
	       </td> 
	    </tr>
    </c:forEach>
      <tr>
      <td colspan="1">
      <button type="button" class="icon-check" id="del_all" class="all" onclick="check_all()">全部选择</button>
       
      </td>
      <td colspan="1">
         <button type="button" class="icon-trash-o" id="del_all"  onclick="delAll()">批量删除</button>
      </td>
        <td colspan="50">
          <div class="pagelist" > 
          <input type="hidden" id="next" name="pageNumber">
          <c:if test="${students.totalPage>0}">
          <c:choose>
             <c:when test="${students.pageNumber>1}">
                <a href="javascript:changePage(${students.pageNumber-1})">上一页</a> 
             </c:when>
             <c:otherwise>
                <a href="javascript:showMessage(1)">上一页</a> 
             </c:otherwise>
          </c:choose>
          <c:forEach begin="1" end="${students.totalPage}" varStatus="page">
               <c:choose>
                 <c:when test="${students.pageNumber==page.index }">
                    <a href="javascript:changePage(${page.index})" style="background:#00AAEE ">${page.index}</a>
                 </c:when>
                 <c:otherwise>
                     <a href="javascript:changePage(${page.index})">${page.index}</a>
                 </c:otherwise>
               </c:choose>
            </c:forEach>
        <c:choose>
           <c:when test="${students.pageNumber<students.totalPage}">
              <a href="javascript:changePage(${students.pageNumber+1})">下一页</a>
           </c:when>
           <c:otherwise>
              <a href="javascript:showMessage(${students.totalPage})">下一页</a>
           </c:otherwise>
       </c:choose>
           <a href="javascript:changePage(${students.totalPage})">尾页</a> 
           </div></td>
       </c:if>
       </tr>
  </table>
     </form> 
</body>
</html>