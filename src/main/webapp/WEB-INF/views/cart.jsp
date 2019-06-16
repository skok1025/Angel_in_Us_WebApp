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
	.cartitem{
		width: 100%;
		height: 100px;
		border: 1px solid gray;
		
		position: relative;
	}
	
	.cartitem > a{
		position: absolute;
		bottom: 0px;
		right: 0px;
		
		
	}
	
	.cartitem > #img{
		width: 60px;
		height: 70px;
		float: left;
	}
	
	.cartitem > div{
		float: left;
	}
	
	.optionlist{
		width: 150px;
		height: 50px;
		border: 0px solid;
		
		position: absolute;
		top: 0px;
		right: 0px;
	}
</style>

<script>


	$(document).ready(function(){
		$("#paybtn").click(function(){
			$.ajax({
				type:"get",
				url:"/spring/pay.action",
				success:function(result){
					if(result>=1){
						alert("구매 성공");
						location.href="/spring/index.action";
					} else{
						alert("구매 실패");
					}
				},
				error:function(a,b,c){
					console.log(a+b+c);
				}
			});
			
		});
		
		
		$(".delbtn").click(function(){
			//alert(this.dataset.orderseq);
			 $.ajax({
				type:"get",
				url:"/spring/delorder.action",
				data:"orderseq="+this.dataset.orderseq,
				success:function(result){
					if(result==1){
						alert("삭제 성공");
						location.reload();
					} else{
						alert("삭제 실패");
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
			<h2>나의 장바구니</h2>
			
			<img alt="로고" src="/spring/resources/img/main.jpg" style="width: 150px; margin-left: 80px;">
			
			<c:forEach items="${orderlist}" var="odto">
			<div class="cartitem">
				<img id="img" src="/spring/files/${odto.image }"/>
				<div>
					<div>X ${odto.count }</div>
					<span>${odto.menu }</span>
					<div>총 금액: ${odto.payment }원</div>
					
				</div>
				<div class="optionlist">
					옵션:
					<c:forEach items="${optionlist}" var="optiondto">
						<c:if test="${optiondto.orderseq eq odto.seq}">
							${optiondto.optionname },
						</c:if>
					</c:forEach>
				</div>
				<a  data-orderseq="${odto.seq}" class="delbtn ui-btn ui-btn-inline ui-icon-delete ui-btn-icon-left">삭제</a>
			</div>
			</c:forEach>
			<input id="paybtn" type="button" value="${totalprice}원 결제" />
		</div>
		<div data-role = "footer">
			<h3>엔젤리너스</h3>
			<a href="tel:010-2626-8234" data-role="button" data-icon="phone" style="margin-left: 130px;">전화걸기</a>
		</div>
	</div>
</body>
</html>