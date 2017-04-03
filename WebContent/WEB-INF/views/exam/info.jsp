<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
	  $("#btn_submit").click(function(){
		  var subject_ids="";
		  $("input[type='checkbox']").each(function(){
			  if(this.checked){
				  subject_ids+=this.value+",";
			  }
		  });
		  $("input:hidden").val(subject_ids);
		  $.post("<%=basePath%>exam/save",
				$("#exam_info").serialize(),function(data){
					  if(data.code!=-1){
					    	 layer.alert(data.message, {
			  					  icon: 1,
			  					  skin: 'layer-ext-moon',
			  					})
					   }else{
					    	 layer.alert(data.message, {
			  					  icon: 2,
			  					  skin: 'layer-ext-moon',
			  				 })
					    }
		        },"json");
		 });
  });
</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 添加考试信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" id="exam_info" >
    <input type="hidden" name="subject_ids" value=""> 
      <div class="form-group">
        <div class="label">
          <label for="sitename">考试信息：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="examInfo.title" size="50" placeholder="请输入考试信息" data-validate="required:请输入考试信息" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="start">开始时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" onclick="WdatePicker()" name="examInfo.start_time" size="50" placeholder="请输入开始时间" data-validate="required:请输入开始时间" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="stop">结束时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" onclick="WdatePicker()" name="examInfo.stop_time" size="50" placeholder="请输入结束时间" data-validate="required:请输入结束时间" />          
        </div>
      </div>
      <div class="form-group">
          <div class="label">
            <label>考试科目：</label>
          </div>
          <div class="field" style="padding-top:8px;">
          <c:forEach items="${list}" var="list">
             <input id="ishome"  type="checkbox" value="${list.id}"/> ${list.subject_name }
          </c:forEach>
		     
          </div>
        </div>
      <div class="form-group">
        <div class="label">
          <label for="stop">备注：</label>
        </div>
        <div class="field">
           <textarea rows="10" cols="60" name="examInfo.remark"></textarea>
        </div>
      </div>
       <div class="field" style="margin-left:150px; ">
          <button class="button bg-main icon-check-square-o" id="btn_submit"  type="button"> 提交</button>   
       </div>
     
    </form>
  </div>
</div>
</body>
</html>