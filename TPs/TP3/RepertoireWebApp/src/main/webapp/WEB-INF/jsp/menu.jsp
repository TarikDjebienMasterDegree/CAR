<%@page import="java.util.Collections"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Import --%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.miage.RepertoireWebApp.entity.Personne"%>
<%-- Variables --%>
<%
	Map<String, List<Personne>> lesAnnuaires = (Map<String, List<Personne>>) request.getAttribute("lesAnnuaires");
%>

<%-- HTML5 --%>

<%
	if (lesAnnuaires != null) {
%>
<nav id="menu">

	<%
		for (String idCarnet : lesAnnuaires.keySet()) {
	%>
	<h1>
		<a href="#">Carnet : <%=idCarnet%></a>
	</h1>
	<div>

		<div class="addForm">
			<form id="addPersonneForm_<%=idCarnet%>" action="addPersonne.Form"
				method="post">
				<fieldset>
					<legend>Ajouter une fiche</legend>
					<p>
						<label for="add_nom">Nom : </label><input type="text" size="20" name="add_nom" />
					</p>
					<p>
						<label for="add_email">Email : </label><input type="text" size="30" name="add_email" />
					</p>
					<p>
						<label for="add_url">Url : </label><input type="text" size="30" name="add_url" />
					</p>
					<p>
						<label for="add_info">Info : </label><input type="text" size="40" name="add_info" />
					</p>
					<p>
						<input class="submit" type="submit" value="Ajouter" />
					</p>
					<p>
						<input type="hidden" value="<%=idCarnet%>" name="add_idCarnet"/>
					</p>
				</fieldset>
			</form>
		</div>

		<table class="dataTables">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Email</th>
					<th>Url</th>
					<th>Info</th>
					<th>Mise a jour</th>
					<th>Supprimer</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Personne> lesPersonnesDuCarnet = lesAnnuaires.get(idCarnet);
				if(lesPersonnesDuCarnet!=null && !lesPersonnesDuCarnet.isEmpty()) {
					for (Personne personne : lesPersonnesDuCarnet) {
				%>
				<tr>
					<form id="updatePersonneForm_<%=idCarnet%>" action="updatePersonne.Form" method="post">
					<td>
						<input type="text" size="20" name="update_nom" value="<%=personne.getNom()%>"/>
						<span style="visibility: hidden; display: none;"><%=personne.getNom()%></span>
					</td>
					<td>
						<input type="text" size="30" name="update_email" value="<%=personne.getEmail()%>"/>
						<span style="visibility: hidden; display: none;"><%=personne.getEmail()%></span>
					</td>
					<td>
						<input type="text" size="30" name="update_url" value="<%=personne.getUrl()%>"/>
						<span style="visibility: hidden; display: none;"><%=personne.getUrl()%></span>
					</td>
					<td>
						<input type="text" size="40" name="update_info" value="<%=personne.getInfo()%>"/>
						<span style="visibility: hidden; display: none;"><%=personne.getInfo()%></span>
					</td>
					<td>
						<input type="hidden" value="<%=idCarnet%>" name="update_idCarnet"/>
						<input class="submit carButton" type="submit" value="Update" />
					</td>
					</form>
					<td>
						<div class="deleteForm">
							<form id="deletePersonneForm_<%=idCarnet%>" action="deletePersonne.Form"
								method="post">
										<input type="hidden" size="20" name="delete_nom" value="<%=personne.getNom()%>" />
										<input class="submit carButton" type="submit" value="Delete" />
										<input type="hidden" value="<%=idCarnet%>" name="delete_idCarnet"/>
							</form>
						</div>
					</td>
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>
	</div>
	<%
		}
	%>

</nav>
<%
	}
%>

<%-- JavaScript --%>
<script>

 $("#menu").accordion({
 	autoHeight: false,
 	navigation: true
 });

 $(".dataTables").dataTable({"bJQueryUI": true} );

</script>