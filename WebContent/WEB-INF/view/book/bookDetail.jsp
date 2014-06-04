<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
		
		
		$("#gotoMain").click(function(){
			window.location.href = "/book/list";
		});
		
		
	});
</script>
<script>
	function doResize(obj) {
		var Body, H;
		var Min = 200;
		Body = (obj.contentWindow.document.getElementsByTagName('BODY'))[0];
		H = parseInt(Body.scrollHeight) + 5;
		obj.style.height = (H < Min ? Min : H) + 'px';
		window.scroll(1, 1);
	}
</script>
</head>

<body>

	<div class="container">
		<%@ include file="/WEB-INF/view/member/login.jsp" %>
		<div class="masthead">
			<h3 class="text-muted">Project name</h3>
			<ul class="nav nav-justified">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Projects</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="#">Downloads</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</div>

		<!-- Jumbotron -->
		<div class="jumbotron">
			<h7>bookDetail</h7>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="table-responsive col-lg-12">
				<table>
					<thead>
						<tr>
							<th colspan="6">${bookVO.getTitle()}</th>
						</tr>
					</thead>
					<tr>
						<td width="200" align="center"><img
							src="${bookVO.getImage()}"
							class="img-thumbnail"></td>
						<td>
							<dl class="dl-horizontal">
								<dt>저자:</dt>
								<dd>${bookVO.getAuthor()}</dd>
								<dt>출간일:</dt>
								<dd>${bookVO.getpYear()}</dd>
								<dt>ISBN-13:</dt>
								<dd>${bookVO.getIsbn()}</dd>
								<dt>소개:</dt>
								<dd>${bookVO.getDescription()}</dd>
								<dt>출판사:</dt>
								<dd>${bookVO.getPublisher()}</dd>
								<dt>카테고리:</dt>
								<dd>${bookVO.getCategory()}</dd>
								<dt>상태:</dt>
								<dd>${bookVO.getStatus()}</dd>
							</dl>
						</td>

					</tr>


				</table>
				<!-- comment table -->
				<br />
				<iframe src="/book/comment?bno=${bookVO.getBno()}" width="100%" scrolling="no"
					frameborder="0" onload="doResize(this)"></iframe>
				<div align="right">
				<form action = "/book/borrow" method = "post">
					<input type = "hidden" name = "bno" value = "${bookVO.getBno()}" >
					<button type="submit" class="btn btn-info" id = "borrow">대여</button>
				</form>
					<button type="button" class="btn btn-info" id = "gotoMain">메인으로</button>
				</div>
			</div>
		</div>

		<!-- Site footer -->
		<div class="footer">
			<p>© 합정역 4번 출구 2014</p>
		</div>
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->


</body>
</html>