<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8");	%>
<jsp:useBean id="boardBean" class="com.mission.javabeans.BoardBean" />
<jsp:setProperty property="*" name="boardBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style type="text/css">
#rowstyle
{	text-align: center;  }
</style>
<body>
	<h2>입력 완료된 정보</h2>
	<table>
		<tr>
			<td>작성자</td>
			<td><jsp:getProperty property="name" name="boardBean"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><jsp:getProperty property="pass" name="boardBean"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><jsp:getProperty property="email" name="boardBean"/></td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><jsp:getProperty property="title" name="boardBean"/></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td><jsp:getProperty property="content" name="boardBean"/></td>
		</tr>
	</table>
</body>
</html>