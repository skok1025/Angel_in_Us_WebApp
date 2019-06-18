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

	#heading > div{
		float: left;
	}

	#heading > div > img{
		width: 100px;
	}
	
	#ss{
		margin-top: 21px;
		
	}
	
	label > span{
		font-size: 0.8em;
	}
</style>

<script type="text/javascript">


	$(document).ready(function(){
		$("#count").change(function(){
			$("#total").html("");
			$.ajax({
				type:"get",
				url:"/spring/gettotal.action",
				data:"menusize="+$(":radio[name='menusize']:checked").val()+"&count="+$("#count").val()+"&menuseq=${dto.seq}",
				success: function(result){
					$("#total").append(result);
					$('#totalprice').val(result);
				},
				error:function(a,b,c){
					console.log(a+b+c);
				}
			});
		}); 
		
		$(":radio[name='menusize']").change(function(){
			$("#total").html("");
			$.ajax({
				type:"get",
				url:"/spring/gettotal.action",
				data:"menusize="+$(":radio[name='menusize']:checked").val()+"&count="+$("#count").val()+"&menuseq=${dto.seq}",
				success: function(result){
					$("#total").append(result);
				},
				error:function(a,b,c){
					console.log(a+b+c);
				}
			});
		}); 
		
		
		$("#addbtn").click(function(){
			$.ajax({
				type:"post",
				url:"/spring/addcart.action",
				data:$("#itemform").serialize(),
				success:function(result){
					console.log(result);
					if(result == 1){
						alert("장바구니 담기 성공");
						location.href="/spring/index.action";
					} else{
						alert("장바구니 담기 실패");
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
	<div data-role="page">
		<div data-role="header">
			<h1>상품 구매</h1>
		</div>
		<div role="main" class="ui-content">
			<img alt="로고" src="/spring/resources/img/main.jpg"
				style="width: 150px; margin-left: 80px;">
	
	<form id="itemform" action="/spring/addcart.action" method="post">		
			
			<div id="heading">
				<div>
					<img src="/spring/files/${dto.image}" alt="" />
				</div>
				<div>
					<span>${dto.menu }</span>
					<input id="count" name="count" type="number" placeholder="갯수 입력" required="required" />
				</div>
			</div>
			<div style="clear: both;"></div>
			<div id="bottom">
				
   
    <fieldset data-role="controlgroup" data-type="horizontal">
        <legend>Size:</legend>
        <input type="radio" name="menusize" id="small" value="small" checked="checked">
        <label id="ss" for="small"><span>Small</span></label>
        <input type="radio" name="menusize" id="regular" value="regular">
        <label for="regular"><span>Regular</span></label>
        <input type="radio" name="menusize" id="large" value="large">
        <label for="large"><span>Large</span></label>
    </fieldset>



	<fieldset data-role="controlgroup">
        <legend>Option:</legend>
		<c:forEach items="${options}" var="odto">
        <input type="checkbox" value="${odto.seq}" name="option" id="${odto.optionname }" >
        <label for="${odto.optionname }">${odto.optionname }</label>
		</c:forEach>        

    </fieldset>

	<div>
	 총 금액: 
		<span id="total"></span>원
		<input id="totalprice" name="payment" type="hidden" />
	</div>
	<input type="hidden" name="menuseq" value="${dto.seq}" />
	<input id="addbtn" type="button" value="장바구니담기" />
	
	</form>
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