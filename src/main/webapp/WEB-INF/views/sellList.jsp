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
		
	
	});
</script>


</head>
<body>
	<div data-role = "page">
		<div data-role = "header">
			<h1>Page</h1>
		</div>
		<div role="main" class = "ui-content">
			<h2>엔젤리너스 관리자</h2>
			
			<img alt="로고" src="/spring/resources/img/main.jpg" style="width: 150px; margin-left: 80px;">
			<table class="table table-bordered">
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>구매상품</th>
					<th>갯수</th>
					<th>옵션</th>
					<th>결제금액</th>
				</tr>
				
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.orderseq }</td>
						<td>${dto.memberid }</td>
						<td>${dto.menu }</td>
						<td>${dto.count }</td>
						<td></td>
						<td>${dto.payment }</td>
					</tr>
				
				</c:forEach>
			</table>
		</div>
		<div data-role = "footer">
			<h3>엔젤리너스</h3>
			<a href="tel:010-2626-8234" data-role="button" data-icon="phone" style="margin-left: 130px;">전화걸기</a>
		</div>
	</div>
</body>
</html>