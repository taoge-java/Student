<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${page.list}" var="student" varStatus="status" >
    <tr>
       <td><input type="checkbox" name="all" value="${student.id}"></td>
       <td>${student.id}</td>
       <td>${student.password}</td>
       <td>${student.name}</td>
    </tr>
</c:forEach>