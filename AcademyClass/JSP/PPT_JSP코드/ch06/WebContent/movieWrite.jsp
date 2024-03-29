<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% 
	request.setCharacterEncoding("utf-8");	
	%>
	<jsp:useBean id="movieBean" class="com.mission.javabeans.MovieBean" />
	<jsp:setProperty property="*" name="movieBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#rowstyle
{
	text-align: center;
	font-weight: bol;
}
</style>
</head>
<body>
	<h2>입력 완료된 정보</h2>
	<table>
		<tr>
			<td id="rowstyle">제목</td>
			<td><jsp:getProperty property="title" name="movieBean"/></td>
		</tr>
		<tr>
			<td id="rowstyle">가격</td>
			<td><jsp:getProperty property="price" name="movieBean"/></td>
		</tr>
		<tr>
			<td id="rowstyle">감독</td>
			<td><jsp:getProperty property="director" name="movieBean"/></td>
		</tr>
		<tr>
			<td id="rowstyle">출연배우</td>
			<td><jsp:getProperty property="actor" name="movieBean"/></td>
		</tr>
		<tr>
			<td id="rowstyle">시놉시스</td>
			<td><jsp:getProperty property="synopsis" name="movieBean"/></td>
		</tr>
		<tr>
			<td id="rowstyle">장르</td>
			<td><jsp:getProperty property="genre" name="movieBean"/></td>
		</tr>
	</table>
</body>
</html>