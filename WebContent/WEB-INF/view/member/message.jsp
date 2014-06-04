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
		<h7>myPage</h7>
		</div>

		<!-- Example row of columns -->
		<div class="row">
		
			
			
			<div class="table-responsive col-lg-12">
			 <table id="report" class="table table-bordered table-condensed">
			 
        <tr>
            <th class="success">No</th>
            <th class="success">title</th>
            <th class="success">writer</th>
            <th class="success">date</th>
            <th class="success"></th>
        </tr>
        <tr>
            <td>5</td>
            <td>자바책반납좀</td>
            <td>이현범</td>
            <td>6/4</td>
            <td><div class="arrow"></div></td>
        </tr>
        <tr>
            <td colspan="5">
                <ul>
                    <li><a href="#">본문내용1</a></li>    
                 </ul>   
            </td>
        </tr>
         <tr>
            <td>4</td>
            <td>자바책반납좀</td>
            <td>이현범</td>
            <td>6/4</td>
            <td><div class="arrow"></div></td>
        </tr>
        <tr>
            <td colspan="5">
                <ul>
                    <li><a href="#">본문내용2</a></li>    
                 </ul>   
            </td>
        </tr>
        <tr>
            <td>3</td>
            <td>자바책반납좀</td>
            <td>이현범</td>
            <td>6/4</td>
            <td><div class="arrow"></div></td>
        </tr>
        <tr>
            <td colspan="5">
                <ul>
                    <li><a href="#">본문내용3</a></li>    
                 </ul>   
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td>자바책반납좀</td>
            <td>이현범</td>
            <td>6/4</td>
            <td><div class="arrow"></div></td>
        </tr>
        <tr>
            <td colspan="5">
                <ul>
                    <li><a href="#">본문내용4</a></li>    
                 </ul>   
            </td>
        </tr>
         <tr>
            <td>1</td>
            <td>자바책반납좀</td>
            <td>이현범</td>
            <td>6/4</td>
            <td><div class="arrow"></div></td>
        </tr>
        <tr>
            <td colspan="5">
                <ul>
                    <li><a href="#">본문내용5</a></li>    
                 </ul>   
            </td>
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

 <script>  
        $(document).ready(function(){
            $("#report tr:odd").addClass("odd");
            $("#report tr:not(.odd)").hide();
            $("#report tr:first-child").show();
            
            $("#report tr.odd").click(function(){
                $(this).next("tr").toggle();
                $(this).find(".arrow").toggleClass("up");
            });
            //$("#report").jExpand();
        });
    </script>        


</body>
</html>