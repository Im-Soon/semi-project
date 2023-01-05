<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_ahn.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cart.js"></script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="cart-main">
		<h3>담은 상품 목록</h3>
		<div class="result-display">
			<div class="content-main">
		<c:if test="${product.status == 1}">
		<div class="result-display">
			<div class="align-center">
				본 상품은 판매 중지 되었습니다.<p>
				<input type="button" value="판매상품 보기"
						onclick="location.href='productList.do'">
			</div>
		</div>
		</c:if>
		
		<c:if test="${product.status == 2}">
		<h3 class="align-center">${product.name}</h3>
		<div class="product-image">
			<img src="${pageContext.request.contextPath}/upload/${product.photo2}" width="400">
		</div>
		<div class="product-detail">
			<form id="product_cart" method="post">	
				<input type="hidden" name="pro_num" 
						value="${product.product_num}" id="pro_num">
				<input type="hidden" name="pro_price" 
						value="${product.price}" id="pro_price">
				<input type="hidden" name="pro_quantity" 
						value="${product.quantity}" id="pro_quantity">
				<ul>
					<li>가격 : <b><fmt:formatNumber value="${product.price}"/></b></li>
					<li>수량 : <b><fmt:formatNumber value="${product.quantity}"/></b></li>
					<c:if test="${product.quantity > 0}">
					<li>
						<label for="order_quatity">구매수량</label>
						<input type="number" name="order_quantity" min="1" 
							max="${product.quantity}" id="order_quantity" class="quantity-width">
					</li>
					<li>
						<input type="checkbox" class="cart_checkbox" checked="checked">
						<input type="submit" value="장바구니에 담기">
					</li>
					</c:if>
				</ul>
			</form>
		</div>
		</c:if>
		</div>
		
		<c:if test="${count > 0}">
		<table>
			<c:forEach var="product" items="${cart}">
			<a href="${pageContext.request.contextPath}/product/detail.do?pro_num=${product.pro_num}"></a>
			<tr>
				<td>${product.pro_picture}</td>
				<td>${product.pro_name}</td>
				<td>${product.pro_price}</td>
			</tr>
			</c:forEach>
		</table>
		<div class="align-center">${page}</div>
		</c:if>
		</div>
	</div>
	<div class="cart-side">
		<div class="cart-sub">
			<div class="content-main">
				<h2>선택한 상품 목록</h2>
				<c:if test="${empty list}">
				<div class="result-display">
					장바구니에 담은 상품이 없습니다.
				</div>
				</c:if>
				<c:if test="${!empty list}">
					<form id="cart_order" method="post" action="${pageContext.request.contextPath}/order/orderform.do">
						<table>
							<c:forEach var="cart" items="${list}">
							<tr>
								<td>
									<a href="${pageContext.request.contextPath}/product/detail.do?pro_num=${cart.pro_num}">
										${cart.productVo.name}
									</a>
								</td>
								<td class="align-center">
									<fmt:formatNumber value="${cart.productVo.price}"/>원
								</td>
								<td class="align-center">
									<fmt:formatNumber value="${cart.sub_total}"/>원
								</td>
							</tr>
							</c:forEach>
						</table>
						<div class="align-center cart-submit">
							<input type="submit" value="구매하기">
						</div>
					</form>
				</c:if>
			</div>
		</div>
		<div class="price-total">
			<h3>총 금액</h3>
			<form id="product_cart" method="post">	
				<input type="hidden" name="pro_num" 
						value="${product.pro_num}" id="pro_num">
				<input type="hidden" name="pro_price" 
						value="${product.price}" id="pro_price">
				<input type="hidden" name="pro_quantity" 
						value="${product.quantity}" id="pro_quantity">
				<ul>
					<c:if test="${product.quantity > 0}">
					<li>
						<span id="pro_total_txt">총주문 금액 : 0원</span>
					</li>
					</c:if>
				</ul>
			</form>
		</div>
	</div>
	<%-- <jsp:include page="/WEB-INF/views/common/footer.jsp"/> --%>
</div>
</body>
</html>