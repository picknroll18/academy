<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<header id="header" class="flex flex-row">
	<h1><a href=""><img src="/academy/resources/partners/sist/images/logo.png" alt="쌍용교육센터" /></a></h1>
	<section class="bg-white main-menu flex-item-push">
		<h1 class="hidden">헤더 메뉴</h1>
		<ul class="hidden main-menu-list show-md-block">
			<c:forEach var="menu" items="${mainMenus}">
				<li><a href="${menu.id}">${menu.title}</a></li>
			</c:forEach>
<!-- 			<li><a href="">센터소개</a></li> -->
<!-- 			<li><a href="">재직자교육과정</a> -->
<!-- 			<li><a href="">취업교육과정</a></li> -->
<!-- 			<li><a href="">예약센터</a></li> -->
<!-- 			<li><a href="">교육서비스</a></li> -->
<!-- 			<li><a href="">인재추천의뢰</a></li> -->
<!-- 			<li><a href="">고객센터</a></li> -->
		</ul>
		<div>
			<h2 class="hidden">메뉴 버튼들</h2>
			<span class="hidden">검색버튼</span>
			<span class="btn btn-hamburger btnㅡmd-hamburger">확장버튼</span> 
			<!-- div는 박스, 블럭단위, span은 inline 단위 -->
		</div>
	</section>
	<section class="hidden bg-gray">
		<h1>홍보</h1>
		<div class="content">로고 최우수 훈련기관 5년 인증 선정 : 최상위 1%만 선정 - 고용노동부</div>
	</section>
</header>