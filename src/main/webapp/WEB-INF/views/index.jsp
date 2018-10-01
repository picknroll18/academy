<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
	<section>
		<h1>${academy.name }</h1>
		<ul>
		<c:forEach var="mainMenu" items="${academy.mainMenus }">
			<li>${mainMenu.title }</li>
		</c:forEach>
		</ul>
	</section>
</main>