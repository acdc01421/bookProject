<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="utf-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="../dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../dist/css/justified-nav.css">
<link rel="stylesheet" href="../dist/css/bootstrap.min.css">
<title>Insert title here</title>
</head>

<body>

	<div class="container">

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
		<h7>myPage</h7>
		</div>

		<!-- Example row of columns -->
		<div class="row">
		<div class="table-responsive col-lg-12">
				<table class="table table-bordered table-condensed">
					<thead>				
						<tr>
							<th colspan="6">대출목록</th>
						</tr>
					</thead>
					<tr>
						<td class="success" width="100" align="center">대출번호</td>
						<!--  <td class="success" width="150" align="center">대출자이름</td>-->
						<td class="success" width="300" align="center">책이름</td>
						<td class="success" width="150" align="center">대여날짜</td>
						<td class="success" width="150" align="center">반납날짜</td>
					</tr>

				</table>
			</div>
			<div class="table-responsive col-lg-12">
				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th colspan="6">예약목록</th>
						</tr>
					</thead>
					<tr>
						<td class="success" width="100" align="center">예약번호</td>
						<!--<td class="success" width="150" align="center">예약자이름</td>-->
						<td class="success" width="300" align="center">책이름</td>
						<td class="success" width="150" align="center">반납날짜</td>
						<td class="success" width="150" align="center">예약가능날짜</td>
					</tr>

				</table>
			</div>
			<!--  <div align="right">
				<button type="button" class="btn btn-info">반납하기</button>
				<button type="button" class="btn btn-info">새책등록</button>
			</div>-->
		
		
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