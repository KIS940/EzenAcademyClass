<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
java.util.List<String> seasonList = new ArrayList<String>();
seasonList.add("봄");
seasonList.add("여름");
seasonList.add("가을");
seasonList.add("겨울");
request.setAttribute("list", seasonList);
%>
<select>
<%
java.util.ArrayList list = (ArrayList)request.getAttribute("list");
int i;
for(i=0; i<list.size(); i++){
%>
<option value="<%=list.get(i)%>"> <%= list.get(i)%></option>
<%
}
%>
</select>
<hr><br><br><br><br><br><br>
<select name="season">
<c:forEach items="${list}" var="item">
<option value="${item}">${item}</option>
</c:forEach>
</select>

</body>
</html>