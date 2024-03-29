<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<h2>정보 입력 폼</h2>
		<form method="post" action="itemWriteResult.jsp">
			<table>
				<tr>
					<td id="rowstyle">상품명</td>
					<td><input type="text" name="name"></td>

				</tr>
				<tr>
					<td id="rowstyle">가격</td>
					<td><input type="text" name="price"></td>
				</tr>
				<tr> 
					<td id="rowstyle" height="100px">설명</td>
					<td>
					<textarea cols="80" rows="10" name="description"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="전송">
						<input type="reset" value="취소">
					</td>
				</tr>
				<tr>
			</table>
			
		</form>
</body>
</html>