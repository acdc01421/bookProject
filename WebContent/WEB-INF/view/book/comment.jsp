<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<title>Justified Nav Template for Bootstrap</title>

<link rel="stylesheet" href="../dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../dist/css/justified-nav.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/js/bootstrap.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="../../assets/js/html5shiv.js"></script>
    <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
<style type="text/css"></style>
<script>
	$(document).ready(function() {
		$(".table tbody>tr>td").css("vertical-align", "middle");
		$("table").css("margin-bottom", "10px");

	});
</script>
</head>

<body style="padding-top: 0px;">


	<!-- Example row of columns -->
	<div class="row">
		<div class="table-responsive col-lg-12">
			<table class="table">
				<thead>
					<tr>
						<th colspan="6">comment</th>
					</tr>
				</thead>
				<tr>
					<td width="8%" align="center">작성자</td>
					<td width="82%" align="center">글내용</td>
					<td width="10%" align="center">평점</td>
				</tr>

				<c:forEach var="commentVO" items="${commentList}">
					<tr>
						<td align="center">${commentVO.getId()}</td>
						<td align="left">${commentVO.getContent()}&nbsp;<font
							size="1" color="#9A9A9A">${commentVO.getRegDate()}</font></td>
						<td align="left">${commentVO.getScore()}</td>
					</tr>


				</c:forEach>

			</table>
			<div class="pnum" style="text-align: center">
				<c:forEach var="pageNumber" items="${pageNumberList}">
				
					<h7 data-pageNum='${pageNumber}'>${pageNumber}</h7>
					
				</c:forEach>
			</div>

			<form action="/book/comment" method="post"
				class="form" role="form">
				<input type="hidden" name = "bno"  value="${bno}"/>
				<div class="form-group">
					<textarea class="form-control" rows="3" name="content"
						placeholder="Write a comment..."></textarea>
				</div>

				<select class="form-control" id="starSelect" name="score">
					<option name="score" selected="selected">★</option>
					<option name="score">★★</option>
					<option name="score">★★★</option>
					<option name="score">★★★★</option>
					<option name="score">★★★★★</option>
				</select> </br>
				<div align="left">
					<button type="submit" class="btn btn-default">전송</button>
				</div>
			</form>

		</div>
	</div>
	<script>
		console.log('${currentPnum}');
		$('.pnum').click(function(event) {
			var pno = $(event.target).data('pagenum');
			console.log(pno);
			if (pno == '>') {
				pno = ${currentPnum}+1;
				console.log(pno);
			} else if (pno == '<') {
				pno = ${currentPnum}-1;
			}
			
			window.location.href = "/book/comment?bno=" + ${bno}+"&pageNum=" + pno;
		});
	</script>


</body>
</html>