<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시판 글쓰기</title>
<style type="text/css">
#rowstyle{
	font-weight: bold;
	text-align: center;
}
</style>
</head>
<body>
	<center>
		<h2>게시판 글쓰기</h2>
		<form method="post" action="movieWrite.jsp">
			<table>
				<tr>
					<td id="rowstyle">제목</td>
					<td><input type="text" name="title"></td>

				</tr>
				<tr>
					<td id="rowstyle">가격</td>
					<td><input type="text" name="price">원</td>
				</tr>
				<tr>
					<td id="rowstyle">감독</td>
					<td><input type="text" name="director"></td>
				</tr>
				<tr>
					<td id="rowstyle">출연배우</td>
					<td><input type="text" name="actor"></td>
				</tr>
				<tr>
					<td id="rowstyle" height="100px">시놉시스</td>
					<td>
					<textarea cols="80" rows="20" name="synopsis"></textarea>
					</td>
				</tr>
				<tr>
					<td id="rowstyle">장르</td>
					<td>
					<select name="genre">
						<option value="로맨스">로맨스</option>
						<option value="스릴러">스릴러</option>
						<option value="미스터리">미스터리</option>
						<option value="액션" selected="selected">액션</option>
						<option value="코미디">코미디</option>
						<option value="애니메이션">애니메이션</option>
					</select>
					</td>
				<tr>
			</table>
			<input type="submit" value="등록">
			<input type="reset" value="다시작성">
		</form>
	</center>
</body>
</html>