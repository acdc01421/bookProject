<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
			<h7>registBook</h7>
		</div>
		<form action = "/book/registBook" method = "post">
		<div class="row" align="center">
		
				<img src="http://dimg.donga.com/ugc/DKBNEWS/bbs_bestphoto/53/54/7b/ef/53547bef0249d2738289.jpg" 
				     width="150" height="200" align = "middle" hspace="5" vspace="5">
				
					<div>
						<p style="margin-bottom: 0px;">
							&nbsp;&nbsp;ISBN : <input type="text" name="isbn">
						</p>
						
						</div>
		</div>

		<!-- Example row of columns -->
		<div align="right">
				<button type="submit" class="btn btn-info">등록하기</button>
				<button type="button" class="btn btn-info">목록으로</button>
		
			</div>
		</div>
	</form>	

		<!-- Site footer -->
		<div class="footer">
			<p>© 합정역 4번출구 2014</p>
		</div>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->


</body>
</html>