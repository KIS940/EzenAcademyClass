<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% 
	request.setCharacterEncoding("utf-8");	
	%>
	<jsp:useBean id="itemBean" class="com.mission.javabeans.ItemBean" />
	<jsp:setProperty property="*" name="itemBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>입력 완료된 정보</h2>
	<table>
		<tr>
			<td>상품명</td>
			<td><jsp:getProperty property="name" name="itemBean"/></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><jsp:getProperty property="price" name="itemBean"/></td>
		</tr>
		<tr>
			<td>설명</td>
			<td><jsp:getProperty property="description" name="itemBean"/></td>
		</tr>
	</table>
</body>
</html>