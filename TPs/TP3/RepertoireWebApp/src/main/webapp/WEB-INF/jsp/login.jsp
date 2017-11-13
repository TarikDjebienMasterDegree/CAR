<?xml version="1.0" encoding="UTF-8" ?>

<%-- IMPORT --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- VARIABLES --%>
<%
	String authentificationFailed = (String) request.getAttribute("authentificationFailed");
%>

<%-- HTML5 --%>
<!DOCTYPE html>
<html>

<%-- HEAD --%>
<jsp:include page="head.jsp" />

<%-- BODY --%>
<body>
	<div id="main_wrapper">
		<%-- HEADER --%>
		<header>
			<h1>TP3 - CAR - Authentification</h1>
		</header>

		<%-- CONTENU --%>
		<section id="sectionLogin">

			<%-- FORMULAIRE D'AUTHENTIFICATION --%>
			<form action="login.Form" method="post">

				<div class="align">
					<label for="j_username">Login</label> <input id="j_username"
						name="j_username" size="20" maxlength="50" type="text" />
				</div>
				<div class="align">
					<label for="j_password">Password</label> <input id="j_password"
						name="j_password" size="20" maxlength="50" type="password" />
				</div>
				<div id="loginFormButton" class="alignButton">
					<input id="login_button" class="carButton loginButton"
						value="Login" type="submit" /> <input value="reset"
						class="carButton loginButton" type="reset" />
				</div>

			</form>
			<%
				if (authentificationFailed != null) {
			%>
			<p id="loginInvalidMessage" class="ui-state-error"><%=authentificationFailed%></p>
			<%
				}
			%>
		</section>

		<%-- FOOTER --%>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
