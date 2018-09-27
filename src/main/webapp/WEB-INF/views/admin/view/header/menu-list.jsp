<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
	<form method="POST" enctype="multipart/form-data">
	<section id="section">
		<h1>메뉴 목록</h1>
		<ul>
			<c:forEach var="menu" items="${menus}">
				<li>
					<input type="checkbox" name="menu-id" value="${menu.id}" /><span>${menu.title}</span>
					<input type="submit" name="action" value="수정" onclick="document.querySelector('.selected-menu-id').value = this.parentElement.firstElementChild.value" />
				</li>
			</c:forEach>
			<!-- <li>
				<input type="checkbox" value="" /><span></span>
			</li> -->
		</ul>
		<fieldset>
			<legend>메뉴 입력 필드</legend>
			<div>
				<label>이름: </label>
				<input name="title" value="${selectedMenu.title}" />
			</div>
			<div>
				<label>url: </label>
				<input name="url" value="${selectedMenu.url}" />
			</div>
		</fieldset>
		<div>
			<!-- 버튼 하나를 누르면 해당 버튼의 값만 전달된다. 
				name은 키, value는 값-->
			<!-- 사용자는 안보이는 곳에 checkbox에서 check된 정보(value값)을 임시로 받아둔다. -->
			<input type="hidden" name="selected-menu-id" class="selected-menu-id" value="${selectedMenu.id}"/>
			<input type="submit" name="action" value="일괄삭제" />
			<input type="submit" name="action" value="저장" />
			<input type="submit" name="action" value="추가" />
			<!-- 그냥 button 또는 서버단에서 쓰려면 submit -->
		</div>
	</section>
	</form>	
</main>
