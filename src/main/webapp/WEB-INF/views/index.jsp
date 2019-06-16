<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<title></title>

<style>

	.item{
		width: 140px; height: 170px; margin:10px; float:left; border: 1px solid;
		box-shadow: 5px 5px #888888;
		cursor: pointer;
	}
	
	.item > img{
		width: 140px;
		height: 140px;
		
	}
	
	.item > span {
		font-weight:bold;
		border: 0px solid red;
	}
</style>

<script type="text/javascript">

	$(document).ready(function(){
		$("#coffeebt").change(function(){
			//alert("커피");
			$("#items").html("");
			$.ajax({
				type:"get",
				url:"/spring/getmenulist.action",
				data:"iscoffee=1",
				success:function(result){
					console.log(result);
					$(result).each(function(index,item){
						var div = "<div class=\"item\" onclick=\"location.href = '/spring/view.action?menuseq="+item.seq+"';\"><img src='/spring/files/"+item.image+"' /><span>"+item.menu+"</span></div>"
						$("#items").append(div);
					});
				},
				error:function(a,b,c){
					console.log(a+b+c);
				}
			});
		});
		
		$("#beveragebt").change(function(){
			//alert("음료수");
			$("#items").html("");
			$.ajax({
				type:"get",
				url:"/spring/getmenulist.action",
				data:"iscoffee=0",
				success:function(result){
					console.log(result);
					$(result).each(function(index,item){
						var div = "<div class=\"item\" onclick=\"location.href = '/spring/view.action?menuseq="+item.seq+"';\"><img src='/spring/files/"+item.image+"' /><span>"+item.menu+"</span></div>"
						$("#items").append(div);
					});
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
	<div data-role="page">
		<div data-role="header">
			<h1>Page</h1>
		</div>
		<div role="main" class="ui-content">
			<img alt="로고" src="/spring/resources/img/main.jpg"
				style="width: 130px; margin-left: 80px;">
			<a style="width: 40px; margin-bottom: 80px; margin-left: 10px;" onclick="location.href='/spring/cart.action';"   class="ui-btn ui-btn-inline ui-icon-user ui-btn-icon-top">카트</a>
			<fieldset data-role="controlgroup" data-type="horizontal"  style="margin-top: -70px;">
				        
				
				 <input type="radio" name="radio-choice-h-2" id="coffeebt" value="on" checked="checked">
				 <label for="coffeebt">Coffee</label>        
				 <input type="radio" name="radio-choice-h-2" id="beveragebt" value="off">         
				 <label for="beveragebt">Beverage</label>
				            
			</fieldset>

			<div id="items">
			<c:forEach items="${list}" var="dto">
				<div class="item" onclick="location.href = '/spring/view.action?menuseq=${dto.seq}';">
					<img src="/spring/files/${dto.image }" alt="" />
					<span>${dto.menu }</span>
				</div>
			</c:forEach>
			</div>

		</div>
		<div data-role="footer">
			<h3>엔젤리너스</h3>
			<a href="tel:010-2626-8234" data-role="button" data-icon="phone"
				style="margin-left: 130px;">전화걸기</a>
		</div>
	</div>
</body>
</html>