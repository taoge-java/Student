<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>学生信息后台管理系统</title>  
    <link rel="stylesheet" href="<%=basePath %>resource/css/index/pintuer.css">
    <link rel="stylesheet" href="<%=basePath %>resource/css/index/admin.css">
    <script src="<%=basePath %>resource/js/jquery/jquery.js"></script>   
    <script src="<%=basePath %>resource/js/index.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h4><img src="<%=basePath %>resource/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />欢迎您${user.loginName}</h4>
  </div>
  <div class="head-l">
  <a class="button button-little bg-red" href="<%=basePath%>login/exit"><span class="icon-power-off"></span> 退出登录</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp; 
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<h1 style="float: right;color:#F5F5F5;font-size: 28px;">学生信息管理中心</h1>
  </div>
   <div class="logo margin-big-right fadein-right" style="float:right;">
      <span style="font-size: 18px;" id="time"></span>
   </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  
  <h2><span class="icon-user"></span>学生管理</h2>
  <ul style="display:block">
      <li><a href="<%=basePath %>student" target="right"><span class="icon-caret-right"></span>录入学生信息</a></li>
      <li><a href="<%=basePath %>student/Paginate" target="right"><span class="icon-caret-right"></span>学生信息管理</a></li>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>考试管理</h2>
  <ul>
    <li><a href="<%=basePath %>exam" target="right"><span class="icon-caret-right"></span>考试信息管理</a></li>
    <li><a href="<%=basePath%>exam/add" target="right"><span class="icon-caret-right"></span>学生成绩管理</a></li>
    <li><a href="<%=basePath%>subject" target="right"><span class="icon-caret-right"></span>学科管理</a></li>
  </ul>  
  <h2><span class="icon-gear"></span>系统设置</h2>
  <ul>
      <li><a href="<%=basePath%>set" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
      <li><a href="<%=basePath%>system/admin" target="right"><span class="icon-caret-right"></span>管理员管理</a></li>
      <li><a href="<%=basePath%>system/role" target="right"><span class="icon-caret-right"></span>角色管理</a></li>
      <li><a href="<%=basePath%>set/person" target="right"><span class="icon-caret-right"></span>个人设置</a></li>
      <li><a href="<%=basePath%>set/person" target="right"><span class="icon-caret-right"></span>操作日志管理</a></li>
  </ul> 
   
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script> 
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="<%=basePath %>student/add" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>
