<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="UTF-8">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<title>Justified Nav Template for Bootstrap</title>

<link rel="stylesheet"
	href="../dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../dist/css/justified-nav.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/js/bootstrap.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
<style type="text/css"></style>
</head>

<body>
	
	<div class="container">
		<div class="logo">
		<%@ include file="/WEB-INF/view/member/login.jsp" %>
		</div>
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
		<h7>bookList</h7>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<c:forEach var="bookVO" items="${bookList}">
			<div class="list col-sm-6 col-md-3">
				 <img src="${bookVO.getImage()}" alt="..." data-bno='${bookVO.getBno()}'>				
			</div>
			</c:forEach>
			
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

<script>

	$(document).ready(function(){
		
		$('.list').click(function(event){
			
			console.log(event.target);
			var bno = $(event.target).data('bno');
			console.log(bno);
			window.location.href = "/book/bookDetail?bno="+bno;
		});
	
	});
	
</script>

</body>
</html>