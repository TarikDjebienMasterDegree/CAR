<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ page import="com.miage.RepertoireWebApp.entity.User" %>

<%-- HTML5 --%>
<header>
	<div id="logoApp">
		<img id="carTp3Logo" src="<%=request.getContextPath()%>/CharteGraphiqueCAR/images/logos/logo_icon.png" alt="Univ Lille1 Logo" />
	</div>
	<div id="titre_principal">
		<h1>CAR TP3</h1>
		<div id="userInfos">
			<h2 id="connectionInfo">Connected as <%=((User)request.getSession().getAttribute("userInfo")).toString()%></h2>
		</div>
	</div>
	
	<nav id="navigator">
		<ul>
			<li>
				<span id="logout"><a href="<%=request.getContextPath()%>/logout">Quitter</a></span>
			</li>
		</ul>
	</nav>
</header>

<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">
</script>	