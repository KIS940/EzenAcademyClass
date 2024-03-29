<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
<c:set var="number" value="1234567.89"></c:set>
\${number} : ${number}
<fmt:formatNumber value="${number}" />
<fmt:formatNumber value="${number}" groupingUsed="false" />
<fmt:formatNumber value="0.5" type="percent" />
<fmt:formatNumber value="10000" type="currency" />
<fmt:formatNumber value="10000" type="currency" currencySymbol="$" />
<fmt:formatNumber value="1234567.8912345" pattern="#,#00.0#" />
<fmt:formatNumber value="1234567.8" pattern="#,#00.0#" />
<fmt:formatNumber value="1234567.89" pattern=".000" />
	</pre>
</body>
</html>