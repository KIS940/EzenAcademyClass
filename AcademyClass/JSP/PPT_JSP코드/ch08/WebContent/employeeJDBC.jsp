<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pass="tiger";
	String sql = "SELECT * FROM EMPLOYEE";
%>
<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url,uid,pass);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	
	out.println("<table width='800' border='1'>");
	while(rs.next())
	{
		out.println("<tr>");
		out.println("<td>"+rs.getString("name")+"</td>");
		out.println("<td>"+rs.getString("address")+"</td>");
		out.println("<td>"+rs.getString("ssn")+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
} catch(Exception e)
{
	e.printStackTrace();
} finally{
	try{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	} catch(Exception e)
	{
		e.printStackTrace();
	}
}
%>
</body>
</html>