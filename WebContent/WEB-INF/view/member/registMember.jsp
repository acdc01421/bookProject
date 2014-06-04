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
<script src="/library/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/library/dist/css/justified-nav.css">
<link rel="stylesheet" href="/library/dist/css/bootstrap.min.css">
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
			<h7>registMember</h7>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<form action="/library/member/registMember" method="POST" class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-lg-2 control-label">ID</label>
					<div class="col-lg-4">
						<input type="text" class="form-control" name = 'id' id="id"
							placeholder="ID" value="user44">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label">Password</label>
					<div class="col-lg-4">
						<input type="password" class="form-control" name = 'pw' id="pw"
							placeholder="Password" value="user44">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label">Name</label>
					<div class="col-lg-4">
						<input type="text" class="form-control" name = 'name' id="name"
							placeholder="Name" value="백유저">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label">Hp</label>
					<div class="col-lg-4">
						<input type="text" class="form-control" name='phone' id="HP"
							placeholder="HP" value="2084720">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-4" align="right">
						<button type="submit" class="btn btn-default">등 록</button>
					</div>
				</div>
			</form>
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