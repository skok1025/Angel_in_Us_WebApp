<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	th{
		background-color: gray;
		color: white;
		font-size: 0.9em;
	}
</style>

<script>


	$(document).ready(function(){
		$("#addproductbtn").click(function(){
			
			$.ajax({
				type:"post",
				url:"/spring/addproductok.action",
				data:$("#addform").serialize(),
				enctype: 'multipart/form-data',
				processData: false,  // Important!
		        contentType: false,
		        cache: false,
				success:function(result){
					console.log(result);
					if(result == 1){
						alert("상품 등록성공!");
						location.href="/spring/admin.action";
					} else{
						alert("상품 등록실패!");
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
			<h2>엔젤리너스 상품등록</h2>
			
			<img alt="로고" src="/spring/resources/img/main.jpg" style="width: 150px; margin-left: 80px;">
			
			<form id="addform" enctype="multipart/form-data">
				<select id="iscoffee" name="iscoffee">
					<option value="1">Coffee</option>
					<option value="0">Beverage</option>
				</select>
				<input type="file" id="attach" name="attach"/>
				<input type="text" id="menu" name="menu"/>
				<input id="addproductbtn" type="button" value="등록하기" />
			</form>
		</div>
		<div data-role = "footer">
			<h3>엔젤리너스</h3>
			<a href="tel:010-2626-8234" data-role="button" data-icon="phone" style="margin-left: 130px;">전화걸기</a>
		</div>
	</div>
</body>
</html>