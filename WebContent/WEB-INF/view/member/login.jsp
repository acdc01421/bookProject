<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.id == null}">
			<form action="/member/login" method="post">
				<div style="width: 20%; float: left;">
					<div style="width: 65%; float: left;">
						<p style="margin-bottom: 0px;">
							&nbsp;&nbsp;ID : <input type="text" name="id">
						</p>
						<p style="margin-top: 10px;">
							PW : <input type="password" name="pw">
						</p>
					</div>
					<div style="width: 30%; float: left; margin-top: 5%;">
						<input type="submit" value="Login"
							style="width: 50px; height: 60px;">
					</div>
				</div>
				<div
					style="width: 20%; float: left; margin-top: 5%; margin-left: -20%;">
					<input type="button" value="sign up"
						style="width: 48%; margin-left: 13%;">
				</div>
			</form>
		</c:when>

		<c:otherwise>
			<form>
				<div style="float: left;">
					<div style="float: left; margin-top: 10%; margin-left: 13%;">
						<div style="float: left; margin-top: 7%;">
							<p>
								<label>${sessionScope.name}님반갑습니다.</label>
							</p>
						</div>
						<div style="float: left; margin-top: 7%; margin-left: 5%;">
							<input class="logout" type="submit" value="LogOut"
								style="width: 55px; height: 65px;" data-logout=<%session.invalidate();%>'>
						</div>
						<div style="float: left; margin-left: 1%; margin-top: 5%;">
							<input class="mypage" type="button" value="My Page" style="width: 85px;" data-user='${id}'>
							<input type="button" value="Mail List" style="width: 85px">
						</div>
					</div>
				</div>
			</form>
		</c:otherwise>
	</c:choose>

<script>
$(document).ready(function(){
	
	$(".logout").click(function(){
		$(this).data('logout');
		window.location.href = "/book/list";
	});
	$(".mypage").click(function(){
		var id = $(this).data('user');
		window.location.href = "/member/myPage?id="+id;
	});
	
});
</script>
</body>
</html>