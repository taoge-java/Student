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
<script src="<%=basePath %>resource/js/jquery/jquery.js"></script>
<script src="<%=basePath %>resource/js/pintuer.js"></script>
<script type="text/javascript">
   $(function(){
	  $('#btn_submit').click(function(){
		  $.ajax({
			  url:"<%=basePath%>set/alterpass",
			  type:"post",
			  dataType:"json",
			  data:{
				  "mpass":$("#mpass").val(),
				  "newPass":$("input[name='newpass']").val(),
				  "renewpass":$("input[name='renewpass']").val(),
			  },
			  success:function(data){
				  if(data.code!=0){
					  alert(data.message);
				  }else{
					  alert(data.message);
					  location.href="<%=basePath%>set";
				  }
			  },
			  error:function(){
				  alert("系统异常,请联系管理员");
			  }
		  });
	  })
   })
</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改会员密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" id="passform" action="<%=basePath%>set/alterpass">
      <div class="form-group">
        <div class="label">
          <label for="sitename">管理员帐号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
           ${user.loginName }
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">原始密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="mpass" name="mpass" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="newpass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="renewpass" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />          
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-pencil-square-o" id="btn_submit"  type="button">修改</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body>
</html>