<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
${param.userid}
님 
<c:choose>
	<c:when test="${param.admin == 1}">사용자로</c:when>
	<c:otherwise>관리자로</c:otherwise>
</c:choose>
로그인하셨습니다.
</body>
</html>