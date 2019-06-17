<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<title></title>

<style>

</style>

<script>


	$(document).ready(function(){
		$("#loginbt").click(function(){
			$.ajax({
				type:"post",
				url:"/spring/logincheck.action",
				data:"id="+$("#txtid").val()+"&pw="+$("#txtpw").val(),
				success:function(result){
					console.log(result);
					if(result == 1){
						location.href = "/spring/index.action";
					} else{
						alert("로그인 실패");
					}
				},
				error:function(a,b,c){
					console.log(a+b+c);
				}
			});
		});	
	
	});
</script>


</head>
<body>
	<div data-role = "page">
		<div data-role = "header">
			<h1>Page</h1>
		</div>
		<div role="main" class = "ui-content">
			<h2>엔젤리너스 로그인</h2>
			
			<img alt="로고" src="/spring/resources/img/anjel.png" style="width: 150px; margin-left: 80px;">
			
			<form id="loginform" action="/spring/loginok.action" method="post">
				<ul data-role="listview" data-inset="true">
					<li data-role="fieldcontain">
						<label for="txtid">ID:</label>
						<input type="text" id="txtid" name="id"/>
					</li>
					<li data-role="fieldcontain">
						<label for="txtpw">PW:</label>
						<input type="password" id="txtpw" name="pw" />
					</li>
					<li data-role="fieldcontain">
						<input id="loginbt" type="button" value="로그인" />
						
					</li>
				</ul>
			</form>
			<a style="width: 100px; margin-bottom: 80px; margin-left: 10px;" onclick="location.href='/spring/admin.action';" class="ui-btn ui-btn-inline ui-icon-user ui-btn-icon-left">ADMIN</a>
		</div>
		<div data-role = "footer">
			<h3>엔젤리너스</h3>
			<a href="tel:010-2626-8234" data-role="button" data-icon="phone" style="margin-left: 130px;">전화걸기</a>
		</div>
	</div>
</body>
</html>