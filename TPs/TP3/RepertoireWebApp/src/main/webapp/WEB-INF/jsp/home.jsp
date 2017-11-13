<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%-- Import --%>
	
	<%-- Variables --%>
	<%	
		String nbreCarnetsDisponibles = Integer.toString((Integer) request.getAttribute("nbreCarnetsDisponibles"));
		String addCallBack = (String) request.getAttribute("addCallBack");
		String updateCallBack = (String) request.getAttribute("updateCallBack");
		String deleteCallBack = (String) request.getAttribute("deleteCallBack");
		String errorMessage = (String) request.getAttribute("errorMessage");
	%>

<%-- HTML5 --%>
<!DOCTYPE html>
<html>
	<%-- HEAD --%>
	<jsp:include page="head.jsp" />
	
	<%-- BODY --%>
	<body>
	<div id="main_wrapper">
	<%-- HEADER : en-tête --%>
	<jsp:include page="header.jsp" />
	
	<%-- SECTION DE PAGE --%>
	<section id="sectionMainContent">

		<% if (nbreCarnetsDisponibles != null) { %>
			<p class="infoNotification">Il y a <%=nbreCarnetsDisponibles%> annuaires accessibles sur le serveur.<p>
		<% } %>
		<% if (addCallBack != null) { %>
			<p class="infoNotification"><%=addCallBack%><p>
		<% } %>
		<% if (updateCallBack != null) { %>
			<p class="infoNotification"><%=updateCallBack%><p>
		<% } %>
		<% if (deleteCallBack != null) { %>
			<p class="infoNotification"><%=deleteCallBack%><p>
		<% } %>
		<% if (errorMessage != null) { %>
			<p class="errorNotification"><%=errorMessage%><p>
		<% } %>
		
		<%-- MENU : liens principaux de navigation --%>
		<jsp:include page="menu.jsp" />
		
	</section>
	
	<%-- FOOTER : pied de page --%>
	<jsp:include page="footer.jsp" />
	</div>
	
	<%-- Javascript --%>
	<script type="text/javascript" charset="utf-8">
	</script>
</body>
</html>